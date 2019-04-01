package com.framework.framework.rocketmq;

import com.hykit.exceptionutils.ApplicationException;
import com.hykit.logutils.LogHelper;
import com.hykit.stringutils.StringUtil;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RocketMQConsumerConfig
 * @Description: RocketMQ消费者配置
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-11 22:53
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-11   hy              v1.0.0             Is Create!
 */
@Configuration
@Component
public class RocketMQConsumeConfig {

    @Value("${rocketmq.consumer.namesrvAddr}")
    private String namesrvAddr;
    @Value("${rocketmq.consumer.groupName}")
    private String groupName;
    @Value("${rocketmq.consumer.consumeThreadMin}")
    private int consumeThreadMin;
    @Value("${rocketmq.consumer.consumeThreadMax}")
    private int consumeThreadMax;
    @Value("${rocketmq.consumer.topic}")
    private String topic;
    @Value("${rocketmq.consumer.tag}")
    private String tag;
    @Value("${rocketmq.consumer.consumeMessageBatchMaxSize}")
    private int consumeMessageBatchMaxSize;
    @Value("${rocketmq.consumer.reconsumeTimes}")
    public Integer reconsumeTimes;

    private final RocketMQMessageProcessor rocketMQMessageProcessor;

    @Autowired
    public RocketMQConsumeConfig(RocketMQMessageProcessor rocketMQMessageProcessor) {
        this.rocketMQMessageProcessor = rocketMQMessageProcessor;
    }

    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer() throws ApplicationException {
        if (StringUtil.isEmpty(this.groupName)){
            throw new ApplicationException("groupName is null !!!");
        }
        if (StringUtil.isEmpty(this.namesrvAddr)){
            throw new ApplicationException("namesrvAddr is null !!!");
        }
        if(StringUtil.isEmpty(this.topic)){
            throw new ApplicationException("topic is null !!!");
        }
        if (StringUtil.isBlank(this.tag)) {
            throw new ApplicationException("tag is null !!!");
        }
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(this.groupName);
        consumer.setNamesrvAddr(this.namesrvAddr);
        consumer.setConsumeThreadMin(this.consumeThreadMin);
        consumer.setConsumeThreadMax(this.consumeThreadMax);

        //消息监听器
        RocketMQConsumeListener rocketMQConsumeListener = new RocketMQConsumeListener(this);
        rocketMQConsumeListener.setRocketMQMessageProcessor(this.rocketMQMessageProcessor);
        consumer.registerMessageListener(rocketMQConsumeListener);

        // 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
        // 如果非第一次启动，那么按照上次消费的位置继续消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        // 设置消费模型，集群还是广播，默认为集群
        //consumer.setMessageModel(MessageModel.CLUSTERING);

        // 设置一次消费消息的条数，默认为1条
        consumer.setConsumeMessageBatchMaxSize(this.consumeMessageBatchMaxSize);

        try {
            // 设置该消费者订阅的主题和tag，如果是订阅该主题下的所有tag，则tag使用*；如果需要指定订阅该主题下的某些tag，则使用||分割，例如tag1||tag2||tag3
            consumer.subscribe(this.topic, "*");
            consumer.start();
            LogHelper.print("consumer is start !!!", new String[]{"groupName", "topic", "namesrvAddr"}, this.groupName, this.topic, this.namesrvAddr);
        }catch (MQClientException e){
            LogHelper.print("consumer is start Error!!!", new String[]{"groupName", "topic", "namesrvAddr"}, this.groupName, this.topic, this.namesrvAddr);
            throw new ApplicationException(e);
        }
        return consumer;
    }
}

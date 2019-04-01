package com.framework.framework.rocketmq;

import com.hykit.exceptionutils.ApplicationException;
import com.hykit.logutils.LogHelper;
import com.hykit.stringutils.StringUtil;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RocketMQProducerConfig
 * @Description: RocketMQ生产者配置
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-11 22:37
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-11   hy              v1.0.0             Is Create!
 */
@Configuration
@Component
public class RocketMQProducerConfig {
    /**
     * 发送同一类消息的设置为同一个group，保证唯一,默认不需要设置，rocketmq会使用ip@pid(pid代表jvm名字)作为唯一标示
     */
    @Value("${rocketmq.producer.groupName}")
    private String groupName;
    @Value("${rocketmq.producer.namesrvAddr}")
    private String namesrvAddr;
    /**
     * 消息最大大小，默认4M
     */
    @Value("${rocketmq.producer.maxMessageSize}")
    private Integer maxMessageSize ;
    /**
     * 消息发送超时时间，默认3秒
     */
    @Value("${rocketmq.producer.sendMsgTimeout}")
    private Integer sendMsgTimeout;
    /**
     * 消息发送失败重试次数，默认2次
     */
    @Value("${rocketmq.producer.retryTimesWhenSendFailed}")
    private Integer retryTimesWhenSendFailed;

    /**
     * 消息发送的Topic(组)
     */
    @Value("${rocketmq.producer.topic}")
    public String topic;

    @Bean
    public DefaultMQProducer getRocketMQProducer() throws ApplicationException {
        if (StringUtil.isEmpty(this.groupName)) {
            throw new ApplicationException("groupName is blank");
        }
        if (StringUtil.isEmpty(this.namesrvAddr)) {
            throw new ApplicationException("nameServerAddr is blank");
        }
        DefaultMQProducer producer;
        producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(this.namesrvAddr);
        producer.setVipChannelEnabled(false);

        //集群模式配置项
        //如果需要同一个jvm中不同的producer往不同的mq集群发送消息，需要设置不同的instanceName
        //producer.setInstanceName(instanceName);

        if (this.maxMessageSize != null) {
            producer.setMaxMessageSize(this.maxMessageSize);
        }
        if (this.sendMsgTimeout != null) {
            producer.setSendMsgTimeout(this.sendMsgTimeout);
        }
        //如果发送消息失败，设置重试次数，默认为2次
        if (this.retryTimesWhenSendFailed != null) {
            producer.setRetryTimesWhenSendFailed(this.retryTimesWhenSendFailed);
        }

        try {
            producer.start();
            LogHelper.print("producer is start ! ",new String[]{"groupName", "topic", "namesrvAddr"}, this.groupName, this.topic, this.namesrvAddr);
        } catch (MQClientException e) {
            LogHelper.error(e);
            throw new ApplicationException(e);
        }
        return producer;
    }
}

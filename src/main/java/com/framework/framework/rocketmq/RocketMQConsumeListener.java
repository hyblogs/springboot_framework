package com.framework.framework.rocketmq;

import com.hykit.logutils.LogHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RocketMQConsumeListener
 * @Description: RocketMQ消费者监听器
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-13 10:37
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-13   hy              v1.0.0             Is Create!
 */
@Component
public class RocketMQConsumeListener implements MessageListenerConcurrently {

    private RocketMQConsumeConfig rocketMQConsumeConfig;
    private RocketMQMessageProcessor rocketMQMessageProcessor;

    public RocketMQConsumeListener(RocketMQConsumeConfig rocketMQConsumeConfig) {
        this.rocketMQConsumeConfig = rocketMQConsumeConfig;
    }

    void setRocketMQMessageProcessor(RocketMQMessageProcessor rocketMQMessageProcessor) {
        this.rocketMQMessageProcessor = rocketMQMessageProcessor;
    }

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        LogHelper.logRequest("RocketMQ消息消费", new String[]{"msgs", "context"}, msgs, context);
        if(CollectionUtils.isEmpty(msgs)){
            LogHelper.error("接受到的消息为空，不处理，直接返回成功");
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        try {
            for (MessageExt msg : msgs) {
                //调用RocketMQ处理器接口（RocketMQ不保证消息不重复，如果你的业务需要保证严格的不重复消息，需要你自己在业务端去重）
                boolean result = this.rocketMQMessageProcessor.processorRocketMQMessage(msg);
                if (!result){
                    //获取该消息重试次数
                    int reconsume = msg.getReconsumeTimes();
                    if(this.rocketMQConsumeConfig.reconsumeTimes != null && reconsume > this.rocketMQConsumeConfig.reconsumeTimes){
                        LogHelper.print("RocketMQ消息消费", "已经重试消费3次仍然消费失败，即将返回成功");
                        //消息已经重试了3次以上，如果不需要再次消费，则返回成功
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                    LogHelper.print("RocketMQ消息消费", "消息消费失败！！");
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("RocketMQ消息消费异常", e);
        }
        // 如果没有return success ，consumer会重新消费该消息，直到return success
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

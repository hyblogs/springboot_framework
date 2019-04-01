package com.framework.framework.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.hykit.logutils.LogHelper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RabbitConsumerService
 * @Description: Rabbit消息消费者
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 11:16
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@Service
public class RabbitConsumerService {

    @RabbitListener(queues = "hy")
    public void receiveMessageFromQueue(Message message) {
        LogHelper.logRequest("RabbitMQ消息消费者接收推送", message);
        try {
            MessageProperties messageProperties = message.getMessageProperties();
            Object object = JSON.parse(message.getBody());
            if ("hy".equals(messageProperties.getType())) {
                System.out.println("Rabbit消息：" + object);
            }
        } catch (Exception e) {
            LogHelper.error("RabbitMQ消息消费异常", e);
        }
    }
}

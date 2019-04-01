package com.framework.framework.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hykit.idutils.IdWorker;
import com.hykit.logutils.LogHelper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RabbitSendService
 * @Description: RabbitMQ生产者(消息发送器)
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 11:04
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@Service
public class RabbitSendService {

    private final RabbitTemplate rabbitTemplate;

    private final RabbitConfig rabbitConfig;

    @Autowired
    public RabbitSendService(RabbitTemplate rabbitTemplate, RabbitConfig rabbitConfig) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitConfig = rabbitConfig;
    }

    /**
     * Rabbit发送消息(非延时)
     * @param type 消息类型
     * @param object 消息内容
     * @return 是否发送成功：true/false
     */
    public Boolean sendMessage(String type, Object object) {
        try {
            String uuId = IdWorker.get32UUID();
            Message message = MessageBuilder.withBody(JSON.toJSONBytes(object, SerializerFeature.NotWriteDefaultValue))
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON).setCorrelationId(uuId).setType(type).build();
            //发送消息
            this.send(uuId, message);
            return true;
        } catch (Exception e) {
            LogHelper.error("RabbitMQ发送消息异常", e);
            return false;
        }
    }

    /**
     * Rabbit发送延时消息(不可用)
     * @param type 消息类型
     * @param object 消息内容
     * @param expiration 消息延时时间(毫秒)
     * @return 是否发送成功：true/false
     */
    public Boolean sendExpireMessage(String type, Object object, String expiration) {
        try {
            //消息唯一标识
            String uuId = IdWorker.get32UUID();
            //消息体信息
            Message message = MessageBuilder.withBody(JSON.toJSONBytes(object, SerializerFeature.NotWriteDefaultValue))
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON).setCorrelationId(uuId).setType(type)
                    .setExpiration(expiration).build();
            //发送消息
            this.send(uuId, message);
            return true;
        } catch (Exception e) {
            LogHelper.error("RabbitMQ发送延时消息异常", e);
            return false;
        }
    }

    /**
     * Rabbit发送消息公共方法
     * @param uuId 消息唯一标识
     * @param object 消息
     * @throws Exception 异常
     */
    private void send(String uuId, Object object) throws Exception {
        try {
            CorrelationData correlationId = new CorrelationData(uuId);
            this.rabbitTemplate.convertAndSend(this.rabbitConfig.directExchangeName, this.rabbitConfig.firstQueueName,
                    object, correlationId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}

package com.framework.framework.rabbitmq;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: MsgSendConfirmCallBack
 * @Description: 消息发送到交换机确认机制
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 10:59
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("MsgSendConfirmCallBack  , 回调id:" + correlationData);
        if (b) {
            System.out.println("消息消费成功");
        } else {
            System.out.println("消息消费失败:" + b+"\n重新发送");
        }
    }
}

package com.framework.rabbitmq;

import com.framework.framework.rabbitmq.RabbitSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RabbitMqTest
 * @Description: RabbitMQ测试类
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 09:55
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    private RabbitSendService rabbitSendService;

    @Test
    public void sendMessageTest() {
        String msg = "瓜婆娘-哈哈哈";
        String type = "hy";
        Boolean isSendSuc = this.rabbitSendService.sendMessage(type, msg);
        System.out.println(isSendSuc);
    }

    @Test
    public void sendExpireMessageTest() {
        String msg = "瓜婆娘-哈哈哈-二哈";
        String type = "hy";
        String expiration = "20000";
        Boolean isSendSuc = this.rabbitSendService.sendExpireMessage(type, msg, expiration);
        System.out.println(isSendSuc);
    }
}

package com.framework.rocketmq;

import com.framework.framework.rocketmq.RocketMQSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RocketMQTest
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-13 11:28
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-13   hy              v1.0.0             Is Create!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketMQTest {
    @Autowired
    private RocketMQSendService rocketMQSendService;

    @Test
    public void sendMsgTest() {
        rocketMQSendService.sendMsg(null, "huangyong", "123456789", "Hello World");
    }
}

package com.framework.framework.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RabbitQueueConfig
 * @Description: Rabbit队列配置
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 11:32
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@Configuration
public class RabbitQueueConfig {

    private final RabbitAdmin rabbitAdmin;

    private final RabbitConfig rabbitConfig;

    @Autowired
    public RabbitQueueConfig(RabbitAdmin rabbitAdmin, RabbitConfig rabbitConfig) {
        this.rabbitAdmin = rabbitAdmin;
        this.rabbitConfig = rabbitConfig;
    }

    /**
     * durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
     * auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
     * exclusive  表示该消息队列是否只在当前connection生效,默认是false
     */
    @Bean
    Queue firstQueue() {
        Queue queue = new Queue(this.rabbitConfig.firstQueueName, true);
        this.rabbitAdmin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue secondQueue() {
        Queue queue = new Queue(this.rabbitConfig.secondQueueName, true);
        this.rabbitAdmin.declareQueue(queue);
        return queue;
    }
}

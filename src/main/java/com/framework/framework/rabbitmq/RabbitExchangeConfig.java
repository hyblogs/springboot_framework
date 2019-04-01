package com.framework.framework.rabbitmq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RabbitExchangeConfig
 * @Description: Rabbit交换机配置及队列配置
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 10:22
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@Configuration
public class RabbitExchangeConfig {

    private final RabbitAdmin rabbitAdmin;

    private final RabbitConfig rabbitConfig;

    @Autowired
    public RabbitExchangeConfig(RabbitAdmin rabbitAdmin, RabbitConfig rabbitConfig) {
        this.rabbitAdmin = rabbitAdmin;
        this.rabbitConfig = rabbitConfig;
    }

    @Bean
    FanoutExchange contractFanoutExchange() {
        FanoutExchange fanoutExchange = new FanoutExchange(this.rabbitConfig.fanoutExchangeName);
        this.rabbitAdmin.declareExchange(fanoutExchange);
        return fanoutExchange;
    }

    @Bean
    TopicExchange contractTopicExchangeDurable() {
        TopicExchange contractTopicExchange = new TopicExchange(this.rabbitConfig.topicExchangeName);
        this.rabbitAdmin.declareExchange(contractTopicExchange);
        return contractTopicExchange;
    }

    /**
     *   1.定义direct exchange，绑定queueTest
     *   2.durable="true" rabbitmq重启的时候不需要创建新的交换机
     *   3.direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     *     fanout交换器中没有路由键的概念，他会把消息发送到所有绑定在此交换器上面的队列中。
     *     topic交换器你采用模糊匹配路由键的原则进行转发消息到队列中
     *   key: queue在该direct-exchange中的key值，当消息发送给direct-exchange中指定key为设置值时，
     *   消息将会转发给queue参数指定的消息队列
     */
    @Bean
    DirectExchange contractDirectExchange() {
        DirectExchange contractDirectExchange = new DirectExchange(this.rabbitConfig.directExchangeName);
        this.rabbitAdmin.declareExchange(contractDirectExchange);
        return contractDirectExchange;
    }
}

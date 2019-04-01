package com.framework.framework.rabbitmq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RabbitListenerConfig
 * @Description: Rabbit监听器配置
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 10:43
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@Configuration
@EnableRabbit
public class RabbitListenerConfig implements RabbitListenerConfigurer {

    private final RabbitConfig rabbitConfig;
    private final RabbitQueueConfig rabbitQueueConfig;
    private final RabbitExchangeConfig rabbitExchangeConfig;
    private final ConnectionFactory connectionFactory;

    @Autowired
    public RabbitListenerConfig(RabbitConfig rabbitConfig, RabbitQueueConfig rabbitQueueConfig,
                                RabbitExchangeConfig rabbitExchangeConfig, ConnectionFactory connectionFactory) {
        this.rabbitConfig = rabbitConfig;
        this.rabbitQueueConfig = rabbitQueueConfig;
        this.rabbitExchangeConfig = rabbitExchangeConfig;
        this.connectionFactory = connectionFactory;
    }

    @Value("${spring.rabbitmq.maxConcurrentConsumer}")
    private int maxConcurrentConsumer;
    @Value("${spring.rabbitmq.concurrentConsumer}")
    private int concurrentConsumer;

    /**
     将消息队列1和交换机进行绑定
     */
    @Bean
    public Binding bindingOne() {
        return BindingBuilder.bind(this.rabbitQueueConfig.firstQueue()).to(this.rabbitExchangeConfig.contractDirectExchange()).with(this.rabbitConfig.firstQueueName);
    }

    /**
     * 将消息队列2和交换机进行绑定
     */
    @Bean
    public Binding bindingTwo() {
        return BindingBuilder.bind(this.rabbitQueueConfig.secondQueue()).to(this.rabbitExchangeConfig.contractDirectExchange()).with(this.rabbitConfig.secondQueueName);
    }

    /**
     * queue listener  观察 监听模式
     * 当有消息到达时会通知监听在对应的队列上的监听对象
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainerOne(){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(this.connectionFactory);
        simpleMessageListenerContainer.addQueues(this.rabbitQueueConfig.firstQueue());
        simpleMessageListenerContainer.setExposeListenerChannel(true);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(this.maxConcurrentConsumer);
        simpleMessageListenerContainer.setConcurrentConsumers(this.concurrentConsumer);
        //设置确认模式手工确认
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return simpleMessageListenerContainer;
    }

    /**
     * queue listener  观察 监听模式
     * 当有消息到达时会通知监听在对应的队列上的监听对象
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainerTwo(){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer(this.connectionFactory);
        simpleMessageListenerContainer.addQueues(this.rabbitQueueConfig.secondQueue());
        simpleMessageListenerContainer.setExposeListenerChannel(true);
        simpleMessageListenerContainer.setMaxConcurrentConsumers(this.maxConcurrentConsumer);
        simpleMessageListenerContainer.setConcurrentConsumers(this.concurrentConsumer);
        //设置确认模式手工确认
        simpleMessageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return simpleMessageListenerContainer;
    }

    @Bean
    public DefaultMessageHandlerMethodFactory handlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(new MappingJackson2MessageConverter());
        return factory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(this.connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return factory;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(this.handlerMethodFactory());
    }
}

package com.framework.framework.rocketmq;

import com.hykit.byteutils.ByteArrayUtil;
import com.hykit.logutils.LogHelper;
import com.hykit.stringutils.StringUtil;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RocketMQSendService
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-13 10:49
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-13   hy              v1.0.0             Is Create!
 */
@Service
public class RocketMQSendService {

    private RocketMQProducerConfig rocketMQProducerConfig;
    private final DefaultMQProducer defaultMQProducer;

    @Autowired
    public RocketMQSendService(RocketMQProducerConfig rocketMQProducerConfig, DefaultMQProducer defaultMQProducer) {
        this.rocketMQProducerConfig = rocketMQProducerConfig;
        this.defaultMQProducer = defaultMQProducer;
    }

    /**
     * 发送消息
     * @param topic 组
     * @param tag 标签
     * @param key key
     * @param value 消息值
     */
    public void sendMsg(String topic, String tag, String key, Object value) {
        LogHelper.logRequest("RocketMQ发送非延时消息", new String[]{"topic", "tag", "key", "value"}, topic, tag, key, value);
        try {
            send(topic, tag, key, value, null);
        } catch (RemotingException | MQClientException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送延时消息
     * @param topic 组
     * @param tag 标签
     * @param key key
     * @param value 消息值
     * @param delayed 延时标识：1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
     *                注：传入参数的时候传入对应的顺序值；如延时 10s 则传入 3 .
     */
    public void sendMsgByDelayed(String topic, String tag, String key, Object value, Integer delayed) {
        LogHelper.logRequest("RocketMQ发送延时消息", new String[]{"topic", "tag", "key", "value", "delayed"}, topic, tag, key, value, delayed);
        try {
            send(topic, tag, key, value, delayed);
        } catch (RemotingException | MQClientException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息本类公用方法
     * @param topic 组
     * @param tag 标签
     * @param key key
     * @param value 消息值
     * @param delayed 延时标识：1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
     *                注：传入参数的时候传入对应的顺序值；如延时 10s 则传入 3 .
     * @throws RemotingException 远程异常
     * @throws MQClientException MQ连接异常
     * @throws InterruptedException 中断异常
     */
    private void send(String topic, String tag, String key, Object value, Integer delayed) throws RemotingException, MQClientException, InterruptedException {
        if (StringUtil.isBlank(topic)) {
            topic = this.rocketMQProducerConfig.topic;
        }

        Message message = new Message(topic, tag, StringUtil.append(tag, "-", key), ByteArrayUtil.objectTransForByteArray(value));
        if (delayed != null) {
            message.setDelayTimeLevel(delayed);
        }

        LogHelper.logRequest("RocketMQ发送消息", new String[]{"topic", "tag", "key", "value", "delayed"}, topic, tag, key, value, delayed);
        this.defaultMQProducer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                LogHelper.print("RocketMQ-SendResult", sendResult);
            }

            @Override
            public void onException(Throwable e) {
                LogHelper.error("RocketMQ-SendException", e);
            }
        });
    }
}

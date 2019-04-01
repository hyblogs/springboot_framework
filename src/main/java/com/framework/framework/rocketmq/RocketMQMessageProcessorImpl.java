package com.framework.framework.rocketmq;

import com.hykit.byteutils.ByteArrayUtil;
import com.hykit.logutils.LogHelper;
import com.hykit.stringutils.StringUtil;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RocketMQMessageProcessorImpl
 * @Description: RocketMQ消息处理器接口实现类(可根据具体业务需要移动到其他包下面)
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-13 15:03
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-13   hy              v1.0.0             Is Create!
 */
@Service
public class RocketMQMessageProcessorImpl implements RocketMQMessageProcessor {

    @Override
    public boolean processorRocketMQMessage(MessageExt messageExt) {
        try {
            String topic = messageExt.getTopic();
            String tag = messageExt.getTags();
            String key = messageExt.getKeys();
            Object body = ByteArrayUtil.byteArrayTransForObj(messageExt.getBody());
            if(StringUtil.isNotEmpty(tag) && StringUtil.isNotEmpty(key) && body != null) {
                LogHelper.print(key + "重试次数：" + messageExt.getReconsumeTimes());
                LogHelper.print(new String[]{"topic", "tag", "key", "body"}, topic, tag, key, body);

                //具体业务处理
                if ("huangyong".equals(tag)) {
                    //处理对应tag业务类型的代码
                    LogHelper.print("=======================RocketMQ消息消费成功==========================");
                    //如果消息消费失败则返回false，成功则不用管(程序最后会统一返回true)
                    if (false) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            LogHelper.error("RocketMQ消息消费处理异常", e);
        }
        return true;
    }
}

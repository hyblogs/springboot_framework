package com.framework.framework.rocketmq;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RocketMQMessageProcessor
 * @Description: RocketMQ消息处理器接口
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-13 15:02
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-13   hy              v1.0.0             Is Create!
 */
public interface RocketMQMessageProcessor {

    public boolean processorRocketMQMessage(MessageExt messageExt);
}

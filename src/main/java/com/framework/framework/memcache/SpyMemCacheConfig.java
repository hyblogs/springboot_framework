package com.framework.framework.memcache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SpyMemCacheConfig
 * @Description: MemCache配置文件
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-13 22:11
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-13   hy              v1.0.0             Is Create!
 */
@Component
@Configuration
public class SpyMemCacheConfig {
    /** MemCache-IP地址 */
    @Value("${memcache.ip}")
    public String ip;
    /** MemCache-Port */
    @Value("${memcache.port}")
    public int port;
}

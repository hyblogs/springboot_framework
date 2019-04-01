package com.framework.framework.mongodb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: MongoConfig
 * @Description: Mongo配置文件
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 15:06
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@Configuration
public class MongoConfig {
    /**
     * 连接MongoDB使用的账户名称
     */
    @Value("${spring.data.mongodb.username}")
    protected String userName;
    /**
     * 连接MongoDB使用的账户密码
     */
    @Value("${spring.data.mongodb.password}")
    protected String password;
    /**
     * 连接MongoDB对应的服务器地址
     */
    @Value("${spring.data.mongodb.uri}")
    public String uri;
    /**
     * 连接MongoDB对应服务器的端口
     */
    @Value("${spring.data.mongodb.port}")
    public Integer port;
    /**
     * 连接MongoDB上的对应的数据库
     */
    @Value("${spring.data.mongodb.database}")
    public String dbName;
    /**
     * 集合Collection名称
     */
    @Value("${spring.data.mongodb.collection-name}")
    public String collectionName;
    /**
     * 连接超时时间，单位毫秒
     */
    @Value("${spring.data.mongodb.timeout}")
    public Integer timeOut;
}

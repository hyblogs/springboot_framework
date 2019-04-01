package com.framework.framework.memcache;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SockIOPoolConfig
 * @Description: SockIOPool配置文件
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-14 15:24
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-14   hy              v1.0.0             Is Create!
 */
@Configuration
public class SockIOPoolConfig {
    @Value("${memcache.servers}")
    private String[] servers;
    @Value("${memcache.weights}")
    private Integer[] weights;
    @Value("${memcache.initConn}")
    private int initConn;
    @Value("${memcache.minConn}")
    private int minConn;
    @Value("${memcache.maxConn}")
    private int maxConn;
    @Value("${memcache.maxIdle}")
    private int maxIdle;
    @Value("${memcache.maintSleep}")
    private long maintSleep;
    @Value("${memcache.nagle}")
    private boolean nagle;
    @Value("${memcache.socketTO}")
    private int socketTO;
    @Value("${memcache.socketConnectTO}")
    private int socketConnectTO;

    @Bean
    public SockIOPool sockIOPool(){
        //获取连接池的实例
        SockIOPool pool = SockIOPool.getInstance();
        //设置服务器信息
        //服务器列表及其权重
        pool.setServers(this.servers);
        pool.setWeights(this.weights);
        //设置初始连接数、最小连接数、最大连接数、最大处理时间
        pool.setInitConn(this.initConn);
        pool.setMinConn(this.minConn);
        pool.setMaxConn(this.maxConn);
        pool.setMaxIdle(this.maxIdle);
        //设置连接池守护线程的睡眠时间
        pool.setMaintSleep(this.maintSleep);
        //设置TCP参数，连接超时
        pool.setNagle(this.nagle);
        //设置socket的读取等待超时值
        pool.setSocketTO(this.socketTO);
        pool.setSocketConnectTO(this.socketConnectTO);
        //初始化并启动连接池
        pool.initialize();
        return pool;
    }

    @Bean
    public MemCachedClient getMemCachedClient() {
        return new MemCachedClient();
    }
}

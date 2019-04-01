package com.framework.framework.memcache;

import com.hykit.logutils.LogHelper;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.Objects;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SpyMemCacheRunner
 * @Description: MemCache启动运行器
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-13 22:17
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-13   hy              v1.0.0             Is Create!
 */
@Component
public class SpyMemCacheRunner implements CommandLineRunner {

    private final SpyMemCacheConfig spyMemCacheConfig;

    private MemcachedClient memcachedClient = null;

    @Autowired
    public SpyMemCacheRunner(SpyMemCacheConfig spyMemCacheConfig) {
        this.spyMemCacheConfig = spyMemCacheConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            this.memcachedClient = new MemcachedClient(new InetSocketAddress(this.spyMemCacheConfig.ip, this.spyMemCacheConfig.port));
        } catch (Exception e) {
            LogHelper.error("SpyMemCacheRunner Init Error!!!", e);
            throw e;
        }
    }

    /**
     * 获得MemCache连接
     * @return MemCache连接
     */
    private MemcachedClient getClient() {
        try {
            return this.memcachedClient;
        } catch (Exception e) {
            LogHelper.error("Get SpyMemCachedClient Error", e);
        }
        return null;
    }

    /**
     * 向MemCache存入数据
     * set 在 key 存在时会覆盖已有数据
     * set 在 key 不存在时会新增 key-value 数据
     * @param key Key值
     * @param value 对应存入的数据
     * @param expTime 缓存失效时间
     */
    public void set(String key, Object value, int expTime) {
        try {
            Objects.requireNonNull(this.getClient()).set(key, expTime, value);
        } catch (Exception e) {
            LogHelper.error("Save Value To SpyMemCached Error", e);
        }
    }

    /**
     * 向MemCache存入数据
     * add 在 key 存在时不会成功
     * @param key Key值
     * @param value 对应存入的数据
     * @param expTime 缓存失效时间
     */
    public void add(String key, Object value, int expTime) {
        try {
            Objects.requireNonNull(this.getClient()).add(key, expTime, value);
        } catch (Exception e) {
            LogHelper.error("Save Value To SpyMemCached Error", e);
        }
    }

    /**
     * 根据Key获取对应存入MemCache缓存中的数据
     * @param key Key值
     * @return 缓存的数据
     */
    public Object get(String key) {
        try {
            return Objects.requireNonNull(this.getClient()).get(key);
        } catch (Exception e) {
            LogHelper.error("Get Value From SpyMemCached Error", e);
        }
        return null;
    }

    /**
     * 根据Key替换对应存入的数据值
     * replace 在 key 不存在时不会成功
     * @param key Key值
     * @param value 替换数据
     * @param expTime 缓存失效时间
     */
    public void replace(String key, Object value, int expTime) {
        try {
            Objects.requireNonNull(this.getClient()).replace(key, expTime, value);
        } catch (Exception e) {
            LogHelper.error("Replace Value For SpyMemCached Error", e);
        }
    }

    /**
     * 根据Key值删除MemCached中存储的数据
     * @param key Key值
     */
    public void delete(String key) {
        try {
            Objects.requireNonNull(this.getClient()).delete(key);
        } catch (Exception e) {
            LogHelper.error("Delete Key-Value From SpyMemCached Error", e);
        }
    }

    /**
     * 根据Key值删除MemCached中存储的数据(带CAS)
     * @param key Key值
     * @param cas CAS
     */
    public void deleteByCas(String key, long cas) {
        try {
            Objects.requireNonNull(this.getClient()).delete(key, cas);
        } catch (Exception e) {
            LogHelper.error("Delete Key-Value By CAS From SpyMemCached Error", e);
        }
    }

    /**
     * 在指定Key对应的Value上增加数据
     * @param key Key值
     * @param by 增加值
     */
    public void incr(String key, int by) {
        try {
            Objects.requireNonNull(this.getClient()).incr(key, by);
        } catch (Exception e) {
            LogHelper.error("Incr By SpyMemCached Error", e);
        }
    }

    public void incr(String key, long by) {
        try {
            Objects.requireNonNull(this.getClient()).incr(key, by);
        } catch (Exception e) {
            LogHelper.error("Incr By SpyMemCached Error", e);
        }
    }

    public void incr(String key, int by, long def) {
        try {
            Objects.requireNonNull(this.getClient()).incr(key, by, def);
        } catch (Exception e) {
            LogHelper.error("Incr By And Def SpyMemCached Error", e);
        }
    }

    public void incr(String key, long by, long def) {
        try {
            Objects.requireNonNull(this.getClient()).incr(key, by, def);
        } catch (Exception e) {
            LogHelper.error("Incr By And Def SpyMemCached Error", e);
        }
    }

    public void incr(String key, int by, long def, int exp) {
        try {
            Objects.requireNonNull(this.getClient()).incr(key, by, def, exp);
        } catch (Exception e) {
            LogHelper.error("Incr By And Def And exp SpyMemCached Error", e);
        }
    }

    public void incr(String key, long by, long def, int exp) {
        try {
            Objects.requireNonNull(this.getClient()).incr(key, by, def, exp);
        } catch (Exception e) {
            LogHelper.error("Incr By And Def And exp SpyMemCached Error", e);
        }
    }

    /**
     * 在指定Key对应的Value上减少数据
     * @param key Key值
     * @param by 减少值
     */
    public void decr(String key, int by) {
        try {
            Objects.requireNonNull(this.getClient()).decr(key, by);
        } catch (Exception e) {
            LogHelper.error("Decr By SpyMemCached Error", e);
        }
    }

    public void decr(String key, long by) {
        try {
            Objects.requireNonNull(this.getClient()).decr(key, by);
        } catch (Exception e) {
            LogHelper.error("Decr By SpyMemCached Error", e);
        }
    }

    public void decr(String key, int by, long def) {
        try {
            Objects.requireNonNull(this.getClient()).decr(key, by, def);
        } catch (Exception e) {
            LogHelper.error("Decr By And Def SpyMemCached Error", e);
        }
    }

    public void decr(String key, long by, long def) {
        try {
            Objects.requireNonNull(this.getClient()).decr(key, by, def);
        } catch (Exception e) {
            LogHelper.error("Decr By And Def SpyMemCached Error", e);
        }
    }

    public void decr(String key, int by, long def, int exp) {
        try {
            Objects.requireNonNull(this.getClient()).decr(key, by, def, exp);
        } catch (Exception e) {
            LogHelper.error("Decr By And Def And exp SpyMemCached Error", e);
        }
    }

    public void decr(String key, long by, long def, int exp) {
        try {
            Objects.requireNonNull(this.getClient()).decr(key, by, def, exp);
        } catch (Exception e) {
            LogHelper.error("Decr By And Def And exp SpyMemCached Error", e);
        }
    }

    /**
     * MemCached-CAS操作
     * @param key Key值
     * @param casId CasId
     * @param value 数据值
     */
    public void cas(String key, long casId, Object value) {
        try {
            Objects.requireNonNull(this.getClient()).cas(key, casId, value);
        } catch (Exception e) {
            LogHelper.error("SpyMemCached Cas Error", e);
        }
    }

    public void cas(String key, long casId, Object value, int exp) {
        try {
            Objects.requireNonNull(this.getClient()).cas(key, casId, exp, value);
        } catch (Exception e) {
            LogHelper.error("SpyMemCached Cas Error", e);
        }
    }
}

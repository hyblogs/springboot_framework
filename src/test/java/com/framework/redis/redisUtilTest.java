package com.framework.redis;

import com.framework.framework.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: redisUtilTest
 * @Description: Redis测试类
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-23 17:32
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-23   hy              v1.0.0             Is Create!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class redisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void setTest() {
        Boolean isTrue = redisUtil.set("cll", "小祖宗");
        System.out.println(isTrue);
    }

    @Test
    public void getTest() {
        Object object = redisUtil.get("cll");
        System.out.println(object);
    }

    @Test
    public void expireTest() {
        Boolean isSuccessed = redisUtil.expire("cll", 300);
        System.out.println(isSuccessed);
    }

    @Test
    public void hasKey() {
        Boolean hasKey = redisUtil.hasKey("cll");
        System.out.println("hasKey:" + hasKey);
    }

    @Test
    public void getExpireTimeTest() {
        Long time = redisUtil.getExpire("cll");
        System.out.println("time:" + time);
    }
}

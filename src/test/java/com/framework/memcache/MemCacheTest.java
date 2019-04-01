package com.framework.memcache;

import com.framework.framework.memcache.MemCacheTemplate;
import com.framework.framework.memcache.SpyMemCacheRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: MemCacheTest
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-13 22:25
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-13   hy              v1.0.0             Is Create!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemCacheTest {

    @Autowired
    private SpyMemCacheRunner spyMemCacheRunner;
    @Autowired
    private MemCacheTemplate memCacheTemplate;

    @Test
    public void memCacheTest() {
        String key = "hy";
        int expTime = 1000;
        String value = "0";
        spyMemCacheRunner.set(key, value, expTime);

        System.out.println("Is Cached Value = " + spyMemCacheRunner.get(key));
    }

    @Test
    public void getKey() {
        System.out.println("Value = " + spyMemCacheRunner.get("hy3"));
    }

    @Test
    public void incrTest() {
        spyMemCacheRunner.incr("hy", 1, 2);
    }


    @Test
    public void addTest() {
        String key = "cll";
        String value = "二哈";
        this.memCacheTemplate.add(key, value);
    }

    @Test
    public void addAndVar3Test() {
        String key = "hy3";
        Object value = "520sdchaisdhcioashdcoiashicohalksdchkashdciouheioqiewhfkldwnckhqiuw" +
                "ehfioqwhefio238974892374897128947129374981723489qefjklqwejfiqwjeifjqowiefjh" +
                "fwiwef93u89ru1389u498ehfidhq83fhefuhqwueihfiquwh就啊好多风景画家快点放寒假巴萨" +
                "大手笔大家可否把圣诞节发生矛盾福卡都不放假 e发看啦是第发和ioqheifhqiwoefhiqweifhqu" +
                "eiwhfiuqehwfiuh气氛好去iwehfuiqwebkjasdbciuqwefwkjenjenf叫我饿减肥 i 恶化 iu 复" +
                "合物 i 发货返回 i 哦前未婚夫 i 哦请问黑发哇诶哦风景区位哦 i 减肥 i 为全家福 i 价位附" +
                "近哦起微积分 i 哦前肌肤极其恶无法可我却能克服呢我";
        boolean isAdd = this.memCacheTemplate.add(key, value, 1);
        System.out.println("IsAdd Success = " + isAdd);
    }


}

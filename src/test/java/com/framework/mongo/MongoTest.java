package com.framework.mongo;

import com.framework.framework.mongodb.MongoConfig;
import com.framework.framework.mongodb.MongoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: MongoTest
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 16:06
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    private MongoUtil mongoUtil;
    @Autowired
    private MongoConfig mongoConfig;

    @Test
    public void saveTest() {
        try {
            MongoDemo mongoDemo = new MongoDemo();
            mongoDemo.setName("hy");
            mongoDemo.setAge(18);
            mongoDemo.setSex(1);
            mongoDemo.setAddress("cll");
            MongoDemo mongoDemo1 = (MongoDemo) this.mongoUtil.save(mongoDemo);
            System.out.println("save：" + mongoDemo1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveToCollectionTest() {
        try {
            MongoDemo mongoDemo = new MongoDemo();
            mongoDemo.setName("hy");
            mongoDemo.setAge(18);
            mongoDemo.setSex(1);
            mongoDemo.setAddress("cll");
            MongoDemo mongoDemo1 = (MongoDemo) this.mongoUtil.saveToCollection(mongoDemo, mongoConfig.collectionName);
            System.out.println("saveToCollection：" + mongoDemo1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

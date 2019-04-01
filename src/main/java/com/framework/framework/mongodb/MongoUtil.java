package com.framework.framework.mongodb;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: MongoUtil
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 16:40
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@Component
public class MongoUtil {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoUtil(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * 新增数据
     * @param object 需新增的数据对象
     * @return 返回新增的数据对象
     */
    public Object save(Object object) {
        return this.mongoTemplate.save(object);
    }

    /**
     * 向指定Mongo集合中插入数据
     * @param object 数据对象
     * @param collectionName 指定集合名称
     * @return 插入集合的数据对象
     */
    public Object saveToCollection(Object object, String collectionName) {
        return this.mongoTemplate.save(object, collectionName);
    }

    /**
     * 根据指定key查询对应的数据信息
     * @param key 查询条件属性
     * @param value 查询条件属性值
     * @return 返回查询到的数据
     */
    public T findByParam(String key, String value) {
        Query query = new Query(Criteria.where(key).is(value));
        return this.mongoTemplate.findOne(query, T.class);
    }
}

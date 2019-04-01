package com.framework.mongo;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: MongoDemo
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 17:00
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
public class MongoDemo {

    private String name;

    private Integer age;

    private Integer sex;

    private String address;

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return sex
     */
    public Integer getSex() {
        return this.sex;
    }

    /**
     * 设置
     *
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取
     *
     * @return address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 设置
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MongoDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}

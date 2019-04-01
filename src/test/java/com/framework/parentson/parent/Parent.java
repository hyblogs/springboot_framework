package com.framework.parentson.parent;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: Parent
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-20 21:05
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-20   hy              v1.0.0             Is Create!
 */
public class Parent {
    {
        System.out.println("parent code");
    }

    public Parent() {
        System.out.println("parent No Params");
    }

    static {
        System.out.println("Parent static");
    }

    protected void write() {
        System.out.println("Parent write protected");
    }

    private void say2() {
        System.out.println("Parent say2 private");
    }

    public void say() {
        System.out.println("Parent Say()");
    }
}

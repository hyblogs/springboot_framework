package com.framework.parentson.son;

import com.framework.parentson.parent.Parent;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: Son
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-20 21:07
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-20   hy              v1.0.0             Is Create!
 */
public class Son extends Parent {
    int a = 10;

    {
        System.out.println("Son Code");
    }

    static {
        System.out.println("son static");
    }

    public Son() {
        int b = 10;
        System.out.println("son no params");
    }

    @Override
    protected void write() {
        System.out.println("son write");
    }

    @Override
    public void say() {
        System.out.println("Son Say()");
    }
}

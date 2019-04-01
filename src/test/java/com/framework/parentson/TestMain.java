package com.framework.parentson;

import com.framework.parentson.parent.Parent;
import com.framework.parentson.son.Son;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: TestMain
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-20 21:08
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-20   hy              v1.0.0             Is Create!
 */
public class TestMain {

    public static void main(String[] args) {
        Parent p = new Son();
        p.say();
    }
}

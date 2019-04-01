package com.framework.controller;

import com.framework.entity.mapping.SysUser;
import com.hykit.common.ResultTip;
import com.framework.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysUserController
 * @Description: 系统后台账户处理控制器
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-01-24 17:35
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-01-24   hy              v1.0.0             Is Create!
 */
@Controller
public class SysUserController {

    private final SysUserMapper sysUserMapper;

    @Autowired
    public SysUserController(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ResponseBody
    public ResultTip getUserList() {
        ResultTip resultTip = new ResultTip();
        List<SysUser> sysUsers = this.sysUserMapper.selectAll();
        resultTip.setRetObj(sysUsers);
        return resultTip;
    }
}

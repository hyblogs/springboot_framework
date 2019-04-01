package com.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: PageRedirectController
 * @Description: 页面跳转控制器
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-20 17:25
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-20   hy              v1.0.0             Is Create!
 */
@Controller
public class PageRedirectController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRootCase(HttpServletRequest request, Model model) {
        request.setAttribute("abc", "cll二哈");
        model.addAttribute("dd", "I Do!!!");
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String toHome() {
        return "redirect:/view/home.html";
    }
}

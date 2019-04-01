package com.framework.framework.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SecurityConfig
 * @Description: Spring-Security配置
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-26 11:43
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-26   hy              v1.0.0             Is Create!
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //防止Druid无法登录
        http.csrf().ignoringAntMatchers("/druid/*");
    }
}

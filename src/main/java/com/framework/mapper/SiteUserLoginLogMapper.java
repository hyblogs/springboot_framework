package com.framework.mapper;

import com.framework.entity.mapping.SiteUserLoginLog;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SiteUserLoginLogMapper extends Mapper<SiteUserLoginLog>, MySqlMapper<SiteUserLoginLog> {
}
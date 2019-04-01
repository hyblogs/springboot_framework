package com.framework.mapper;

import com.framework.entity.mapping.SysUserLoginLog;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysUserLoginLogMapper extends Mapper<SysUserLoginLog>, MySqlMapper<SysUserLoginLog> {
}
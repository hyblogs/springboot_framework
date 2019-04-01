package com.framework.mapper;

import com.framework.entity.mapping.SysUserRole;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysUserRoleMapper extends Mapper<SysUserRole>, MySqlMapper<SysUserRole> {
}
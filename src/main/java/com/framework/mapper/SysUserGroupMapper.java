package com.framework.mapper;

import com.framework.entity.mapping.SysUserGroup;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysUserGroupMapper extends Mapper<SysUserGroup>, MySqlMapper<SysUserGroup> {
}
package com.framework.mapper;

import com.framework.entity.mapping.SysUser;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysUserMapper extends Mapper<SysUser>, MySqlMapper<SysUser> {
}
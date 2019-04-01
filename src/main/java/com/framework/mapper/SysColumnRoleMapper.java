package com.framework.mapper;

import com.framework.entity.mapping.SysColumnRole;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysColumnRoleMapper extends Mapper<SysColumnRole>, MySqlMapper<SysColumnRole> {
}
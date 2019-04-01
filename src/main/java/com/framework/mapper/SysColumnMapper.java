package com.framework.mapper;

import com.framework.entity.mapping.SysColumn;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysColumnMapper extends Mapper<SysColumn>, MySqlMapper<SysColumn> {
}
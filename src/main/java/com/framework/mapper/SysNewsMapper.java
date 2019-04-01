package com.framework.mapper;

import com.framework.entity.mapping.SysNews;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysNewsMapper extends Mapper<SysNews>, MySqlMapper<SysNews> {
}
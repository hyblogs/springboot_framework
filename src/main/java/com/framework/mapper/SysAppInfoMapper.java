package com.framework.mapper;

import com.framework.entity.mapping.SysAppInfo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysAppInfoMapper extends Mapper<SysAppInfo>, MySqlMapper<SysAppInfo> {
}
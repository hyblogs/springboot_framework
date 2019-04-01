package com.framework.mapper;

import com.framework.entity.mapping.SysCatalogInfo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysCatalogInfoMapper extends Mapper<SysCatalogInfo>, MySqlMapper<SysCatalogInfo> {
}
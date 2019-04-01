package com.framework.mapper;

import com.framework.entity.mapping.SiteUser;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SiteUserMapper extends Mapper<SiteUser>, MySqlMapper<SiteUser> {
}
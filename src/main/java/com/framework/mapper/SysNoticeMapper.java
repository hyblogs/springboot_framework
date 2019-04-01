package com.framework.mapper;

import com.framework.entity.mapping.SysNotice;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface SysNoticeMapper extends Mapper<SysNotice>, MySqlMapper<SysNotice> {
}
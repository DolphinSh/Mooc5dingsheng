package com.bilibili.datasource.mapper;

import com.bilibili.datasource.entites.DsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DsAdminMapper {
    DsAdmin getDsAdminByLogin(DsAdmin dsAdmin);
}

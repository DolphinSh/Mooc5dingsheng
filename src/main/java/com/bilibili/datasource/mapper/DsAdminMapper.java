package com.bilibili.datasource.mapper;

import com.bilibili.datasource.entites.DsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Mapper
@Component
public interface DsAdminMapper {
    DsAdmin getDsAdminByLogin(DsAdmin dsAdmin);
    ArrayList<DsAdmin> getDsAdminAll(@Param("pageNumber")Integer pageNumber, @Param("limit")Integer limit);
    Integer getPageSize();
    boolean deleteOneByAccount(String admin_account);
}

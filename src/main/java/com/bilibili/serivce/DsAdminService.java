package com.bilibili.serivce;

import com.bilibili.datasource.entites.DsAdmin;

import java.util.ArrayList;

public interface DsAdminService {
    DsAdmin getDsAdminByLogin(DsAdmin dsAdmin);
    ArrayList<DsAdmin> getDsAdminAll(Integer pageNumber,Integer limit);
}

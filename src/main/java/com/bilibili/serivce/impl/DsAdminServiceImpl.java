package com.bilibili.serivce.impl;

import com.bilibili.datasource.entites.DsAdmin;
import com.bilibili.datasource.mapper.DsAdminMapper;
import com.bilibili.serivce.DsAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DsAdminServiceImpl implements DsAdminService {
    @Autowired
    private DsAdminMapper dsAdminMapper;
    @Override
    public DsAdmin getDsAdminByLogin(DsAdmin dsAdmin) {
        return dsAdminMapper.getDsAdminByLogin(dsAdmin);
    }

    @Override
    public ArrayList<DsAdmin> getDsAdminAll(Integer pageNumber,Integer limit) {
        return dsAdminMapper.getDsAdminAll(pageNumber,limit);
    }

    @Override
    public Integer getPageSize() {
        return dsAdminMapper.getPageSize();
    }

    @Override
    public boolean deleteOneByAccount(String admin_account) {
       boolean isDel =  dsAdminMapper.deleteOneByAccount(admin_account);
       if (isDel == true){
           return true;
       }else {
           return false;
       }
    }
}

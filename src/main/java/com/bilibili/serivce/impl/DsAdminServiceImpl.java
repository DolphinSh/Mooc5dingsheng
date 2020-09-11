package com.bilibili.serivce.impl;

import com.bilibili.datasource.entites.DsAdmin;
import com.bilibili.datasource.mapper.DsAdminMapper;
import com.bilibili.serivce.DsAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DsAdminServiceImpl implements DsAdminService {
    @Autowired
    private DsAdminMapper dsAdminMapper;
    @Override
    public DsAdmin getDsAdminByLogin(DsAdmin dsAdmin) {
        return dsAdminMapper.getDsAdminByLogin(dsAdmin);
    }
}

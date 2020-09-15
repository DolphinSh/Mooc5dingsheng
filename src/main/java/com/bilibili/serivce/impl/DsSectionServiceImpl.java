package com.bilibili.serivce.impl;

import com.bilibili.datasource.entites.DsSection;
import com.bilibili.datasource.mapper.DsSectionMapper;
import com.bilibili.serivce.DsSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DsSectionServiceImpl implements DsSectionService {
    @Autowired
    private DsSectionMapper dsSectionMapper;

    @Override
    public List<DsSection> getDsSection() {
        return dsSectionMapper.getDsSection();
    }

    @Override
    public List<DsSection> getParentDsSection() {
        return dsSectionMapper.getParentDsSection();
    }

    @Override
    public List<DsSection> getSecondDsSection(String section_name) {
        return dsSectionMapper.getSecondDsSection(section_name);
    }


}

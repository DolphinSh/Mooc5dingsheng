package com.bilibili.serivce;

import com.bilibili.datasource.entites.DsSection;

import java.util.List;

public interface DsSectionService {
    List<DsSection> getDsSection();
    List<DsSection> getParentDsSection();
    List<DsSection> getSecondDsSection(String section_name);
}

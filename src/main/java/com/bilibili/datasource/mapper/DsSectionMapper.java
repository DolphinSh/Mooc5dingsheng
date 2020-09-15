package com.bilibili.datasource.mapper;

import com.bilibili.datasource.entites.DsSection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DsSectionMapper {
    List<DsSection> getDsSection();
    List<DsSection> getParentDsSection();
}

package com.bilibili.serivce.impl;

import com.bilibili.serivce.DsSectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DsSectionServiceTest {
    @Autowired
    private DsSectionService dsSectionService;

    @Test
    public void getSectionTest(){
        dsSectionService.getDsSection();
    }

    @Test
    public void getParentSectionTest(){
        System.out.println(dsSectionService.getParentDsSection());
    }

    @Test
    public void getSecondDsSection(){
        System.out.println(dsSectionService.getSecondDsSection("后勤中心部"));
    }
}
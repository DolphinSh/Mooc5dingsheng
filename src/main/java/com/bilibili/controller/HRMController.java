package com.bilibili.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bilibili.datasource.entites.DsAdmin;
import com.bilibili.datasource.vo.TableData;
import com.bilibili.serivce.DsAdminService;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class HRMController {
    @Autowired
    private DsAdminService dsAdminService;
    @ResponseBody
    @RequestMapping(value = "page/personmanage/getEmployeeAll",produces = {"application/text;charset=UTF-8"})
    public String employeeAll(@RequestParam("page") int page, @RequestParam("limit") int limit, String deptType){
        TableData tableData = new TableData();
        List<DsAdmin> all =  dsAdminService.getDsAdminAll(0,11);
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("code",0);
        model.put("msg","");
        model.put("count",all.size()+1);
        model.put("data",all);
        log.info(JSON.toJSONString(model));
        return JSON.toJSONString(model);
    }
}

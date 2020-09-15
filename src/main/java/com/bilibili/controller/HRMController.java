package com.bilibili.controller;


import com.alibaba.fastjson.JSON;
import com.bilibili.datasource.entites.DsAdmin;
import com.bilibili.datasource.entites.DsSection;
import com.bilibili.datasource.vo.MsgData;
import com.bilibili.datasource.vo.TableData;
import com.bilibili.serivce.DsAdminService;

import com.bilibili.serivce.DsSectionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class HRMController {
    @Autowired
    private DsAdminService dsAdminService;
    @Autowired
    private DsSectionService dsSectionService;
    @ResponseBody
    @RequestMapping(value = "page/personmanage/getEmployeeAll",produces = {"application/text;charset=UTF-8"})
    public String employeeAll(@RequestParam("page") int page, @RequestParam("limit") int limit, String deptType){
        TableData tableData = new TableData();
        List<DsAdmin> all =  dsAdminService.getDsAdminAll((page-1)*limit,limit);
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("code",0);
        model.put("msg","msg ok");
        model.put("count",dsAdminService.getPageSize());
        model.put("data",all);
        log.info(JSON.toJSONString(model));
        return JSON.toJSONString(model);
    }
    @PostMapping("/page/personmanage/deleteOneUser")
    @ResponseBody
    public MsgData deleteOneUser(String admin_account){
        MsgData msgData = new MsgData();
        boolean isDel =  dsAdminService.deleteOneByAccount(admin_account);
        if (isDel){
            msgData.setCode(200);
            msgData.setMsg("success");
            return msgData;
        }else {
            msgData.setCode(-1);
            msgData.setMsg("Faile");
        }
        return msgData;
    }
    @GetMapping("/page/personmanage/getDsSection")
    @ResponseBody
    public List<DsSection> getDsSection() {
        return dsSectionService.getDsSection();
    }

    @GetMapping("/page/personmanage/getParentSection")
    @ResponseBody
    public String getParentSection(){
        return JSON.toJSONString(dsSectionService.getParentDsSection());
    }
    @GetMapping("/page/personmanage/getSecondDeptName")
    @ResponseBody
    public String getSecondDsSection(@RequestParam("section_name") String section_name ){
        return JSON.toJSONString(dsSectionService.getSecondDsSection(section_name));
    }
}

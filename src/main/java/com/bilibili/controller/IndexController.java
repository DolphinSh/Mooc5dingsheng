package com.bilibili.controller;

import com.bilibili.datasource.entites.DsAdmin;
import com.bilibili.datasource.vo.MsgData;

import com.bilibili.serivce.DsAdminService;

import com.bilibili.utils.DESUtil;
import com.bilibili.utils.Md5Util;
import com.google.code.kaptcha.Constants;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
@Controller
public class IndexController {
    @Autowired
    private DsAdminService dsAdminService;
    /*做日志类*/
    /*系统的入口地址*/
    //RSA方式传递key
/*    @GetMapping("/")
    public String index(Model model){
        Map<Integer, String> rasKey = null;
        try {
            rasKey = RSAUtil.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        model.addAttribute("key",rasKey.get(0)); //SpringMVC的Model的组件
        return "index";
    }*/
    /**
     * 系统入口地址
     * @param session
     * @return
     */
    @GetMapping("/")
    public String index(HttpSession session) {
        String s = UUID.randomUUID().toString();
        session.setAttribute("key", s);  // SpringMVC的Model组件
        log.info("key值: {}", s);
        return "login"; // 视图重定向 - 跳转
    }
    /*
    * 表单不刷新方式登录 --Ajax登录
    * 如何设置接口返回数据格式  --ID
    *
    *
    * */
    @PostMapping("/login")
    @ResponseBody /*对应json数据*/
    public MsgData login(String username, String password, String captcha, String key, HttpSession session) throws Exception {
        MsgData msgData = new MsgData();

        // 验证码判断
        if(!session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString().equalsIgnoreCase(captcha)) {
            msgData.setCode(2);
            msgData.setMsg("fails");
            return msgData;
        }

        log.info("加密: {} 密钥：{}", username, key);

        // 解密操作 - 账号解密
        // DESUtils
        String serverKey = session.getAttribute("key").toString();
        if(!serverKey.equals(key)) {
            return msgData;
        }
        // 解密
        username = DESUtil.decryption(username, serverKey);
        log.info("解密: {} 密钥：{}", username, serverKey);
        // 用户名和数据库进行查询
        // 如果用户名存在，则可以得到用户对应盐
        // 判断密码 - MD5
        // 数据库里面密码是MD5+盐
        // 前端密码 + 盐 = 数据库密码
        DsAdmin dsAdmin = new DsAdmin();
        dsAdmin.setAdmin_accout(username); // 前端返回的数据
        dsAdmin = dsAdminService.getDsAdminByLogin(dsAdmin);

        String salt = dsAdmin.getAdmin_salt(); // 数据库里面的内容
        Md5Util md5Util = new Md5Util(salt, "MD5");
        password = md5Util.encode(password); // 新的md5密码
        if(password.equals(dsAdmin.getAdmin_password())) {
            msgData.setCode(0);
            msgData.setMsg("success");
            msgData.setData(dsAdmin);
            return msgData;
        } else {
            msgData.setCode(101);
            msgData.setMsg("fails");
            return msgData;
        }
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}

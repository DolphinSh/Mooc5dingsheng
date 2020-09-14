package com.bilibili.datasource.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DsAdmin {
    private String admin_id; //用户id
    private String admin_account; //用户名
    private String admin_password;//密码
    private String admin_salt;//加密值
    private int admin_gender;//性别
    private int admin_age;//年龄
    private String admin_firstDept;//一级部门
    private String admin_secondDept;//二级部门
    private String admin_job;//职位
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;//更新时间
}

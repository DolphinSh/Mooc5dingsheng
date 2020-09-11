package com.bilibili.datasource.pojo;


import java.util.Date;

public class user {
    private Integer id;
    private String username;
    private String password;
    private char gender;
    private Integer age;
    private Date create_time;
    private Date update_time;

    public user() {
    }

    public user(String username, String password, char gender, Integer age, Date create_time, Date update_time) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}

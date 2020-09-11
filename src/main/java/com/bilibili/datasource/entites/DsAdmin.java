package com.bilibili.datasource.entites;

public class DsAdmin {
    private String admin_id;
    private String admin_account;
    private String admin_password;
    private String admin_salt;

    public DsAdmin() {
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_account() {
        return admin_account;
    }

    public void setAdmin_accout(String admin_accout) {
        this.admin_account = admin_accout;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_salt() {
        return admin_salt;
    }

    public void setAdmin_salt(String admin_salt) {
        this.admin_salt = admin_salt;
    }

    @Override
    public String toString() {
        return "DsAdmin{" +
                "admin_id='" + admin_id + '\'' +
                ", admin_accout='" + admin_account + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_salt='" + admin_salt + '\'' +
                '}';
    }
}

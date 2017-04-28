package com.sl.nicefish.pojo;

import java.util.Date;

public class User {
    private String userid;

    private String username;

    private String userrealname;

    private String nickname;

    private String ename;

    private String password;

    private String email;

    private String qq;

    private String cellphone;

    private String userdesc;

    private String upId;

    private Integer type;

    private Integer status;

    private String code;

    private Date jointime;

    private Date leavetime;

    private Date registertime;

    public String getUserId() {
        return userid;
    }

    public void setUserId(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserRealName() {
        return userrealname;
    }

    public void setUserRealName(String userrealname) {
        this.userrealname = userrealname == null ? null : userrealname.trim();
    }

    public String getNickName() {
        return nickname;
    }

    public void setNickName(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getCellPhone() {
        return cellphone;
    }

    public void setCellPhone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getUserdesc() {
        return userdesc;
    }

    public void setUserdesc(String userdesc) {
        this.userdesc = userdesc == null ? null : userdesc.trim();
    }

    public String getUpId() {
        return upId;
    }

    public void setUpId(String upid) {
        this.upId = upid == null ? null : upid.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }
}
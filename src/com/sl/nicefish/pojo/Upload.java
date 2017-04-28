package com.sl.nicefish.pojo;

import java.util.Date;

public class Upload {
    private String upid;

    private Date uptime;

    private Integer filetype;

    private String filepath;

    private String filename;

    private Integer imgwidth;

    private Integer imgheight;

    private String filedesc;

    private String userid;

    private Integer imgmodule;

    private String postid;

    public String getUpid() {
        return upid;
    }

    public void setUpid(String upid) {
        this.upid = upid == null ? null : upid.trim();
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Integer getFiletype() {
        return filetype;
    }

    public void setFiletype(Integer filetype) {
        this.filetype = filetype;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getImgwidth() {
        return imgwidth;
    }

    public void setImgwidth(Integer imgwidth) {
        this.imgwidth = imgwidth;
    }

    public Integer getImgheight() {
        return imgheight;
    }

    public void setImgheight(Integer imgheight) {
        this.imgheight = imgheight;
    }

    public String getFiledesc() {
        return filedesc;
    }

    public void setFiledesc(String filedesc) {
        this.filedesc = filedesc == null ? null : filedesc.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getImgmodule() {
        return imgmodule;
    }

    public void setImgmodule(Integer imgmodule) {
        this.imgmodule = imgmodule;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid == null ? null : postid.trim();
    }
}
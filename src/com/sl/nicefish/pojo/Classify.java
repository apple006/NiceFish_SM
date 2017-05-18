package com.sl.nicefish.pojo;

public class Classify {
    private String classifyid;

    private String classifyname;

    private String classifydesc;
    

    public String getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(String classifyid) {
        this.classifyid = classifyid == null ? null : classifyid.trim();
    }

    public String getClassifyname() {
        return classifyname;
    }

    public void setClassifyname(String classifyname) {
        this.classifyname = classifyname == null ? null : classifyname.trim();
    }

    public String getClassifydesc() {
        return classifydesc;
    }

    public void setClassifydesc(String classifydesc) {
        this.classifydesc = classifydesc == null ? null : classifydesc.trim();
    }
}
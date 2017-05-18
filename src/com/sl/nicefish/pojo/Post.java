package com.sl.nicefish.pojo;

import java.util.Date;

public class Post {
    private String postid;

    private String posttitle;

    private Integer isoriginal;

    private String classifyid;

    private Integer readtimes;

    private Integer likedtimes;

    private Integer collecttimes;

    private Integer commenttimes;

    private String userid;

    private String username;

    private Integer enablecomment;

    private Integer status;

    private Date createtime;

    private Date lastmodifytime;

    private String modifyuserid;

    private String nickname;

    private String posturl;

    private String isfamous;

    private String postcontent;

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid == null ? null : postid.trim();
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle == null ? null : posttitle.trim();
    }

    public Integer getIsoriginal() {
        return isoriginal;
    }

    public void setIsoriginal(Integer isoriginal) {
        this.isoriginal = isoriginal;
    }

    public String getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(String classifyid) {
        this.classifyid = classifyid == null ? null : classifyid.trim();
    }

    public Integer getReadtimes() {
        return readtimes;
    }

    public void setReadtimes(Integer readtimes) {
        this.readtimes = readtimes;
    }

    public Integer getLikedtimes() {
        return likedtimes;
    }

    public void setLikedtimes(Integer likedtimes) {
        this.likedtimes = likedtimes;
    }

    public Integer getCollecttimes() {
        return collecttimes;
    }

    public void setCollecttimes(Integer collecttimes) {
        this.collecttimes = collecttimes;
    }

    public Integer getCommenttimes() {
        return commenttimes;
    }

    public void setCommenttimes(Integer commenttimes) {
        this.commenttimes = commenttimes;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getEnablecomment() {
        return enablecomment;
    }

    public void setEnablecomment(Integer enablecomment) {
        this.enablecomment = enablecomment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getModifyuserid() {
        return modifyuserid;
    }

    public void setModifyuserid(String modifyuserid) {
        this.modifyuserid = modifyuserid == null ? null : modifyuserid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPosturl() {
        return posturl;
    }

    public void setPosturl(String posturl) {
        this.posturl = posturl == null ? null : posturl.trim();
    }

    public String getIsfamous() {
        return isfamous;
    }

    public void setIsfamous(String isfamous) {
        this.isfamous = isfamous == null ? null : isfamous.trim();
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent == null ? null : postcontent.trim();
    }

	@Override
	public String toString() {
		return "Post [postid=" + postid + ", posttitle=" + posttitle + ", isoriginal=" + isoriginal + ", classifyid="
				+ classifyid + ", readtimes=" + readtimes + ", likedtimes=" + likedtimes + ", collecttimes="
				+ collecttimes + ", commenttimes=" + commenttimes + ", userid=" + userid + ", username=" + username
				+ ", enablecomment=" + enablecomment + ", status=" + status + ", createtime=" + createtime
				+ ", lastmodifytime=" + lastmodifytime + ", modifyuserid=" + modifyuserid + ", nickname=" + nickname
				+ ", posturl=" + posturl + ", isfamous=" + isfamous + ", postcontent=" + postcontent + "]";
	}
    
    
}
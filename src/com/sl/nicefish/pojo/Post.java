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

    private String userid;

    private String username;
    
    private String nickname;

	private Integer enablecomment;

    private Integer status;

    private Date createtime;

    private Date lastmodifytime;

    private String modifyuserid;

    private String postcontent;

    public String getPostId() {
        return postid;
    }

    public void setPostId(String postid) {
        this.postid = postid == null ? null : postid.trim();
    }

    public String getPostTitle() {
        return posttitle;
    }

    public void setPostTitle(String posttitle) {
        this.posttitle = posttitle == null ? null : posttitle.trim();
    }

    public Integer getIsOriginal() {
        return isoriginal;
    }

    public void setIsOriginal(Integer isoriginal) {
        this.isoriginal = isoriginal;
    }

    public String getClassifyId() {
        return classifyid;
    }

    public void setClassifyId(String classifyid) {
        this.classifyid = classifyid == null ? null : classifyid.trim();
    }

    public Integer getReadTimes() {
        return readtimes;
    }

    public void setReadTimes(Integer readtimes) {
        this.readtimes = readtimes;
    }

    public Integer getLikedTimes() {
        return likedtimes;
    }

    public void setLikedTimes(Integer likedtimes) {
        this.likedtimes = likedtimes;
    }

    public Integer getCollectTimes() {
        return collecttimes;
    }

    public void setCollectTimes(Integer collecttimes) {
        this.collecttimes = collecttimes;
    }

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

    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickName) {
		this.nickname = nickName;
	}
    
    public Integer getEnableComment() {
        return enablecomment;
    }

    public void setEnableComment(Integer enablecomment) {
        this.enablecomment = enablecomment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createtime;
    }

    public void setCreateTime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastModifyTime() {
        return lastmodifytime;
    }

    public void setLastModifyTime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getModifyUserid() {
        return modifyuserid;
    }

    public void setModifyUserid(String modifyuserid) {
        this.modifyuserid = modifyuserid == null ? null : modifyuserid.trim();
    }

    public String getPostContent() {
        return postcontent;
    }

    public void setPostContent(String postcontent) {
        this.postcontent = postcontent == null ? null : postcontent.trim();
    }

	@Override
	public String toString() {
		return "Post [postid=" + postid + ", posttitle=" + posttitle + ", isoriginal=" + isoriginal + ", classifyid="
				+ classifyid + ", readtimes=" + readtimes + ", likedtimes=" + likedtimes + ", collecttimes="
				+ collecttimes + ", userid=" + userid + ", username=" + username + ", nickname=" + nickname
				+ ", enablecomment=" + enablecomment + ", status=" + status + ", createtime=" + createtime
				+ ", lastmodifytime=" + lastmodifytime + ", modifyuserid=" + modifyuserid + ", postcontent="
				+ postcontent + "]";
	}
    
    
}
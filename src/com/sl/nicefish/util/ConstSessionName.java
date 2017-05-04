package com.sl.nicefish.util;

/**
 * 存储键值
 * @author ZhangJing
 *
 */
public class ConstSessionName {

	private ConstSessionName(){}
	
	/**
	 * 用户信息
	 */
	public static final String UserInfo="userInfo";
	/**
	 * 验证码
	 */
	public static final String ImageVerifyCode="imageVerifyCode";
	
	/**
	 * 返回信息的键
	 * info: 提示信息
	 * status: 状态
	 * data:实体数据
	 */
	public static final String INFO = "info";
	public static final String STATUS = "status";
	public static final String DATA = "data";
	/**
	 * 列表查询，详细查询返回的信息提示
	 */
	public static final String successQueryInfo ="查询成功";
	public static final String failureQueryInfo = "查询失败";
	public static final String successInsertInfo = "新增成功";
	public static final String failureInsertInfo = "新增失败";
	public static final String successUpdateInfo = "修改成功";
	public static final String failureUpdateInfo = "修改失败";
	public static final String successDeleteInfo = "删除成功";
	public static final String failureDeleteInfo = "删除失败";
	
	/**
	 * 额外的信息说明
	 * 比如数据新增失败告诉失败原因
	 */
	public static final String MESSAGE="msg";
	
	/**
	 * 状态1：成功 0：失败
	 */
	public static final String successStatus = "1";
	public static final String failureStatus = "0";
	
	/**
	 * 登录注册提示信息
	 */
	public static final String loginSuccess = "登录成功";
	public static final String loginFailure = "登录失败";
	public static final String RegisterSuccess = "注册成功";
	public static final String RegisterFailure = "注册失败";
	
	
}

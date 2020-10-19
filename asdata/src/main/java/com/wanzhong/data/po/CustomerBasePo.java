package com.wanzhong.data.po;


import com.wanzhong.common.util.StringUtil;


/** 
* @author chenxian
* @version 2019年3月25日 下午4:01:23 
* 客户基础信息，客户信息和订单信息可继承于此
*/
public class CustomerBasePo extends ComRespPo {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7911931420515910124L;
	private String ctUserId;
	/**实际控制人姓名/用户名称*/
	private String name;
	/**用户类型 0 商户用户 1 个人用户 9 后台管理员*/
	private String userType;
	/**企业名称*/
	private String enterName;
	/**用户类型-显示,根据userType*/
	protected String userTypeShow;
	
	protected String boxRole;
	protected String boxRoleShow;
	
	private String userId;
	private String tokenId;
	
	public String getCtUserId() {
		return StringUtil.changeNull(ctUserId);
	}

	public void setCtUserId(String id) {
		this.ctUserId = id;
	}

	public String getName() {
		return StringUtil.changeNull(name,"---");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserType() {
		return StringUtil.changeNull(userType);
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEnterName() {
		return StringUtil.changeNull(enterName,"---");
	}

	public void setEnterName(String enterName) {
		this.enterName = enterName;
	}

	public String getUserTypeShow() {
		return StringUtil.changeNull(userTypeShow,"---");
	}

	public void setUserTypeShow(String userTypeShow) {
		this.userTypeShow = userTypeShow;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	
	

	public String getBoxRole() {
		return StringUtil.changeNull(boxRole,"---");
	}

	public void setBoxRole(String boxRole) {
		this.boxRole = boxRole;
	}

	public String getBoxRoleShow() {
		return StringUtil.changeNull(boxRoleShow,"---");
	}

	public void setBoxRoleShow(String boxRoleShow) {
		this.boxRoleShow = boxRoleShow;
	}


}

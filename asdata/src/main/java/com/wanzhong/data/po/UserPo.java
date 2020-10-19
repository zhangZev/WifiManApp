package com.wanzhong.data.po;

import com.wanzhong.common.util.StringUtil;

import java.sql.ResultSet;

public class UserPo extends ComRespPo {

	private static final long serialVersionUID = -8152902656629662249L;
	private String id;
	private String name;
	private String loginid;
	private String menus;
	private String passwd;
	private String status;

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getId() {
		return StringUtil.changeNull(id);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return StringUtil.changeNull(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginid() {
		return StringUtil.changeNull(loginid);
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getMenus() {
		return StringUtil.changeNull(menus);
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setResultSet(ResultSet rs) throws Exception {
		this.id = rs.getString("ID");
		this.name = rs.getString("NAME");
		this.loginid = rs.getString("LOGINID");
		this.status = rs.getString("STATUS");
	}
}

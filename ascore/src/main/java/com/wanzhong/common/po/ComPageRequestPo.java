package com.wanzhong.common.po;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

public class ComPageRequestPo extends ComRequestPo {

	private String pageIndex;
	private String pageSize;
	private String cond01;
	private String cond02;
	private String cond03;
	private String cond04;
	private String cond05;
	private String cond06;
	private String cond07;
	private String cond08;
	private String cond09;
	
	public String getPageIndex() {
		if (StringUtil.isNullOrSpace(pageIndex)) {
			pageIndex = SysContants.CHAR_0;
		}
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageSize() {
		if (StringUtil.isNullOrSpace(pageSize)) {
			pageSize = SysContants.CHAR_10;
		}
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getCond01() {
		return cond01;
	}

	public void setCond01(String cond01) {
		this.cond01 = cond01;
	}

	public String getCond02() {
		return cond02;
	}

	public void setCond02(String cond02) {
		this.cond02 = cond02;
	}

	public String getCond03() {
		return cond03;
	}

	public void setCond03(String cond03) {
		this.cond03 = cond03;
	}

	public String getCond04() {
		return cond04;
	}

	public void setCond04(String cond04) {
		this.cond04 = cond04;
	}

	public String getCond05() {
		return cond05;
	}

	public void setCond05(String cond05) {
		this.cond05 = cond05;
	}

	public String getCond06() {
		return cond06;
	}

	public void setCond06(String cond06) {
		this.cond06 = cond06;
	}

	public String getCond07() {
		return cond07;
	}

	public void setCond07(String cond07) {
		this.cond07 = cond07;
	}

	public String getCond08() {
		return cond08;
	}

	public void setCond08(String cond08) {
		this.cond08 = cond08;
	}

	public String getCond09() {
		return cond09;
	}

	public void setCond09(String cond09) {
		this.cond09 = cond09;
	}
}

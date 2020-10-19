package com.wanzhong.data.po;

import com.wanzhong.common.po.ComRequestPo;

public class ComRequestPageArgPo extends ComRequestPo {

	private int pageIndex = 0;

	private int pageSize = 10;

	private String cond01;

	private String cond02;
	private String cond03;
	private String cond04;
	private String cond05;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
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
}

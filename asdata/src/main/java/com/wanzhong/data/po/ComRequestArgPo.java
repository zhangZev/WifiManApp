package com.wanzhong.data.po;

import com.wanzhong.common.po.ComRequestPo;

public class ComRequestArgPo extends ComRequestPo {

	private String keyId;
	private String keyType;
	private String keyId01;

	public String getKeyId01() {
		return keyId01;
	}

	public void setKeyId01(String keyId01) {
		this.keyId01 = keyId01;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
}

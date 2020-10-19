package com.wanzhong.common.po;

import com.alibaba.fastjson.JSONObject;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.utils.CommonUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.RequestBody;

public class ComRequestPo extends BasePo {

	public ComRequestPo(){
		super();
		//updateIdAndToken();
	}
	/*private String userId;
	private String tokenId;
	private String sign;
	private String parentId;
	private String timestamp;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public void updateIdAndToken(){
		setTokenId(BaseApp.getInstance().getToken());
		setUserId(BaseApp.getInstance().getUserId());

	}
*/

	private static final String TYPE = "application/json; charset=utf-8";
	public RequestBody toRequestBody(boolean updateIdToken){
		if(updateIdToken){
		//	updateIdAndToken();
		}
		return RequestBody.create(okhttp3.MediaType.parse(TYPE), toString());
	}
	public RequestBody toRequestBody(){
		return toRequestBody(false);
	}

	/*public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}*/

	public Map<String,String> toFiledMap(){
		final JSONObject json = toJSON();

		final Map<String,String> map = new HashMap<String,String>();
		final Iterator<String> keys =  json.keySet().iterator();
		while (keys.hasNext()){
			final String key = keys.next();
			final String value = json.getString(key);
			if (StringUtil.isNotNullAndSpace(value)) {
				map.put(key,value);
			}
		}

		json.clear();
		return map;
	}
}

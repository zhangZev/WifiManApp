package com.wanzhong.common.po;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public abstract class BasePo implements Serializable {
	private static final long serialVersionUID = 213873820892540888L;
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	public JSONObject toJSON(){
		return JSONObject.parseObject(toString());
	}


	public void deleteFile(Context context, String filename){
		File file = context.getFileStreamPath(filename);
		if(file.exists()){
			boolean suc = file.delete();
		}
	}
	public void saveToFile(Context context,String filename){
		FileOutputStream fos = null;
		try {
			/*File file = context.getFileStreamPath(filename);
			if(file.exists()){
				boolean suc = file.delete();
				Util.err("delete succ "+suc);
			}*/
			fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(this);
			os.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static Object loadFromFile(Context context,String filename){
		FileInputStream fis = null;
		ObjectInputStream is = null;
		try {
			fis = context.openFileInput(filename);
			is = new ObjectInputStream(fis);
			Object bean =  is.readObject();
			return bean;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}

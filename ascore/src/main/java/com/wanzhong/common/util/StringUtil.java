package com.wanzhong.common.util;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class StringUtil {
	public static boolean isNotNullAndSpace(String str) {
		if (str != null && !SysContants.CHAR_EMPTY.equals(str.trim()) && !SysContants.CHAR_EMPTY_SHOW.equals(str.trim())) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrSpace(String str) {
		if (str == null || SysContants.CHAR_EMPTY.equals(str.trim()) || SysContants.CHAR_EMPTY_SHOW.equals(str.trim())) {
			return true;
		}
		return false;
	}
	
	public static String bankChg(String str) {
		if(StringUtil.isNullOrSpace(str)) {
			return null;
		}
		if(str.length() < 4) {
			return "**** **** **** ****" + str;
		}
		str = str.substring(str.length()-4, str.length());
		return "**** **** **** ****" + str; 
	}

	/**
	 * 空值转换
	 * 
	 * @param str
	 * @return
	 */
	public static String changeNull(String str) {
		if (str == null) {
			str = SysContants.CHAR_EMPTY;
		} else {
			if (SysContants.CHAR_EMPTY.equals(str.trim())) {
				str = SysContants.CHAR_EMPTY;
			} else if (SysContants.CHAR_NULL.equalsIgnoreCase(str.trim())) {
				str = SysContants.CHAR_EMPTY;
			}
		}
		return str;
	}

	public static String changeNullDefault(String str) {
		return changeNull(str,SysContants.CHAR_EMPTY_SHOW);
	}
	public static String changeNullInt(String str){
		return changeNull(str,SysContants.CHAR_0);
	}
	/**
	 * 空值转换为默认字符
	 * 
	 * @param str
	 * @param defaultChar
	 * @return
	 */
	public static String changeNull(String str, String defaultChar) {
		if (defaultChar == null) {
			defaultChar = SysContants.CHAR_EMPTY;
		}
		if (str == null) {
			str = defaultChar;
		} else {
			if (SysContants.CHAR_EMPTY.equals(str.trim())) {
				str = defaultChar;
			} else if (SysContants.CHAR_NULL.equalsIgnoreCase(str.trim())) {
				str = defaultChar;
			}
		}
		return str;
	}

	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		uuidStr = uuidStr.replace("-", SysContants.CHAR_EMPTY);
		return uuidStr;
	}

	/**
	 * 生产令牌
	 * 
	 * @return
	 */
	public static String createTokenId() {
		return "TK" + getUUID();
	}

	/**
	 * 获取当前日期的指定格式
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrentDateFormat(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		return sdf.format(date);
	}

	public static final String YYYY_MM_DD = "yyyyMMdd";

	public static String getDateYYYYMMDD() {
		return getCurrentDateFormat(YYYY_MM_DD);
	}

	/** 获取指定日期的指定格式 **/
	public static String getDateFormat(String format, long lTime) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(new Date(lTime));
	}

	public static long getDateToLong(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = sdf.parse(str);
		return date.getTime();
	}

	/**
	 * 生成6位验证码
	 * 
	 * @return
	 */
	public static String random6() {
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			sb.append(r.nextInt(9));
		}
		return sb.toString();
	}

	/**
	 * 获取当前yyyy-MM-dd HH:mm:ss格式日期
	 * 
	 * @return
	 */
	public static String getCurrentDateAll() {
		return getCurrentDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public static long getLongByDate() {
		return new Date().getTime();
	}

	/**
	 * 获取随机账号
	 * 
	 * @param n
	 * @return
	 */
	public static String queryRandomNo(int n) {
		String[] chars = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			int id = r.nextInt(10);
			sb.append(chars[id]);
		}
		return sb.toString();
	}

	/**
	 * 获取图片编号
	 * 
	 * @param modName
	 * @return
	 */
	public static String queryImgId(String modName) {
		StringBuffer sb = new StringBuffer(modName);
		sb.append(addZearo(getDateTime(), 16));
		sb.append(getUUID());
		return sb.toString();
	}

	public static String getDateTime() {
		Date date = new Date();
		return "" + date.getTime();
	}

	public static String wxImgUrlChange(String url, String str) {
		if (isNotNullAndSpace(url)) {
			int index = url.lastIndexOf("/0");
			if (index != -1) {
				url = url.substring(0, index) + str;
			}
			return url;
		}
		return "";
	}

	/**
	 * 字符位数不够补零
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public static String addZearo(String str, int len) {
		int size = len - str.length();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb.append("0");
		}
		sb.append(str);
		return sb.toString();
	}

	/**
	 * 手机号码加密
	 * 
	 * @param str
	 * @return
	 */
	public static String phoneChange(String str) {
		int size = str.length();
		StringBuffer sb = new StringBuffer();
		if (size >= 7) {
			sb.append(str.substring(0, 3));
			sb.append("****");
			sb.append(str.substring(7, size));
		}
		return sb.toString();
	}

	/**
	 * 字符转数组
	 * 
	 * @param str
	 * @return
	 */
	public static String[] changeToArrays(String str) {
		if (isNotNullAndSpace(str)) {
			str = str.replace('[', ' ');
			str = str.replace(']', ' ');
			str = str.replaceAll("\"", "");
			str = str.trim();
			return str.split(",");
		}
		String[] strs = {};
		return strs;
	}

	/**
	 * 字符串数组转换为SQL字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceStr(String str) {
		if (isNotNullAndSpace(str)) {
			str = str.replace('[', ' ');
			str = str.replace(']', ' ');
			str = str.replaceAll("\"", "\'");
			str = str.trim();
		}
		return str;
	}

	/**
	 * 添加SQL分页
	 * 
	 * @param sql
	 * @param begin
	 * @param end
	 * @return
	 */
	public static String addPageSize(String sql, int begin, int end) {
		StringBuffer sb = new StringBuffer("SELECT * FROM (");
		sb.append(sql);
		sb.append(") WHERE ");
		sb.append("ROWNUM>=" + begin);
		sb.append(" AND ROWNUM<=" + end);
		return sb.toString();
	}

	/**
	 * 获取图片主键
	 * 
	 * @param type
	 * @return
	 */
	public static String queryImgKeyId(String type) {
		return type + getCurrentDateFormat("yyyyMMdd") + getUUID();
	}

	/**
	 * 拼接字符串
	 * 
	 * @param args
	 * @return
	 */
	public static String join(String... args) {
		StringBuffer sb = new StringBuffer("[");
		if (args != null) {
			for (String str : args) {
				sb.append(str + ",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * 身份证加*处理
	 * 
	 * @param idCard
	 * @return
	 */
	public static String procIdCard(String idCard) {
		StringBuffer sb = new StringBuffer("");
		if (StringUtil.isNotNullAndSpace(idCard)) {
			if (idCard.length() == 18) {
				sb.append(idCard.substring(0, 10));
				sb.append("****");
				sb.append(idCard.substring(14, 18));
			} else if (idCard.length() == 15) {
				sb.append(idCard.substring(0, 8));
				sb.append("****");
				sb.append(idCard.substring(12, 15));
			} else {
				sb.append(idCard);
			}
		}
		return sb.toString();
	}

	/**
	 * 根据身份编号获取生日
	 *
	 * @param idCard
	 *            身份编号
	 * @return 生日(yyyyMMdd)
	 */
	public static String getBirthByIdCard(String idCard) {
		return idCard.substring(6, 14);
	}

	/**
	 * 根据身份编号获取性别
	 *
	 * @param idCard
	 *            身份编号
	 * @return 性别(M-男，F-女，N-未知)
	 */
	public static String getGenderByIdCard(String idCard) {
		String sGender = "未知";
		String sCardNum = idCard.substring(16, 17);
		if (Integer.parseInt(sCardNum) % 2 != 0) {
			sGender = "男";
		} else {
			sGender = "女";
		}
		return sGender;
	}

	/**
	 * 获取文件后缀
	 * 
	 * @param fileName
	 * @return
	 */
	public static String queryFileSuffix(String fileName) {
		if (StringUtil.isNotNullAndSpace(fileName)) {
			return fileName.substring(fileName.lastIndexOf("."), fileName.length());
		}
		return "";
	}

	/**
	 * 根据年月获取月的天数
	 * 
	 * @param yearStr
	 * @param monthStr
	 * @return
	 */
	public static int queryDays(String yearStr, String monthStr) {
		int result;
		int year = Integer.valueOf(yearStr);
		int month = Integer.valueOf(monthStr);
		if (month == 2) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				result = 29;
			} else {
				result = 28;
			}
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			result = 30;
		} else {
			result = 31;
		}
		return result;
	}

	/**
	 * 时间处理
	 * 
	 * @param str
	 * @return
	 */
	public static String processTime(String str) {
		if (isNotNullAndSpace(str)) {
			int len = str.length();
			if (len == 3) {
				return str.substring(0, 2) + ":" + str.substring(2, 3) + "0";
			} else if (len == 4) {
				return str.substring(0, 2) + ":" + str.substring(2, 4);
			} else if (len == 2) {
				return str + ":" + "00";
			} else if (len == 1) {
				return "0" + str + ":" + "00";
			}
		}
		return str;
	}

	private static MessageDigest md5 = null;

	public static String md5(String str) throws Exception {
		if (md5 == null) {
			md5 = MessageDigest.getInstance("MD5");
		}
		md5.update(str.getBytes(SysContants.UTF_8_B));
		byte b[] = md5.digest();
		int i;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();
	}

	public static int totalPage(int count, String pageSize) {
		int size = Integer.parseInt(pageSize);
		if (count > 0 && size > 0) {
			int num = count / size;
			if (count % size > 0) {
				num++;
			}
			return num;
		}
		return 0;
	}

	public static Object stringToObject(String str, Class<?> className) {
		return JSONObject.parseObject(str, className);
	}

	/**
	 * 截取字符前n位
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public static String interceptString(String str, int len) {
		if (isNotNullAndSpace(str)) {
			int strLen = str.length();
			if (strLen > len) {
				return str.substring(0, len);
			}
		}
		return str;
	}

	/**
	 * 
	 * Description:计算日期，天数加n
	 * 
	 * @author Ysj
	 * @version 1.0.0 2018年2月26日 下午2:33:30
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date calDate(Date date, int days) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.add(Calendar.DAY_OF_YEAR, days);
		return rightNow.getTime();
	}

	public static String calDateToStr(Date date, int days) {
		Date date1 = calDate(date, days);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date1);
	}

	public static String calDateByStr(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		Date newDate = StringUtil.calDate(date, 1);
		return sdf.format(newDate);
	}

	/**
	 * 计算两个日期相差天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int days(String d1, String d2) {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		int days = 0;
		try {
			Date date1 = f.parse(d1);
			Date date2 = f.parse(d2);
			long time = date1.getTime() - date2.getTime();
			days = (int) (time / (3600 * 24 * 1000));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	/**
	 * 计算两个日期相差天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int days(Date date1, String d2) {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		int days = 0;
		try {
			Date date2 = f.parse(d2);
			long time = date1.getTime() - date2.getTime();
			days = (int) (time / (3600 * 24 * 1000));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	/**
	 * 计算两个日期相差天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int days(String d1, Date date2) {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		int days = 0;
		try {
			Date date1 = f.parse(d1);
			long time = date1.getTime() - date2.getTime();
			System.out.println(time);
			days = (int) (time / (3600 * 24 * 1000));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	/**
	 * 计算两个日期相差天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int days(String d2) {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		int days = 0;
		try {
			Date date1 = new Date();
			Date date2 = f.parse(d2);
			long time = date1.getTime() - date2.getTime();
			days = (int) (time / (3600 * 24 * 1000));
			if (days < 0) {
				days = 0;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	public static String calDate(String str, int days) {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = f.parse(str);
			date = calDate(date, days);
			str = f.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 日期比较 晚于返回true
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean dateStrCompare(String str1, String str2) {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date1 = f.parse(str1);
			Date date2 = f.parse(str2);
			long t = date1.getTime() - date2.getTime();
			if (t > 0) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String replace(String str) {
		if (isNotNullAndSpace(str)) {
			str = str.replaceAll(SysContants.CHAR_UNLINE, SysContants.CHAR_EMPTY);
		}
		return str;
	}

	/**
	 * 两个数相除保留两位小数百分比
	 * 
	 * @param d1
	 * @param d2
	 * @param size
	 * @return
	 */
	public static double calPercentValue(double d1, double d2, int size) {
		if (d1 == 0) {
			return 0;
		}
		if (d2 == 0) {
			return 100;
		}
		d1 = d1 * 100 / d2;
		BigDecimal bg = new BigDecimal(d1);
		d1 = bg.setScale(size, BigDecimal.ROUND_HALF_UP).doubleValue();
		return d1;
	}

	public static String queryFileType(String fileName) {
		if (isNotNullAndSpace(fileName)) {
			int index = fileName.lastIndexOf(".");
			if (index != -1) {
				return fileName.substring(index + 1, fileName.length());
			}
		}
		return "";
	}

	public static String queryJsonStr(JSONObject obj, String key) {
		try {
			return obj.getString(key);
		} catch (Exception e) {
			return SysContants.CHAR_EMPTY;
		}
	}

	public static String getNumberRandomString(int len) {
		String base = "0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		int number = 0;
		for (int i = 0; i < len; i++) {
			number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static long getLongTime() {
		Date date = new Date();
		long time = date.getTime();
		time = time / 1000;
		return time;
	}


	public static Date getDataByStr01(String str, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getDataByStr02(String str, String format, String format01) {
		if (StringUtil.isNotNullAndSpace(str)) {
			if (str.length() == 10) {
				format = "yyyy-MM-dd";
			} else if (str.length() >= 19) {
				format = "yyyy-MM-dd HH:mm:ss";
			} else {
				return str;
			}
			SimpleDateFormat sf = new SimpleDateFormat(format);
			Date date = null;
			try {
				date = sf.parse(str);
				sf = new SimpleDateFormat(format01);
				return sf.format(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return str;
		} else {
			return str;
		}
	}

	public static double chgLongToDouble(long l) {
		double d = l / 100.0;
		return d;
	}

	public static long chgStrToLong(String str) {
		if (StringUtil.isNotNullAndSpace(str)) {
			Double d = Double.valueOf(str);
			return d.longValue();
		}
		return 0;
	}

	public static String chgCheckStr(String str) {
		if (isNotNullAndSpace(str) && "on".equals(str)) {
			return "1";
		}
		return "0";
	}

	public static void main(String[] args) {
		System.out.println(StringUtil.bankChg(""));
	}

	private static DecimalFormat mFormatDecimal2 = new DecimalFormat("0.00");
	public static String formatDecimal2(String str){
		if(StringUtil.isNotNullAndSpace(str)){
			try{
				return mFormatDecimal2.format(new BigDecimal(str));
			} catch (NumberFormatException e){

			}
			return str;
		} else {
			return SysContants.CHAR_EMPTY_SHOW;
		}

	}
}

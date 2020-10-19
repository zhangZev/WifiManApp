package com.wanzhong.common.util;

public class SysContants {
	public static final String SYSTEM_TYPE_ANDROID = "android";
	// 账务日期
	public static final String YW_DT = "YW_DT";
	public static final String DATE_FORMAT_1 = "yyyyMMdd";
	public static final String DATE_FORMAT_2 = "yyyyMMddHHmmss";
	public static final String UTF_8 = "utf-8";
	public static final String UTF_8_B = "UTF-8";
	public static final String PK_DB_ERR = "SQLSTATE=23505";
	public static final int NUM_0 = 0;
	public static final int NUM_1 = 1;
	public static final int NUM_2 = 2;
	public static final int NUM_3 = 3;
	public static final int NUM_9 = 9;
	public static final int NUM_10 = 10;
	public static final int NUM_1024 = 1024;
	public static final int NUM_400 = 400;
	public static final int NUM_200 = 200;
	
	public static final long TIME_8 = 8 * 3600 * 1000;
	public static final long TIME_30 = 1800 * 1000;

	public static final int AUTOGRAPH_OFFSET = 160;
	public static final String TIMESTAMP = "timestamp";
	/**
	 * 交易编号
	 */
	public static final String TRADE_ID = "tradeId";
	/**
	 * 用户编号
	 */
	public static final String USER_ID = "userId";
	/**
	 * 登录编号
	 */
	public static final String LOGIN_ID = "loginId";
	/**
	 * 登录密码
	 */
	public static final String PASSWD = "passwd";
	/**
	 * 新登录密码
	 */
	public static final String NEW_PASSWD = "new_passwd";
	/**
	 * 令牌编号
	 */
	public static final String TOKEN_ID = "tokenId";
	/**
	 * md5加密签名
	 */
	public static final String SIGN = "sign";
	/**
	 * data
	 */
	public static final String DATA = "data";
	/**
	 * -1 错误
	 */
	public static final String RET_CODE = "retCode";
	/**
	 * 返回信息
	 */
	public static final String RET_MSG = "retMsg";
	/**
	 * 请求类型
	 */
	public static final String REQUEST_TYPE = "request_type";
	/**
	 * 请求类型 数据类型 默认
	 */
	public static final String REQUEST_TYPE_DATA = "data";
	/**
	 * 请求类型 excel类型
	 */
	public static final String REQUEST_TYPE_EXCEL = "excel";
	/**
	 * excel名称
	 */
	public static final String EXCEL_TYPE = "excel_type";
	/**
	 * 菜单编号
	 */
	public static final String MENU_ID = "menuId";
	/**
	 * 提交类型 简单
	 */
	public static final String POST_TYPE_S = "S";
	/**
	 * 提交类型 复杂
	 */
	public static final String POST_TYPE_B = "B";

	public static final String CHAR_EMPTY_SHOW = "--";
	public static final String CHAR_EMPTY = "";
	public static final String CHAR_NULL = "null";

	public static final String FILE_TMP = "FILE_TMP";
	public static final String SC_FILE_TMP = "SC_FILE_TMP";
	
	public static final String FILE_HZ = ".jpg";
	public static final String FILE_IMG_TYPE = "jpg";
	public static final String IMG_TYPE_PNG = "png";

	public static final String UPLOAD_FILE_DIR = "UPLOAD_FILE_DIR";

	public static final String CHAR_10 = "10";
	public static final String CHAR_9 = "9";
	public static final String CHAR_8 = "8";
	public static final String CHAR_7 = "7";
	public static final String CHAR_6 = "6";
	public static final String CHAR_5 = "5";
	public static final String CHAR_4 = "4";
	public static final String CHAR_3 = "3";
	public static final String CHAR_2 = "2";
	public static final String CHAR_1 = "1";
	public static final String CHAR_0 = "0";
	public static final String CHAR_SPACE = "SPACE";
	public static final String CHAR_NUM = "num";
	public static final String CHAR_UNLINE = "-";
	public static final String CHAR_COMMA = ",";
	
	public static final String CHAR_Y = "Y";
	public static final String CHAR_N = "N";
	/**
	 * 1分钟失效时间
	 */
	public static final int TIME_OUT = 600000;
	public static final String RET_ERR_INVALID = "ERRINV";
	
	public static final String OPEN_MENU = "openMenu";
	
	public static final String RET_CODE_SUCCESS = "000000";
	public static final String RET_CODE_FAIL = "1";
	
	public static final String RET_MSG_SUC_01 = "保存成功";
	public static final String RET_MSG_SUC_02 = "修改成功";
	public static final String RET_MSG_SUC_04 = "删除成功";
	
	public static final String RET_MSG_SUC_03 = "重置密码成功";
	
	public static final String RET_MSG_SUC_05 = "提交成功";
	
	public static final String RET_MSG_SUC_06 = "申请成功";
	
	public static final String RET_MSG_SUC_07 = "拒绝成功";
	
	public static final String RET_MSG_SUC_08 = "退回成功";
	
	public static final String RET_MSG_SUC_09 = "操作成功";
	
	public static final String RET_MSG_SUC_10 = "审核不通过，自动退回";
	
	public static final String RET_MSG_SUC_11 = "启用成功";
	
	public static final String RET_MSG_SUC_12 = "停用成功";
	
	public static final String RET_CODE_SYSERR = "-1";
	
	public static final String RET_MSG_SYSERR = "尊敬的用户，系统繁忙";
	
	public static final String RET_MSG_ERR_01 = "尊敬的用户，账号或者密码错误";
	
	public static final String RET_MSG_ERR_02 = "尊敬的用户，旧密码错误";
	
	public static final String RET_MSG_ERR_03 = "尊敬的用户，登录账号已经存在";
	
	public static final String RET_MSG_ERR_04 = "尊敬的用户，操作失败";
	
	public static final String RET_MSG_ERR_08 = "尊敬的用户，参数错误";
	
	public static final String RET_MSG_ERR_09 = "尊敬的用户，未找到您的额度信息";
	
	public static final String RET_MSG_ERR_10 = "尊敬的用户，您的额度暂时不可用";
	
	public static final String RET_MSG_ERR_11 = "尊敬的用户，您的可用额度不足";
	
	public static final String RET_MSG_ERR_05 = "尊敬的用户，该笔记录存在未批复的收汇记录";
	
	public static final String RET_MSG_PK_01 = "尊敬的用户，该主键数据已经存在";
	
	public static final String RET_MSG_ERR_06 = "尊敬的用户，手机号码错误";
	
	public static final String RET_MSG_ERR_07 = "尊敬的用户，手机验证码发送失败";
	
	public static final String RET_MSG_ERR_012 = "尊敬的用户，登录失效重新登录";
	
	public static final String RET_MSG_MENU_01 = "请先删除子菜单，不允许直接删除";
	
	public static final String RET_MSG_MENU_02 = "顶级菜单不允许删除";
	
	public static final String RET_MSG_MENU_03 = "该功能暂时开通，尽请期待。";
	
	public static final String RET_MSG_ORG_01 = "顶级机构不允许删除";
	
	public static final String RET_MSG_ORG_02 = "请先删除子机构，不允许直接删除";
	
	public static final String RET_MSG_TREE_01 = "不支持的树形类型";
	
	public static final String HTML = ".html";
	/**
	 * 分页当前页
	 */
	public static final String PAGE_INDEX = "pageIndex";
	/**
	 * 分页显示数量
	 */
	public static final String PAGE_SIZE = "pageSize";
	
	public static final String INFO = "info";
	public static final String KEY_ID = "keyId";
	public static final String ORG_ID = "orgId";
	public static final String TYPE_ID = "typeId";
	
	public static final String KEY_TYPE = "keyType";
	public static final String KEY_1 = "key1";
	public static final String KEY_2 = "key2";
	public static final String KEY_3 = "key3";
	public static final String STATUS = "status";
	
	public static final String KEY_TYPE_MENU = "menu";
	public static final String KEY_TYPE_ORG = "org";
	public static final String KEY_TYPE_ORG_USER = "org_user";
	public static final String KEY_TYPE_DICT = "sys_dict_type";
	
	public static final String SYS_ORG_PROPERTY = "sys_org_property";
	public static final String SYS_ORG_TYPE = "sys_org_type";
	
	public static final String ORG_USER_TYPE = "org_user_type";
	
	public static final String NAME = "name";
	
	public static final String FILE_OBJ = "fileObj";
	
	public static final String TREES_OBJ = "treesObj";
	
	public static final String ORDER_FILE = "order_file";
	public static final String SHIPMENT_FILE = "shipment_file";
	
	public static final String FILE_TYPE = "file_type";
	
	public static final String ORG_TYPE = "orgType";
	
	public static final String TASK_ID = "task_id";
	
	public static final String T_MENU = "t_menu";
	public static final String T_ORG = "t_org";
	public static final String T_USER_DETAIL = "t_user_detail";
	public static final String T_USER = "t_user";
	public static final String T_ROLE = "t_role";
	public static final String T_ORDER = "t_order";
	public static final String SYS_NOTICE = "sys_notice";
	public static final String T_FIN_USER_APPLY = "t_fin_user_apply";
	public static final String T_ORDER_CAR_CHECK = "t_order_car_check";
	public static final String T_ORDER_CAR = "t_order_car";
	public static final String T_ORDER_CAR_EXAM = "t_order_car_exam";
	/**
	 * 订单状态
	 */
	public static final String ORDER_STATUS = "ORDER_STATUS";
	/**
	 * 借款期限
	 */
	public static final String LOAN_LIMIT = "LOAN_LIMIT";
	/**
	 * 用户类型
	 */
	public static final String USER_TYPE = "USER_TYPE";
	/**
	 * 金融产品类型   1单车金融 2库存金融
	 * */
	public static final String FIN_PRODUCT_TYPE = "FIN_PRODUCT_TYPE";
	/**
	 * 车辆状态   0监管中  1已置换 2已完结 3置换申请 4已补充资料 5审核失败
	 * */
	public static final String CAR_STATUS = "CAR_STATUS";
	/**车辆置换状态 0未置换 1置换转入 2置换转出*/
	public static final String CAR_CHANGE_STATUS = "CAR_CHANGE_STATUS";
	/**车辆历史有无异常 0无异常 1 有异常*/
	public static final String CAR_HIS_ERR = "CAR_HIS_ERR";
	/**盘库状态 0 正常 1 异常*/
	public static final String CAR_CHECK_STATUS = "CAR_CHECK_STATUS";
	/**车辆类型 0 二手车 1 其他*/
	public static final String CAR_TYPE = "CAR_TYPE";
	public static final String T_FIN_USER_APPLY_OPINION = "t_fin_user_apply_opinion";
	public static final String T_FIN_USER_APPLY_ASSURE = "t_fin_user_apply_assure";
	public static final String T_FIN_USER_EXAM = "t_fin_user_exam";
	public static final String T_FIN_USER_QUOTA = "t_fin_user_quota";
	
	public static final String EXAM_POST_评估岗 = "0";
	public static final String EXAM_POST_初审岗 = "1";
	public static final String EXAM_POST_复核岗 = "2";
	public static final String EXAM_POST_终审岗 = "3";
	
	public static final String CHAR_NEG_1 = "-1";
	public static final String T_FIN_USER_APPLY_ENTER_PARTNER = "t_fin_user_apply_enter_partner";
}

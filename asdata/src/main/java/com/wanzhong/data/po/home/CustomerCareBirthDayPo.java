package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

/**
 * [
 *             {
 *                 "grade": "客户等级（0其他1H级2A级3B级4C级5无效6成交）",
 *                 "ucname": "客户姓名",
 *                 "phone": "客户电话",
 *                 "weixin": 客户微信,
 *                 "customer_id": "客户id",
 *                 "expire_data": "生日（格式：08/29）",
 *                 "create_name": “销售姓名”
 *             }
 *         ]
 * */
public class CustomerCareBirthDayPo extends BasePo {
    private String grade;
    private String ucname;
    private String phone;
    private String weixin;
    private String customer_id;
    private String expire_data;
    private String create_name;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUcname() {
        return StringUtil.changeNullDefault(ucname);
    }

    public void setUcname(String ucname) {
        this.ucname = ucname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getExpire_data() {
        return StringUtil.changeNullDefault(expire_data);
    }

    public void setExpire_data(String expire_data) {
        this.expire_data = expire_data;
    }

    public String getCreate_name() {
        return StringUtil.changeNullDefault(create_name);
    }

    public void setCreate_name(String create_name) {
        this.create_name = create_name;
    }
}

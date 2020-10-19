package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

import java.util.List;

public class HomeSiginData extends BasePo {

    /**一周签到集合，周一到周日，0未签到；1已签到*/
    private List<String> traces;

    /**本周签到总天数*/
    private String sign_day;
    /**今日是否签到：0已签到1未签到*/
    private String is_sign;
    /**今日签到获得积分*/
    private String integral_num;

    public List<String> getTraces() {
        return traces;
    }

    public void setTraces(List<String> traces) {
        this.traces = traces;
    }

    public String getSign_day() {
        return StringUtil.changeNullDefault(sign_day);
    }

    public void setSign_day(String sign_day) {
        this.sign_day = sign_day;
    }

    public String getIs_sign() {
        return StringUtil.changeNull(is_sign);
    }

    public void setIs_sign(String is_sign) {
        this.is_sign = is_sign;
    }

    public String getIntegral_num() {
        return StringUtil.changeNullDefault(integral_num);
    }

    public void setIntegral_num(String integral_num) {
        this.integral_num = integral_num;
    }

    public boolean hasSignToday(){
        return SysContants.CHAR_0.equals(getIs_sign());
    }
}

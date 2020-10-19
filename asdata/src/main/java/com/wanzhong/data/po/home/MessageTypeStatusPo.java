package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
/**
 * 响应数据主体{
 *         "system_num": "系统消息条数",
 *         "finance_num": "金融消息条数",
 *         "integral_num": “积分消息条数”
 *     }*/
public class MessageTypeStatusPo extends BasePo {

    private String system_num;

    private String finance_num;

    private String integral_num;

    private int system_num_int = -1;

    private int finance_num_int = -1;

    private int integral_num_int = -1;


    public String getSystem_num() {
        return StringUtil.changeNullInt(system_num);
    }

    public void setSystem_num(String system_num) {
        this.system_num = system_num;
    }

    public String getFinance_num() {
        return StringUtil.changeNullInt(finance_num);
    }

    public void setFinance_num(String finance_num) {
        this.finance_num = finance_num;
    }

    public String getIntegral_num() {
        return StringUtil.changeNullInt(integral_num);
    }

    public void setIntegral_num(String integral_num) {
        this.integral_num = integral_num;
    }

    public int getSystem_num_int() {
        if(system_num_int == -1){
            try{
                system_num_int = Integer.parseInt(system_num);
            } catch (NumberFormatException e){
                system_num_int = 0;
            }
        }
        return system_num_int;
    }

    public void setSystem_num_int(int system_num_int) {
        this.system_num_int = system_num_int;
    }

    public int getFinance_num_int() {
        if(finance_num_int == -1){
            try{
                finance_num_int = Integer.parseInt(finance_num);
            } catch (NumberFormatException e){
                finance_num_int = 0;
            }
        }
        return finance_num_int;
    }

    public void setFinance_num_int(int finance_num_int) {
        this.finance_num_int = finance_num_int;
    }

    public int getIntegral_num_int() {
        if(integral_num_int == -1){
            try{
                integral_num_int = Integer.parseInt(integral_num);
            } catch (NumberFormatException e){
                integral_num_int = 0;
            }
        }
        return integral_num_int;
    }

    public void setIntegral_num_int(int integral_num_int) {
        this.integral_num_int = integral_num_int;
    }
}

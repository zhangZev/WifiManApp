package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;

/**
 *  {
 *             "sms_template_id": "模版id",
 *             "sms_template_content": “模版内容”
 *         }
 * */
public class SmsTemplatePo extends BasePo {
    private String sms_template_id;
    private String sms_template_content;

    public String getSms_template_id() {
        return StringUtil.changeNull(sms_template_id);
    }

    public void setSms_template_id(String sms_template_id) {
        this.sms_template_id = sms_template_id;
    }

    public String getSms_template_content() {
        return StringUtil.changeNull(sms_template_content);
    }

    public void setSms_template_content(String sms_template_content) {
        this.sms_template_content = sms_template_content;
    }
}

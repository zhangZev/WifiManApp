package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.common.util.SysContants;

/**
 * {
 *                 "message_id": "消息主键",
 *                 "type_main": "消息类型主类  类型(0系统1金融2积分)",
 *                 "type_vice": "消息类型副类 系统:0密码提示,1系统提示;金融:0审核通知,1到账通知,2还款提醒,3还款成功,4额度通知;积分:0获得积分,1积分兑换,2使用提示,3等级提示,4扣分提示",
 *                 "title": "标题",
 *                 "content": "内容",
 *                 "createdt_time": “时间，格式：2019/08/09”
 *                 "status":"状态 0 未读 1已读"
 *             }
 * */
public class MessageItemPo extends BasePo {

    private  String message_id;

    private String type_main;

    private String type_vice;

    private String title;

    private String content;

    private String createdt_time;

    private String status;

    public String getMessage_id() {
        return StringUtil.changeNullInt(message_id);
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getType_main() {
        return StringUtil.changeNull(type_main, SysContants.CHAR_NEG_1);
    }

    public void setType_main(String type_main) {
        this.type_main = type_main;
    }

    public String getType_vice() {
        return StringUtil.changeNull(type_vice,SysContants.CHAR_NEG_1);
    }

    public void setType_vice(String type_vice) {
        this.type_vice = type_vice;
    }

    public String getTitle() {
        return StringUtil.changeNullDefault(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return StringUtil.changeNullDefault(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedt_time() {
        return StringUtil.changeNullDefault(createdt_time);
    }

    public void setCreatedt_time(String createdt_time) {
        this.createdt_time = createdt_time;
    }

    public String getStatus() {
        return StringUtil.changeNull(status,SysContants.CHAR_1);
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public boolean hasRead(){
        return SysContants.CHAR_1.equals(getStatus());
    }
}

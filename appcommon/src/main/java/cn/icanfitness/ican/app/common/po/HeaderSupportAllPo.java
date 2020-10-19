package cn.icanfitness.ican.app.common.po;


import com.wanzhong.data.po.HeaderSupportBasePo;


public class HeaderSupportAllPo extends HeaderSupportBasePo {

    @Override
    public String getHeaderName() {
        return "*";
    }

    @Override
    public String getText() {
        return "不限";
    }
}

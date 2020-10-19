package cn.icanfitness.ican.app.common.po;


import com.wanzhong.common.util.StringUtil;
import com.wanzhong.data.po.home.SimpleSingleChooseItemPo;


/**
 * {
*                     "id": "id",
*                     "name": "地区名称",
*                     "firstletter": “首字母”
*                 }
 * */
public class ProviceCityAreaItemPo extends SimpleSingleChooseItemPo {


    private String name;
    private String firstletter;

    private String code;
    private String parent_code;
    public String getName() {
        return StringUtil.changeNullDefault(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstletter() {
        return firstletter;
    }

    public void setFirstletter(String firstletter) {
        this.firstletter = firstletter;
    }

  /*  @Override
    public String getHeaderName() {
        return getFirstletter();
    }*/


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

}

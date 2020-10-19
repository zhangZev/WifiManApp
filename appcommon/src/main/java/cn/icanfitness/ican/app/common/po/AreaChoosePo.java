package cn.icanfitness.ican.app.common.po;


import com.wanzhong.common.po.BasePo;
import com.wanzhong.data.po.home.SimpleSingleChooseItemPo;


public class AreaChoosePo extends BasePo {

    SimpleSingleChooseItemPo province;
    SimpleSingleChooseItemPo city;
    SimpleSingleChooseItemPo area;
    SimpleSingleChooseItemPo street;

    public SimpleSingleChooseItemPo getProvince() {
        return province;
    }

    public void setProvince(SimpleSingleChooseItemPo province) {
        this.province = province;
    }

    public SimpleSingleChooseItemPo getCity() {
        return city;
    }

    public void setCity(SimpleSingleChooseItemPo city) {
        this.city = city;
    }

    public SimpleSingleChooseItemPo getArea() {
        return area;
    }

    public void setArea(SimpleSingleChooseItemPo area) {
        this.area = area;
    }

    public SimpleSingleChooseItemPo getStreet() {
        return street;
    }

    public void setStreet(SimpleSingleChooseItemPo street) {
        this.street = street;
    }
}

package cn.icanfitness.ican.app.common.po;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.data.po.HeaderSupportBasePo;

import java.util.List;


/**
 * {
 *             "group_value": 集合[
 *                 {
 *                     "id": id,
 *                     "name": "名称",
 *                     "logo": "logo（只有查询品牌时有）",
 *                     "firstletter": "首字母（只有查询品牌时有，前端不会用到）",
 *                     "typeid": 车系类型id（只有查询车系时有，前端不会用到）,
 *                     "typename": "车系类型名称（只有查询车系时有，前端不会用到）",
 *                     "years": 车型年份（只有查询车型年份时有，前端不会用到）
 *                 }
 *             ],
 *             "group_name": "分组名称（品牌为字母，车系为类型名称，车型为年份）",
 *             "group_key": “分组id（品牌为字母，车系为类型id，车型为年份）”
 *         }
 * */
public class GroupDataHolderPo<T extends HeaderSupportBasePo> extends BasePo {

    private List<T> group_value;

    private String group_name;

    private String group_key;

    public List<T> getGroup_value() {
        return group_value;
    }

    public void setGroup_value(List<T> group_value) {
        this.group_value = group_value;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_key() {
        return group_key;
    }

    public void setGroup_key(String group_key) {
        this.group_key = group_key;
    }
}

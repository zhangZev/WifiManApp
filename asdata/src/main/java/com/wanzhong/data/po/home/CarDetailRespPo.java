package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;
import com.wanzhong.common.util.SysContants;

import java.util.List;

/**
 * {
 *         "operSets": 权限数组，要么有1，要么无，有1显示编辑按钮[
 *             1
 *         ],
 *         "carDetail": {
 *             （详情同车源）
 *         },
 *         "customer": 匹配客户（只有车辆为0在售，1预定时，才有可能有数据）[
 *             {
 *                 "customer_id": "客户id",
 *                 "grade": "客户等级（0其他1H级2A级3B级4C级5无效6成交）",
 *                 "customer_name": "客户姓名",
 *                 "buy_car_need": "买车需求",
 *                 "create_time": "创建时间（格式：2019/08/17 14:05）",
 *                 "follow_name": “销售姓名”
 *             }
 *         ],
 *         "is_mycar": 是否是车商自己的车（0是1否）
 *     }
 * */
public class CarDetailRespPo extends BasePo {

    private String[] operSets;

    private CarDetailPo carDetail;

    private List<CustomerItemPo> customer;

    private String is_mycar;

    public String[] getOperSets() {
        return operSets;
    }

    public void setOperSets(String[] operSets) {
        this.operSets = operSets;
    }

    public CarDetailPo getCarDetail() {
        return carDetail;
    }

    public void setCarDetail(CarDetailPo carDetail) {
        this.carDetail = carDetail;
    }

    public List<CustomerItemPo> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerItemPo> customer) {
        this.customer = customer;
    }

    public boolean canEdit(){
        return operSets != null && operSets.length > 0 && SysContants.CHAR_1.equals(operSets[0]);
    }

    public String getIs_mycar() {
        return is_mycar;
    }

    public void setIs_mycar(String is_mycar) {
        this.is_mycar = is_mycar;
    }
    public boolean isMyCar(){
        return SysContants.CHAR_0.equals(getIs_mycar());
    }
}

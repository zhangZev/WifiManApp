package com.wanzhong.data.po.home;

import com.wanzhong.common.po.BasePo;

import java.util.List;

/**
 * {
 *         "all_sources": 所有来源[
 *             {
 *                 "source_name": "名称",
 *                 "source_id": "主键",
 *                 "is_common": “是否常用：0是1否”
 *             }
 *         ],
 *         "commons": 常用来源[
 *             {
 *                 "source_name": "名称",
 *                 "source_id": "主键",
 *                 "is_common": “是否常用：0是1否”
 *             }
 *         ]
 * */
public class DealerCustomerSourceHolderPo extends BasePo {

    private List<DealerCustomerSourceItemPo> all_sources;

    private List<DealerCustomerSourceItemPo> commons;

    public List<DealerCustomerSourceItemPo> getAll_sources() {
        return all_sources;
    }

    public void setAll_sources(List<DealerCustomerSourceItemPo> all_sources) {
        this.all_sources = all_sources;
    }

    public List<DealerCustomerSourceItemPo> getCommons() {
        return commons;
    }

    public void setCommons(List<DealerCustomerSourceItemPo> commons) {
        this.commons = commons;
    }
}

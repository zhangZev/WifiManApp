package com.wanzhong.data.po.home;

import com.alibaba.fastjson.JSONObject;
import com.wanzhong.common.po.ComRequestPo;
import com.wanzhong.common.util.StringUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TUserCarPo extends ComRequestPo {

    private String car_id;
    /**
     * 主键
     * yyyyMMdd+6位顺序号
     */
    private String key_id;

    /**
     * 封面图
     */
    private String cover_chart_img;

    /**
     * 缩略图
     */
    private String thumbnail_img;

    /**
     * 左前45° 车头
     */
    private String car_photos_lt45;

    /**
     * 右后45° 车尾
     */
    private String car_photos_rd45;

    /**
     * 右侧 车身
     */
    private String car_photos_reight;

    /**
     * 发动机
     */
    private String car_photos_engine;

    /**
     * 前内饰
     */
    private String car_photos_t_trim;

    /**
     * 后内饰
     */
    private String car_photos_d_trim;

    /**
     * 仪表盘
     */
    private String car_photos_dashboard;

    /**
     * 车架号
     */
    private String shelf_id_dashboard;

    private String cover_chart_img_url;

    private String thumbnail_img_url;

    private String car_photos_lt45_url;
    private String car_photos_rd45_url;
    private String car_photos_reight_url;
    private String car_photos_engine_url;
    private String car_photos_t_trim_url;
    private String car_photos_d_trim_url;
    private String car_photos_dashboard_url;
    private String shelf_id_dashboard_url;

    /**
     * 品牌
     */
    private String trademark;

    /**
     * 车系
     */
    private String demio_name;

    /**
     * 车型
     */
    private String motorcycle_type;

    /**
     * 品牌id
     */
    private String car_brand_id;

    /**
     * 车系id
     */
    private String car_series_id;

    /**
     * 车型id
     */
    private String car_specimens_id;

    /**
     * 品牌名
     */
    private String car_brand_name;

    /**
     * 车系名称
     */
    private String car_series_name;

    /**
     * 车型名称
     */
    private String car_specimens_name;

    /**
     * 排量
     */
    private String cc;

    /**
     * 车架号
     */
    private String shelf_id;

    /**
     * 发动机号
     */
    private String engine_number;

    /**
     * 初次上牌
     */
    private String begin_register_dt;

    /**
     * 出厂日期
     */
    private String maturity_dt;

    /**
     * 车身颜色
     */
    private String demio_color;

    /**
     * 内饰颜色
     */
    private String interior_color;

    /**
     * 使用性质 0 营运  1非营运  2租赁非营运
     */
    private String use_nature;

    /**
     * 行驶里程（公里数） 单位公里数
     */
    private String travel_mileage;

    /**
     * 车牌号
     */
    private String car_num_no;

    /**
     * 过户次数
     */
    private String assigned_count;

    /**
     * 标价 单位元
     */
    private String price;

    /**
     * 同行处理价
     */
    private String same_price;

    /**
     * 车辆描述
     */
    private String tdesc;

    /**
     * 出售价格 单位元
     */
    private String sell_price;

    /**
     * 出售时间 YYYY-MM-DD
     */
    private String sell_dt;

    /**
     * 状态 0 在售 1 已上架 2 已预定 3 已售
     */
    private String status;

    /**
     * 在厅状态 0在厅 1车辆外借 2仓库
     */
    private String hall_status;

    /**
     * 是否添加到微店 0 否 1是
     */
    private String is_m_shop;

    /**
     * 是否同行发布 0 否 1 是
     */
    private String is_m_same;

    /**
     * 创建人
     */
    private String create_user;

    public String getKey_id() {
        if(StringUtil.isNotNullAndSpace(key_id)){
            return key_id;
        }
        return car_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getCover_chart_img() {
        return StringUtil.changeNull(cover_chart_img);
    }

    public void setCover_chart_img(String cover_chart_img) {
        this.cover_chart_img = cover_chart_img;
    }

    public String getThumbnail_img() {
        return StringUtil.changeNull(thumbnail_img);
    }

    public void setThumbnail_img(String thumbnail_img) {
        this.thumbnail_img = thumbnail_img;
    }

    public String getCar_photos_lt45() {
        return StringUtil.changeNull(car_photos_lt45);
    }

    public void setCar_photos_lt45(String car_photos_lt45) {
        this.car_photos_lt45 = car_photos_lt45;
    }

    public String getCar_photos_rd45() {
        return StringUtil.changeNull(car_photos_rd45);
    }

    public void setCar_photos_rd45(String car_photos_rd45) {
        this.car_photos_rd45 = car_photos_rd45;
    }

    public String getCar_photos_reight() {
        return StringUtil.changeNull(car_photos_reight);
    }

    public void setCar_photos_reight(String car_photos_reight) {
        this.car_photos_reight = car_photos_reight;
    }

    public String getCar_photos_engine() {
        return StringUtil.changeNull(car_photos_engine);
    }

    public void setCar_photos_engine(String car_photos_engine) {
        this.car_photos_engine = car_photos_engine;
    }

    public String getCar_photos_t_trim() {
        return StringUtil.changeNull(car_photos_t_trim);
    }

    public void setCar_photos_t_trim(String car_photos_t_trim) {
        this.car_photos_t_trim = car_photos_t_trim;
    }

    public String getCar_photos_d_trim() {
        return StringUtil.changeNull(car_photos_d_trim);
    }

    public void setCar_photos_d_trim(String car_photos_d_trim) {
        this.car_photos_d_trim = car_photos_d_trim;
    }

    public String getCar_photos_dashboard() {
        return StringUtil.changeNull(car_photos_dashboard);
    }

    public void setCar_photos_dashboard(String car_photos_dashboard) {
        this.car_photos_dashboard = car_photos_dashboard;
    }

    public String getShelf_id_dashboard() {
        return StringUtil.changeNull(shelf_id_dashboard);
    }

    public void setShelf_id_dashboard(String shelf_id_dashboard) {
        this.shelf_id_dashboard = shelf_id_dashboard;
    }

    public String getTrademark() {
        return StringUtil.changeNull(trademark);
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getDemio_name() {
        return StringUtil.changeNull(demio_name);
    }

    public void setDemio_name(String demio_name) {
        this.demio_name = demio_name;
    }

    public String getMotorcycle_type() {
        return StringUtil.changeNull(motorcycle_type);
    }

    public void setMotorcycle_type(String motorcycle_type) {
        this.motorcycle_type = motorcycle_type;
    }

    public String getCc() {
        return StringUtil.changeNull(cc);
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getShelf_id() {
        return StringUtil.changeNull(shelf_id).toUpperCase();
    }

    public void setShelf_id(String shelf_id) {
        this.shelf_id = shelf_id;
    }

    public String getEngine_number() {
        return StringUtil.changeNull(engine_number);
    }

    public void setEngine_number(String engine_number) {
        this.engine_number = engine_number;
    }

    public String getBegin_register_dt() {
        return StringUtil.changeNull(begin_register_dt);
    }

    public void setBegin_register_dt(String begin_register_dt) {
        this.begin_register_dt = begin_register_dt;
    }

    public String getMaturity_dt() {
        return StringUtil.changeNull(maturity_dt);
    }

    public void setMaturity_dt(String maturity_dt) {
        this.maturity_dt = maturity_dt;
    }

    public String getDemio_color() {
        return StringUtil.changeNull(demio_color);
    }

    public void setDemio_color(String demio_color) {
        this.demio_color = demio_color;
    }

    public String getInterior_color() {
        return StringUtil.changeNull(interior_color);
    }

    public void setInterior_color(String interior_color) {
        this.interior_color = interior_color;
    }

    public String getUse_nature() {
        return StringUtil.changeNull(use_nature);
    }

    public void setUse_nature(String use_nature) {
        this.use_nature = use_nature;
    }

    public String getTravel_mileage() {
        return StringUtil.changeNull(travel_mileage);
    }

    public void setTravel_mileage(String travel_mileage) {
        this.travel_mileage = travel_mileage;
    }

    public String getAssigned_count() {
        return StringUtil.changeNull(assigned_count);
    }

    public void setAssigned_count(String assigned_count) {
        this.assigned_count = assigned_count;
    }

    public String getPrice() {
        return StringUtil.changeNull(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSame_price() {
        return StringUtil.changeNull(same_price);
    }

    public void setSame_price(String same_price) {
        this.same_price = same_price;
    }

    public String getTdesc() {
        return StringUtil.changeNull(tdesc);
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }

    public String getSell_price() {
        return StringUtil.changeNull(sell_price);
    }

    public void setSell_price(String sell_price) {
        this.sell_price = sell_price;
    }

    public String getSell_dt() {
        return StringUtil.changeNull(sell_dt);
    }

    public void setSell_dt(String sell_dt) {
        this.sell_dt = sell_dt;
    }

    public String getStatus() {
        return StringUtil.changeNull(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHall_status() {
        return StringUtil.changeNull(hall_status);
    }

    public void setHall_status(String hall_status) {
        this.hall_status = hall_status;
    }

    public String getIs_m_shop() {
        return StringUtil.changeNull(is_m_shop);
    }

    public void setIs_m_shop(String is_m_shop) {
        this.is_m_shop = is_m_shop;
    }

    public String getIs_m_same() {
        return StringUtil.changeNull(is_m_same);
    }

    public void setIs_m_same(String is_m_same) {
        this.is_m_same = is_m_same;
    }

    public String getCreate_user() {
        return StringUtil.changeNull(create_user);
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getCar_brand_id() {
        return StringUtil.changeNull(car_brand_id);
    }

    public void setCar_brand_id(String car_brand_id) {
        this.car_brand_id = car_brand_id;
    }

    public String getCar_series_id() {
        return StringUtil.changeNull(car_series_id);
    }

    public void setCar_series_id(String car_series_id) {
        this.car_series_id = car_series_id;
    }

    public String getCar_specimens_id() {
        return StringUtil.changeNull(car_specimens_id);
    }

    public void setCar_specimens_id(String car_specimens_id) {
        this.car_specimens_id = car_specimens_id;
    }

    public String getCar_num_no() {
        return StringUtil.changeNull(car_num_no);
    }

    public void setCar_num_no(String car_num_no) {
        this.car_num_no = car_num_no;
    }

    public String getCar_id() {
        return getKey_id();
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCar_brand_name() {
        return StringUtil.changeNull(car_brand_name)
                ;
    }

    public void setCar_brand_name(String car_brand_name) {
        this.car_brand_name = car_brand_name;
    }

    public String getCar_series_name() {
        return StringUtil.changeNull(car_series_name);
    }

    public void setCar_series_name(String car_series_name) {
        this.car_series_name = car_series_name;
    }

    public String getCar_specimens_name() {
        return StringUtil.changeNull(car_specimens_name)
                ;
    }

    public void setCar_specimens_name(String car_specimens_name) {
        this.car_specimens_name = car_specimens_name;
    }

    public String getCover_chart_img_url() {
        return StringUtil.changeNull(cover_chart_img_url);
    }

    public void setCover_chart_img_url(String cover_chart_img_url) {
        this.cover_chart_img_url = cover_chart_img_url;
    }

    public String getThumbnail_img_url() {
        return StringUtil.changeNull(thumbnail_img_url);
    }

    public void setThumbnail_img_url(String thumbnail_img_url) {
        this.thumbnail_img_url = thumbnail_img_url;
    }

    public String getCar_photos_lt45_url() {
        return StringUtil.changeNull(car_photos_lt45_url);
    }

    public void setCar_photos_lt45_url(String car_photos_lt45_url) {
        this.car_photos_lt45_url = car_photos_lt45_url;
    }

    public String getCar_photos_rd45_url() {
        return StringUtil.changeNull(car_photos_rd45_url);
    }

    public void setCar_photos_rd45_url(String car_photos_rd45_url) {
        this.car_photos_rd45_url = car_photos_rd45_url;
    }

    public String getCar_photos_reight_url() {
        return StringUtil.changeNull(car_photos_reight_url);
    }

    public void setCar_photos_reight_url(String car_photos_reight_url) {
        this.car_photos_reight_url = car_photos_reight_url;
    }

    public String getCar_photos_engine_url() {
        return StringUtil.changeNull(car_photos_engine_url);
    }

    public void setCar_photos_engine_url(String car_photos_engine_url) {
        this.car_photos_engine_url = car_photos_engine_url;
    }

    public String getCar_photos_t_trim_url() {
        return StringUtil.changeNull(car_photos_t_trim_url);
    }

    public void setCar_photos_t_trim_url(String car_photos_t_trim_url) {
        this.car_photos_t_trim_url = car_photos_t_trim_url;
    }

    public String getCar_photos_d_trim_url() {
        return StringUtil.changeNull(car_photos_d_trim_url);
    }

    public void setCar_photos_d_trim_url(String car_photos_d_trim_url) {
        this.car_photos_d_trim_url = car_photos_d_trim_url;
    }

    public String getCar_photos_dashboard_url() {
        return StringUtil.changeNull(car_photos_dashboard_url);
    }

    public void setCar_photos_dashboard_url(String car_photos_dashboard_url) {
        this.car_photos_dashboard_url = car_photos_dashboard_url;
    }

    public String getShelf_id_dashboard_url() {
        return StringUtil.changeNull(shelf_id_dashboard_url);
    }

    public void setShelf_id_dashboard_url(String shelf_id_dashboard_url) {
        this.shelf_id_dashboard_url = shelf_id_dashboard_url;
    }

    public int getUseNatureInt(){
        try{
            return Integer.parseInt(getUse_nature());
        } catch (NumberFormatException e){

        }
        return 0;
    }
    public int getStatusInt(){
        try{
            return Integer.parseInt(getStatus());
        } catch (NumberFormatException e){

        }
        return 0;
    }

    public int getHallStatusInt(){
        try{
            return Integer.parseInt(getHall_status());
        } catch (NumberFormatException e){

        }
        return 0;
    }
    private Map<String,Integer> mFiledKeys = new HashMap<String,Integer>();

    public TUserCarPo(){
        mFiledKeys.put("key_id",1);
        mFiledKeys.put("shelf_id",1);
        mFiledKeys.put("car_num_no",1);
        mFiledKeys.put("same_price",1);
        mFiledKeys.put("car_specimens_id",1);
        mFiledKeys.put("cc",1);
        mFiledKeys.put("engine_number",1);
        mFiledKeys.put("begin_register_dt",1);
        mFiledKeys.put("maturity_dt",1);
        mFiledKeys.put("demio_color",1);
        mFiledKeys.put("interior_color",1);
        mFiledKeys.put("travel_mileage",1);
        mFiledKeys.put("use_nature",1);
        mFiledKeys.put("assigned_count",1);
        mFiledKeys.put("hall_status",1);
        mFiledKeys.put("price",1);
        mFiledKeys.put("peer_price",1);
        mFiledKeys.put("tdesc",1);
        mFiledKeys.put("cover_chart_img",1);
        mFiledKeys.put("thumbnail_img",1);
        mFiledKeys.put("car_photos_lt45",1);
        mFiledKeys.put("car_photos_rd45",1);
        mFiledKeys.put("car_photos_reight",1);
        mFiledKeys.put("car_photos_engine",1);
        mFiledKeys.put("car_photos_t_trim",1);
        mFiledKeys.put("car_photos_d_trim",1);
        mFiledKeys.put("car_photos_dashboard",1);
        mFiledKeys.put("shelf_id_dashboard",1);
    }

    @Override
    public Map<String,String> toFiledMap(){
        final JSONObject json = toJSON();
        final Map<String,String> map = new HashMap<String,String>();
        final Iterator<String> keys =  json.keySet().iterator();
        while (keys.hasNext()){
            final String key = keys.next();
            final String value = json.getString(key);
            if (mFiledKeys.containsKey(key) && StringUtil.isNotNullAndSpace(value)) {
                map.put(key,value);
            }
        }

        json.clear();
        return map;
    }
}

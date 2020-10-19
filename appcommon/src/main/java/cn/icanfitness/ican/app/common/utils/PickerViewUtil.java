package cn.icanfitness.ican.app.common.utils;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.contrarywind.view.WheelView;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.utils.BaseConsts;
import com.wanzhong.core.view.RadioCheckLayout;
import com.wanzhong.core.view.bottombar.UIUtils;

import cn.icanfitness.ican.app.common.R;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PickerViewUtil {

    public static final String TIME_NOT_SURE = "不确定";

    private static PickerViewUtil mPickerViewUtil;

    private PickerViewUtil() {
        RxBus.get().register(this);
    }

    public static PickerViewUtil getInstance() {
        if (mPickerViewUtil == null) {
            mPickerViewUtil = new PickerViewUtil();

        }
        return mPickerViewUtil;
    }

    private TimePickerView mBookArriveShopDatePickView;

    /**
     * 预计到店时间选择器
     */
    public TimePickerView getBookArriveShopDatePickView(Context context, Calendar currentData, OnTimeSelectListener onTimeSelectListener) {
        Calendar selectedDate = currentData != null ? currentData : Calendar.getInstance();//系统当前时间
        if (mBookArriveShopDatePickView == null) {
            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();
            endDate.add(Calendar.YEAR, 9);
            endDate.set(Calendar.MONTH, 0);
            endDate.set(Calendar.DAY_OF_MONTH, 1);
            mBookArriveShopDatePickView = getCommonBuilder(context, onTimeSelectListener)
                    .setDate(selectedDate)
                    .setRangDate(startDate, endDate)
                    .setType(new boolean[]{true, true, true, false, false, false})
                    .setLabel("年", "月", "日", "时", "分", "秒")
                    .build();
        } else {
            mBookArriveShopDatePickView.setDate(selectedDate);
        }
        return mBookArriveShopDatePickView;

    }

    private TimePickerView mExpectBuyDatePickView;

    /**
     * 预计购买时间选择器
     */
    public TimePickerView getExpectBuyDatePickView(Context context, Calendar currentData, OnTimeSelectListener onTimeSelectListener, String title) {
        Calendar selectedDate = currentData != null ? currentData : Calendar.getInstance();//系统当前时间
        if (mExpectBuyDatePickView == null) {
            Calendar startDate = Calendar.getInstance();
            mExpectBuyDatePickView = getCommonBuilder(context, onTimeSelectListener)
                    .setRangDate(startDate,null)
                    .setDate(selectedDate)
                    .setType(new boolean[]{true, true, true, false, false, false})
                    .setLabel("年", "月", "日", "时", "分", "秒")
                    .setLayoutRes(R.layout.view_picker_expect_buy_time, new CustomListener() {

                        @Override
                        public void customLayout(View v) {
                            v.findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            });
                            TextView btnCancel = v.findViewById(R.id.btnCancel);
                            btnCancel.setTextColor(Color.parseColor("#828282"));
                            btnCancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mExpectBuyDatePickView.dismiss();
                                }
                            });
                            TextView btnOk = v.findViewById(R.id.btnSubmit);
                            btnOk.setTextColor(Color.parseColor("#019ee8"));
                            btnOk.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mExpectBuyDatePickView.returnData();
                                    mExpectBuyDatePickView.dismiss();
                                }
                            });
                            if (StringUtil.isNotNullAndSpace(title)) {
                                TextView tvTitle = v.findViewById(R.id.tvTitle);
                                tvTitle.setTextColor(Color.parseColor("#828282"));
                                tvTitle.setText(title);
                            }

                            RadioCheckLayout radioQuickSelect = (RadioCheckLayout) v.findViewById(R.id.radio_check_layuot_quick_select);
                            radioQuickSelect.setSelectMode(RadioCheckLayout.MODE_SINGLE_CLICK);
                            radioQuickSelect.config(4, UIUtils.dip2Px(context, 5), UIUtils.dip2Px(context, 6)
                                    , UIUtils.dip2Px(context, 6), "#2b2b2b", "#019ee8", R.drawable.radio_check_layout_item_bg_n, R.drawable.radio_check_layout_item_bg_h_style2);
                            radioQuickSelect.setData(new String[]{"三天内", "7天内", "10天内", "半个月内", "一个月内", "3个月内", "半年内", "不确定"}, -1);
                            radioQuickSelect.setOnItemSelectedListener(new RadioCheckLayout.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(View view, int index) {
                                    Calendar calendar = Calendar.getInstance();
                                    switch (index) {
                                        case 0:
                                            calendar.add(Calendar.DAY_OF_YEAR, 3);
                                            break;
                                        case 1:
                                            calendar.add(Calendar.DAY_OF_YEAR, 7);
                                            break;
                                        case 2:
                                            calendar.add(Calendar.DAY_OF_YEAR, 10);
                                            break;
                                        case 3:
                                            calendar.add(Calendar.DAY_OF_YEAR, 15);
                                            break;
                                        case 4:
                                            calendar.add(Calendar.MONTH, 1);
                                            break;
                                        case 5:
                                            calendar.add(Calendar.MONTH, 3);
                                            break;
                                        case 6:
                                            calendar.add(Calendar.MONTH, 6);
                                            break;
                                        case 7:
                                            calendar = null;
                                            break;
                                    }
                                    if (calendar != null) {
                                        mExpectBuyDatePickView.setDate(calendar);
                                    } else {
                                        //不确定，返回的Date为null
                                        if (onTimeSelectListener != null) {
                                            onTimeSelectListener.onTimeSelect(null, null);
                                        }
                                        mExpectBuyDatePickView.dismiss();
                                    }
                                }

                                @Override
                                public void onMutiItemSelected(int[] positions) {

                                }
                            });

                        }
                    })
                    .build();

        } else {
            mExpectBuyDatePickView.setDate(selectedDate);
        }
        return mExpectBuyDatePickView;

    }


    private TimePickerView mFollowUpTimePicker;

    /**
     * 计划跟进时间选择器
     */
    public TimePickerView getFollowUpTimePickView(Context context, Calendar currentData, OnTimeSelectListener onTimeSelectListener, String title) {
        Calendar selectedDate = currentData != null ? currentData : Calendar.getInstance();//系统当前时间
        if (mFollowUpTimePicker == null) {
            Calendar startDate = Calendar.getInstance();
            mFollowUpTimePicker = getCommonBuilder(context, onTimeSelectListener)
                    .setRangDate(startDate,null)
                    .setDate(selectedDate)
                    .setType(new boolean[]{true, true, true, true, true, false})
                    .setLabel("年", "月", "日", "时", "分", "秒")
                    .setLayoutRes(R.layout.view_picker_follow_up_time, new CustomListener() {

                        @Override
                        public void customLayout(View v) {
                            v.findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            });
                            TextView btnCancel = v.findViewById(R.id.btnCancel);
                            btnCancel.setTextColor(Color.parseColor("#828282"));
                            btnCancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mFollowUpTimePicker.dismiss();
                                }
                            });
                            TextView btnOk = v.findViewById(R.id.btnSubmit);
                            btnOk.setTextColor(Color.parseColor("#019ee8"));
                            btnOk.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mFollowUpTimePicker.returnData();
                                    mFollowUpTimePicker.dismiss();
                                }
                            });
                            if (StringUtil.isNotNullAndSpace(title)) {
                                TextView tvTitle = v.findViewById(R.id.tvTitle);
                                tvTitle.setTextColor(Color.parseColor("#828282"));
                                tvTitle.setText(title);
                            }


                            RadioCheckLayout dateQuickSelect = (RadioCheckLayout) v.findViewById(R.id.radio_check_layuot_date_quick_select);
                            dateQuickSelect.setViewWidth(BaseApp.getInstance().mScreenWidth * 23 / 50);
                            dateQuickSelect.setSelectMode(RadioCheckLayout.MODE_SINGLE_CLICK);
                            dateQuickSelect.config(2, UIUtils.dip2Px(context, 5), UIUtils.dip2Px(context, 6)
                                    , UIUtils.dip2Px(context, 6), "#2b2b2b", "#019ee8", R.drawable.radio_check_layout_item_bg_n, R.drawable.radio_check_layout_item_bg_h_style2);
                            dateQuickSelect.setData(new String[]{"今天", "明天", "后天", "3天后", "7天后", "14天后", "30天后"}, -1);
                            dateQuickSelect.setOnItemSelectedListener(new RadioCheckLayout.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(View view, int index) {
                                    Calendar calendar = Calendar.getInstance();
                                    switch (index) {
                                        case 0:
                                            break;
                                        case 1:
                                            calendar.add(Calendar.DAY_OF_YEAR, 1);
                                            break;
                                        case 2:
                                            calendar.add(Calendar.DAY_OF_YEAR, 2);
                                            break;
                                        case 3:
                                            calendar.add(Calendar.DAY_OF_YEAR, 3);
                                            break;
                                        case 4:
                                            calendar.add(Calendar.DAY_OF_YEAR, 7);
                                            break;
                                        case 5:
                                            calendar.add(Calendar.DAY_OF_YEAR, 14);
                                            break;
                                        case 6:
                                            calendar.add(Calendar.MONTH, 1);
                                            break;
                                    }
                                    mFollowUpTimePicker.setDate(calendar);
                                }

                                @Override
                                public void onMutiItemSelected(int[] positions) {

                                }
                            });

                            WheelView wheelHour = (WheelView) v.findViewById(R.id.hour);
                            WheelView wheelMin = (WheelView) v.findViewById(R.id.min);
                            RadioCheckLayout timeQuickSelect = (RadioCheckLayout) v.findViewById(R.id.radio_check_layuot_time_quick_select);
                            timeQuickSelect.setViewWidth(BaseApp.getInstance().mScreenWidth * 12 / 50);
                            timeQuickSelect.setSelectMode(RadioCheckLayout.MODE_SINGLE_CLICK);
                            timeQuickSelect.config(1, UIUtils.dip2Px(context, 5), UIUtils.dip2Px(context, 6)
                                    , UIUtils.dip2Px(context, 6), "#2b2b2b", "#019ee8", R.drawable.radio_check_layout_item_bg_n, R.drawable.radio_check_layout_item_bg_h_style2);
                            timeQuickSelect.setData(new String[]{"11:00", "15:00", "17:00", "19:00"}, -1);
                            timeQuickSelect.setOnItemSelectedListener(new RadioCheckLayout.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(View view, int index) {
                                    switch (index) {
                                        case 0:
                                            wheelHour.setCurrentItem(11);
                                            wheelMin.setCurrentItem(0);
                                            break;
                                        case 1:
                                            wheelHour.setCurrentItem(15);
                                            wheelMin.setCurrentItem(0);
                                            break;
                                        case 2:
                                            wheelHour.setCurrentItem(17);
                                            wheelMin.setCurrentItem(0);
                                            break;
                                        case 3:
                                            wheelHour.setCurrentItem(19);
                                            wheelMin.setCurrentItem(0);
                                            break;
                                    }
                                }

                                @Override
                                public void onMutiItemSelected(int[] positions) {

                                }
                            });

                        }
                    })
                    .build();

        } else {
            mFollowUpTimePicker.setDate(selectedDate);
        }
        return mFollowUpTimePicker;

    }

    public TimePickerView getNormalDatePickView(Context context, Calendar currentData, OnTimeSelectListener onTimeSelectListener, String title) {
        Calendar selectedDate = currentData != null ? currentData : Calendar.getInstance();//系统当前时间
        TimePickerView timePickerView = getCommonBuilder(context, onTimeSelectListener)
                .setDate(selectedDate)
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .build();

        return timePickerView;

    }

    public TimePickerView getInventoryDatePickView(Context context, Calendar currentData, OnTimeSelectListener onTimeSelectListener, String title) {
        Calendar selectedDate = currentData;//系统当前时间
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DAY_OF_YEAR,-1);
        if(selectedDate == null){
            selectedDate = endDate;
        }
        TimePickerView timePickerView = getCommonBuilder(context, onTimeSelectListener)
                .setRangDate(null,endDate)
                .setDate(selectedDate)
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .build();

        return timePickerView;

    }


    public OptionsPickerView getNormalNoLinkOptionsPickView(Context context, OnOptionsSelectListener onOptionsSelectListener, String title
            , List<List<Integer>> datas, int[] selectIndex) {
        OptionsPickerView optionsPickerView = new OptionsPickerBuilder(context, onOptionsSelectListener)
                .build();
        optionsPickerView.setTitleText(title);
        optionsPickerView.setNPicker(datas.get(0), datas.get(1), datas.get(2));
        if (selectIndex != null) {
            optionsPickerView.setSelectOptions(selectIndex[0], selectIndex[1], selectIndex[2]);
        }

        return optionsPickerView;

    }

    private TimePickerBuilder getCommonBuilder(Context context, OnTimeSelectListener onTimeSelectListener) {
        return new TimePickerBuilder(context, onTimeSelectListener)
                .setCancelColor(Color.parseColor("#828282"))
                .setSubmitColor(Color.parseColor("#019ee8"))
                .setTitleColor(Color.parseColor("#828282"))
                .setTitleBgColor(Color.parseColor("#f4f4f4"));
    }

    public String getYMDShow(Date date) {//可根据需要自行截取数据显示
        if (date == null) {
            return TIME_NOT_SURE;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return format.format(date);
    }

    public String getYMDShowDate(Date date) {//可根据需要自行截取数据显示
        if (date == null) {
            return TIME_NOT_SURE;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public String getYMDHMShow(Date date) {//可根据需要自行截取数据显示
        if (date == null) {
            return TIME_NOT_SURE;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return format.format(date);
    }

    private void initCustomTimePicker() {


        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
       /* Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                btn_CustomTime.setText(getTime(date));
            }
        })*/
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentTextSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
        /*.animGravity(Gravity.RIGHT)// default is center*/

               /* .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                                pvCustomTime.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setContentTextSize(18)
                .setType(new boolean[]{false, false, false, true, true, true})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setLineSpacingMultiplier(1.2f)
                .setTextXOffset(0, 0, 0, 40, 0, -40)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(0xFF24AD9D)
                .build();*/

    }

    @Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag(BaseConsts.BusAction.ACTIVITY_DESTORYED)})
    public void onActivityDestoryed(String info) {
        if (mBookArriveShopDatePickView != null) {
            mBookArriveShopDatePickView.dismiss();
            mBookArriveShopDatePickView = null;
        }
        if (mExpectBuyDatePickView != null) {
            mExpectBuyDatePickView.dismiss();
            mExpectBuyDatePickView = null;
        }
        if (mFollowUpTimePicker != null) {
            mFollowUpTimePicker.dismiss();
            mFollowUpTimePicker = null;
        }
    }


    SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
    /**判断该时间是否小于当前时间*/
    public boolean isDatePickInvalid(String str){
        try{
            Date dateInput = simpleDateFormat.parse(str);
            Calendar calendarNow = Calendar.getInstance();
            calendarNow.set(Calendar.HOUR_OF_DAY,0);
            calendarNow.set(Calendar.MINUTE,0);
            calendarNow.set(Calendar.SECOND,0);
            calendarNow.set(Calendar.MILLISECOND,0);
            Date dataNow = calendarNow.getTime();
            return (dateInput.getTime() - dataNow.getTime()) < 0;
        } catch (Exception e){

        }
        return false;
    }


}

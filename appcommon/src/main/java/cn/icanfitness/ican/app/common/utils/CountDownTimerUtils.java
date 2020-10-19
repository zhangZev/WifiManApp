package cn.icanfitness.ican.app.common.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

import cn.icanfitness.ican.app.common.R;

/**
 * @time:{2020/8/21}
 * @auhor:{ZhangXW}
 */
public class CountDownTimerUtils extends CountDownTimer {
    private TextView mTextView;

    public CountDownTimerUtils(TextView textView, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setClickable(false); //设置不可点击
        mTextView.setText(millisUntilFinished / 1000 + "s");  //设置倒计时时间
        mTextView.setBackgroundResource(R.color.transparent);
    }

    @Override
    public void onFinish() {
        mTextView.setText("重新获取");
        mTextView.setClickable(true);//重新获得点击
        mTextView.setBackgroundResource(R.drawable.app_background_blue_corners_radios2_solid);  //还原背景色
    }
}

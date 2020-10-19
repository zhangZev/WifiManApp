package way.kichain.wifitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dlong.rep.dlroundmenuview.DLRoundMenuView;
import com.dlong.rep.dlroundmenuview.Interface.OnMenuClickListener;
import com.wanzhong.core.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import way.kichain.wifitest.adapter.WifiAdapter;
import way.kichain.wifitest.utils.RecyclerUtil;
import way.kichain.wifitest.utils.WifiUtils;

public class MainActivity extends BaseActivity {

    @BindView(R.id.dl_rmv)
    DLRoundMenuView dlRoundMenuView;
    @BindView(R.id.rg_all)
    RadioGroup mRgAll;@BindView(R.id.tv_titleselect)
    TextView tv_titleselect;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(){
        tv_titleselect.setText("手动");
        dlRoundMenuView.setOnMenuClickListener(new OnMenuClickListener() {
            @Override
            public void OnMenuClick(int position) {
                // 单击
                Log.i("lambda 单击", "点击了：$position"+position);
            }
        });
    }

    @OnClick({R.id.tv_titleselect})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_titleselect:
                if(mRgAll.getVisibility()==View.VISIBLE){
                    mRgAll.setVisibility(View.GONE);
                }else {
                    mRgAll.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}

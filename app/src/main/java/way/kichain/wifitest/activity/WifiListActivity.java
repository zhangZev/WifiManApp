package way.kichain.wifitest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.View;

import com.wanzhong.core.BaseActivity;

import java.util.List;

import butterknife.BindView;
import way.kichain.wifitest.R;
import way.kichain.wifitest.adapter.WifiAdapter;
import way.kichain.wifitest.utils.RecyclerUtil;
import way.kichain.wifitest.utils.WifiUtils;

public class WifiListActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wifi_list;
    }

    @Override
    protected void initView() {
        super.initView();
        setTitle("WIFI");
        mTitleLeftImg.setVisibility(View.GONE);
        List<ScanResult> resultList = WifiUtils.getInstance(this).getWifiList();
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(1000);
        defaultItemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(defaultItemAnimator);
        mRecyclerView.setLayoutManager(RecyclerUtil.initLayoutManager(this));
        WifiAdapter mAdapter = new WifiAdapter(this);

        mAdapter.init(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setItems(resultList);
    }
}

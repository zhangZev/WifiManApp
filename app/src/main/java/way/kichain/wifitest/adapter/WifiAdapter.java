package way.kichain.wifitest.adapter;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wanzhong.core.adapter.BasePageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import way.kichain.wifitest.R;


public class WifiAdapter extends BasePageAdapter<ScanResult> {

    private Context mContext;
    private selectListener mListener;

    public void setmListener(selectListener mListener) {
        this.mListener = mListener;
    }

    public WifiAdapter(Context context) {
        mContext = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_wifiname)
        TextView tv_wifiname;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    protected RecyclerView.ViewHolder initViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_wifi, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void doBindViewHolder(RecyclerView.ViewHolder viewHoder, int position) {
        if (viewHoder instanceof ViewHolder) {
            ScanResult mBean = getItems().get(position);
            ((ViewHolder) viewHoder).tv_wifiname.setText(mBean.SSID);
        }

    }

    public interface selectListener {
        void onSelectListener(String infos, int pos);
    }
}

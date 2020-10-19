package way.kichain.wifitest.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wanzhong.common.util.StringUtil;

public class RecyclerUtil {

    public static RecyclerView.LayoutManager initLayoutManager(Context mcontext) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                mcontext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        return layoutManager;
    }

    public static RecyclerView.LayoutManager initLayoutManagerHorizontal(Context mcontext) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                mcontext);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        return layoutManager;
    }

    public static Bitmap stringToBitmap(String string) {
        Bitmap bitmap = null;
        if(StringUtil.isNullOrSpace(string)){
            return bitmap;
        }
        try {
            byte[] bitmapArray = Base64.decode(string.contains(",") ? string.split(",")[1] : string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return bitmap;
    }


}

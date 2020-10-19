package cn.icanfitness.ican.app.common;

import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wanzhong.core.BaseApp;
import com.wanzhong.data.utils.ImgUploadUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.wanzhong.core.utils.BaseConsts.Intent.IMAGE_PICKER;


public class ImagePicker extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean crop = false;
        int count = 1;
        if(getIntent() != null){
            if(getIntent().hasExtra("crop")){
                crop = getIntent().getBooleanExtra("crop",false);
            }

            if(getIntent().hasExtra("count")){
                count = getIntent().getIntExtra("count",1);
            }
        }
        ImgUploadUtil.getInstance().pickImages(this,count,crop);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_PICKER) {
            ImgUploadUtil.getInstance().compressImgs(requestCode, resultCode, data)
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<List<String>>() {
                        @Override
                        public void accept(List<String> po) {
                            if (po != null && po.size() > 0) {
                                Intent intent = new Intent();
                                intent.putExtra("path",po.get(0));
                                setResult(RESULT_OK,intent);
                            }
                            finish();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) {
                            BaseApp.getInstance().toast("选择图片失败 " + throwable.getMessage());
                            finish();
                            throwable.printStackTrace();

                        }
                    });

        }
    }
}

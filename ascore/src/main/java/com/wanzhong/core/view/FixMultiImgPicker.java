package com.wanzhong.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wanzhong.common.util.StringUtil;
import com.wanzhong.core.BaseApp;
import com.wanzhong.core.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FixMultiImgPicker extends FrameLayout implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private int mColumn;
    private String[] mTitles ;
    private String[] mImgs ;
    private ImgAdapter mImgAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean mCanPreview ;

    public FixMultiImgPicker(@NonNull Context context) {
        super(context);
    }

    public FixMultiImgPicker(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FixMultiImgPicker(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FixMultiImgPicker(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public boolean canPreReview(){
        return mCanPreview;
    }
    public void initView(int column, String[] titles,boolean canPreview, OnFixImagePickListener onImagePickListener){
        mColumn = column;
        mTitles = titles;
        mCanPreview = canPreview;
        if(mTitles != null && mTitles.length > 0){
            mImgs = new String[titles.length];
        } else {
            mImgs = null;
        }

        mRecyclerView = new RecyclerView(getContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(mRecyclerView,params);
        mLayoutManager = new GridLayoutManager(getContext(), mColumn);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mImgAdapter = new ImgAdapter();
        mRecyclerView.setAdapter(mImgAdapter);
        setOnImagePickListener(onImagePickListener);

        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(300);
        defaultItemAnimator.setRemoveDuration(300);
        mRecyclerView.setItemAnimator(defaultItemAnimator);
    }


    public void setImage(String imgPath,int index){
        mImgs[index] = imgPath;
        mImgAdapter.notifyItemChanged(index);
    }

    private class ImgAdapter extends   RecyclerView.Adapter<ImgAdapter.ImgViewHolder>{

        public class ImgViewHolder extends RecyclerView.ViewHolder {
            ImageView img;
            ImageView btnDelete;
            TextView tvInfo;
            public ImgViewHolder(View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.img);
                img.setOnClickListener(FixMultiImgPicker.this);
                btnDelete = itemView.findViewById(R.id.btn_delete);
                btnDelete.setOnClickListener(FixMultiImgPicker.this);

                tvInfo = itemView.findViewById(R.id.tv_info);
                int rootLeftRightPaddding =  tvInfo.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_xlargge);
                int itemPadding = tvInfo.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_normal);
                int imgWidth = BaseApp.getInstance().mScreenWidth - rootLeftRightPaddding * 2 - itemPadding * mColumn;
                imgWidth = imgWidth / mColumn;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)img.getLayoutParams();
                params.width = imgWidth;
                params.height = imgWidth * 168 / 315;
                img.setLayoutParams(params);
            }
        }
        @NonNull
        @Override
        public ImgAdapter.ImgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fix_multi_img_picker, parent, false);
            return new ImgViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ImgAdapter.ImgViewHolder holder, int position) {
            if(mImgs != null && mImgs.length > 0 && position < mImgs.length && StringUtil.isNotNullAndSpace(mImgs[position])){
                //图片已经有了，可以删除
                holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                BaseApp.getInstance().setImg(getContext(),holder.img,mImgs[position],R.drawable.img_default_car);
                if(mCanPreview){
                    holder.btnDelete.setVisibility(View.VISIBLE);
                } else {
                    holder.btnDelete.setVisibility(View.INVISIBLE);
                }
            } else {
                holder.img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                holder.img.setImageResource(R.drawable.icon_img_add);
                holder.btnDelete.setVisibility(View.INVISIBLE);
            }
            holder.tvInfo.setText(mTitles[position]);
            holder.img.setTag(R.id.activity_root,position);
            holder.btnDelete.setTag(R.id.activity_root,position);
        }

        @Override
        public int getItemCount() {
            return mTitles == null ? 0 :mTitles.length ;
        }
    }

    @Override
    public void onClick(View v) {
        final int position = (int) v.getTag(R.id.activity_root);
        if (v.getId() == R.id.img){
            if(mOnImagePickListener != null){
                if(mImgs != null && mImgs.length > 0 && position < mImgs.length && StringUtil.isNotNullAndSpace(mImgs[position])) {
                    //图片已经有了，可以删除
                    mOnImagePickListener.onFixImageItemClicked(v,position,mImgs[position],mImgs);
                } else {
                    mOnImagePickListener.onFixImageAddClicked(v,position);
                }

            }
        } else if(v.getId() == R.id.btn_delete){
            mImgs[position] = null;
            mImgAdapter.notifyItemChanged(position);
        }
    }


    private OnFixImagePickListener mOnImagePickListener;
    public void setOnImagePickListener(OnFixImagePickListener onImagePickListener){
        mOnImagePickListener = onImagePickListener;
    }
    public interface OnFixImagePickListener {
        public void onFixImageItemClicked(View view, int postion, String path, String[] imgs);
        public void onFixImageAddClicked(View view,int position);
    }

    public String getFirstEmptyImgTitle(){
        for(int i = 0 ;i <mImgs.length ;i++){
            if(StringUtil.isNullOrSpace(mImgs[i])){
                return mTitles[i];
            }
        }
        return null;
    }
    public String[] getImgs(){
        return mImgs;
    }
}

package com.wanzhong.core.view;

import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wanzhong.core.BaseApp;
import com.wanzhong.core.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MultiImgPicker extends FrameLayout implements View.OnClickListener,View.OnLongClickListener {

    private RecyclerView mRecyclerView;
    private int mColumn;
    private int mMaxImgs;
    private List<String> mImgs = new ArrayList<>();
    private ImgAdapter mImgAdapter;
    private ItemTouchHelper mItemTouchHelper;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean mEditable;
    public void setEditable(boolean editable){
        mEditable = editable;

    }

    public MultiImgPicker(@NonNull Context context) {
        super(context);
    }

    public MultiImgPicker(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiImgPicker(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MultiImgPicker(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initView(int column,int maxImgs,OnImagePickListener onImagePickListener){
        mColumn = column;
        mMaxImgs = maxImgs;
        mRecyclerView = new RecyclerView(getContext());
        addView(mRecyclerView);
        mLayoutManager = new GridLayoutManager(getContext(), mColumn);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mImgAdapter = new ImgAdapter();
        mRecyclerView.setAdapter(mImgAdapter);
        setOnImagePickListener(onImagePickListener);

        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(300);
        defaultItemAnimator.setRemoveDuration(300);
        mRecyclerView.setItemAnimator(defaultItemAnimator);
        initTouchHelper();
    }

    private void initTouchHelper(){
        mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

            /**
             * 是否处理滑动事件 以及拖拽和滑动的方向 如果是列表类型的RecyclerView的只存在UP和DOWN，如果是网格类RecyclerView则还应该多有LEFT和RIGHT
             * @param recyclerView
             * @param viewHolder
             * @return
             */
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    final int swipeFlags = 0;
                    return makeMovementFlags(dragFlags, swipeFlags);
                } else {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                    final int swipeFlags = 0;
//                    final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                    return makeMovementFlags(dragFlags, swipeFlags);
                }
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //得到当拖拽的viewHolder的Position
                int fromPosition = viewHolder.getAdapterPosition();
                //拿到当前拖拽到的item的viewHolder
                int toPosition = target.getAdapterPosition();
                if(mMaxImgs != mImgs.size() && toPosition == mImgs.size()){
                    return false;
                }
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(mImgs, i, i + 1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(mImgs, i, i - 1);
                    }
                }
                mImgAdapter.notifyItemMoved(fromPosition, toPosition);
                mImgAdapter.notifyItemChanged(fromPosition);
                mImgAdapter.notifyItemChanged(toPosition);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                int position = viewHolder.getAdapterPosition();
//                myAdapter.notifyItemRemoved(position);
//                datas.remove(position);
            }

            /**
             * 重写拖拽可用
             * @return
             */
            @Override
            public boolean isLongPressDragEnabled() {
                return false;
            }

            /**
             * 长按选中Item的时候开始调用
             *
             * @param viewHolder
             * @param actionState
             */
            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                }
                super.onSelectedChanged(viewHolder, actionState);
            }

            /**
             * 手指松开的时候还原
             * @param recyclerView
             * @param viewHolder
             */
            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(0);
            }
        });

        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    public void addImgs(List<String> imgs){
        int oldStartPostion = mImgs == null ? 0 : mImgs.size();
        if(mImgs == null){
            mImgs = imgs;
        } else {
            final List<String> imgsToAdd = new ArrayList<>();
            for(String img : imgs){
                boolean existed = false;
                for(String existImg : mImgs){
                    if(existImg.equals(img)){
                        existed = true;
                        break;
                    }
                }
                if(!existed && mImgs.size() + imgsToAdd.size() < mMaxImgs){
                    imgsToAdd.add(img);
                }
            }
            mImgs.addAll(imgsToAdd);
        }
        mImgAdapter.notifyDataSetChanged();


    }
    public void setImgs(List<String> imgs){
        mImgs = imgs;
        mImgAdapter.notifyDataSetChanged();
    }
    public void clearImgs(){
        mImgs.clear();
        mImgAdapter.notifyDataSetChanged();
    }

    private class ImgAdapter extends   RecyclerView.Adapter<ImgAdapter.ImgViewHolder>{

        public class ImgViewHolder extends RecyclerView.ViewHolder {
            ImageView img;
            ImageView btnDelete;
            public ImgViewHolder(View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.img);
                img.setOnClickListener(MultiImgPicker.this);
                img.setOnLongClickListener(MultiImgPicker.this);
                btnDelete = itemView.findViewById(R.id.btn_delete);
                btnDelete.setOnClickListener(MultiImgPicker.this);
                int rootLeftRightPaddding =  getContext().getResources().getDimensionPixelOffset(R.dimen.margin_xlargge);
                int itemPadding = getContext().getResources().getDimensionPixelOffset(R.dimen.margin_normal);
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
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_multi_img_picker, parent, false);
            /*view.getLayoutParams().width = BaseApp.getInstance().mScreenWidth / mColumn ;
            view.getLayoutParams().height = view.getLayoutParams().width;*/
            return new ImgViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ImgAdapter.ImgViewHolder holder, int position) {
            if(mMaxImgs != mImgs.size() && position == mImgs.size()){
                holder.img.setEnabled(mEditable);
                if(mEditable){
                    holder.img.setVisibility(View.VISIBLE);
                } else {
                    holder.img.setVisibility(View.INVISIBLE);
                }
                holder.img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                holder.img.setImageResource(R.drawable.icon_img_add);
                holder.btnDelete.setVisibility(View.INVISIBLE);
            } else {
                holder.img.setEnabled(true);
                holder.img.setVisibility(View.VISIBLE);
                if(mEditable){
                    holder.btnDelete.setVisibility(View.VISIBLE);
                } else {
                    holder.btnDelete.setVisibility(View.GONE);
                }
                holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                BaseApp.getInstance().setImg(getContext(),holder.img,mImgs.get(position),R.drawable.img_default_car);
            }
            holder.img.setTag(R.id.activity_root,position);
            holder.btnDelete.setTag(R.id.activity_root,position);
        }

        @Override
        public int getItemCount() {
            return mImgs == null ? 1 : (mMaxImgs == mImgs.size() ? mImgs.size() : mImgs.size() + 1)  ;
        }
    }

    @Override
    public void onClick(View v) {
        final int position = (int) v.getTag(R.id.activity_root);
        if (v.getId() == R.id.img){
            if(mOnImagePickListener != null){
                if(mMaxImgs != mImgs.size() && position == mImgs.size()){
                    mOnImagePickListener.onImageAddClicked(v);
                } else  {
                    mOnImagePickListener.onImageItemClicked(v,position,mImgs.get(position),mImgs);
                }
            }
        } else if(v.getId() == R.id.btn_delete){
            mImgs.remove(position);
            mImgAdapter.notifyItemRemoved(position);
            mImgAdapter.notifyItemRangeChanged(position,mImgAdapter.getItemCount());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(!mEditable){
            return false;
        }
        final int position = (int) v.getTag(R.id.activity_root);
        if(mMaxImgs != mImgs.size() && position == mImgs.size()){
        } else {
            if(mItemTouchHelper != null){
                mItemTouchHelper.startDrag(mRecyclerView.getChildViewHolder(mLayoutManager.getChildAt(position)));
                Vibrator vib = (Vibrator) getContext().getSystemService(Service.VIBRATOR_SERVICE);//震动70毫秒
                vib.vibrate(70);
            }

        }
        return true;
    }

    private OnImagePickListener mOnImagePickListener;
    public void setOnImagePickListener(OnImagePickListener onImagePickListener){
        mOnImagePickListener = onImagePickListener;
    }
    public interface OnImagePickListener {
        public void onImageItemClicked(View view,int postion,String path,List<String> imgs);
        public void onImageAddClicked(View view);
    }

    public int getMaxImgCount(){
        return mMaxImgs;
    }
    public int getCurrentImageCount(){
        return mImgs == null ? 0 : mImgs.size();
    }
    public int getCanAddImgCount(){
        return  getMaxImgCount() - getCurrentImageCount();
    }
    public List<String> getImgs(){
        return mImgs;
    }

}

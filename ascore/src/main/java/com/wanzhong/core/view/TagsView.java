package com.wanzhong.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.library.flowlayout.FlowLayoutManager;
import com.wanzhong.core.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class TagsView extends RecyclerView implements View.OnClickListener {

    public static final int REMOVE_MODE_NONE = 1;
    public static final int REMOVE_MODE_SELECTED = 2;
    public static final int REMOVE_MODE_ALL_CAN = 3;
    private int mRemoveMode = REMOVE_MODE_NONE;
    private List<String> mData = new ArrayList<String>();
    private FlowAdapter mFlowAdapter = new FlowAdapter();
    private boolean mSelectable = true;
    private boolean mIsBgWhite = false;
    private int mSelectIndex = 0;
    public TagsView(@NonNull Context context) {
        super(context);
        init();
    }

    public TagsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TagsView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();

    }

    public void setRemoveMode(int mode){
        mRemoveMode = mode;
    }
    public void setSelectable(boolean selectable){
        mSelectable = selectable;
    }
    public void setIsBgWhite(boolean isWhite){
        mIsBgWhite = isWhite;
    }
    private void init(){
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        this.setLayoutManager(flowLayoutManager);
        setAdapter(mFlowAdapter);
    }
    public void setTags(List<String> data){
        mData.clear();
        mData.addAll(data);
        mSelectIndex = 0;
        onDataChanged();
        if(mTagViewsChangeListener != null){
            mTagViewsChangeListener.onSelectChanged(mSelectIndex);
        }
    }
    public void setTags(List<String> data,boolean callListener){
        mData.clear();
        mData.addAll(data);
        mSelectIndex = 0;
        onDataChanged();
        if(mTagViewsChangeListener != null && callListener){
            mTagViewsChangeListener.onSelectChanged(mSelectIndex);
        }
    }
    public List<String> getData(){
        return mData;
    }
    public String getCurrentText(){
        if(mSelectIndex >= 0 && mSelectIndex < mData.size()){
            return mData.get(mSelectIndex);
        }
        return null;
    }
    public void addTag(String tag,boolean select){
        int tagIndexInList = -1;
        for(int index = 0 ; index <  mData.size() ; index++){
            if(mData.get(index).equals(tag)){
                tagIndexInList = index;
                break;
            }
        }
        if(tagIndexInList == -1){
            mData.add(tag);
            if(select){
                mSelectIndex = mData.size() - 1;
            }
            onDataChanged();
        } else {
            if(select){
                mSelectIndex = tagIndexInList;
                onDataChanged();
            }
        }
        if(mTagViewsChangeListener != null){
            mTagViewsChangeListener.onSelectChanged(mSelectIndex);
        }
    }
    private void onDataChanged(){
        if(mData.size() > 0){
            setVisibility(View.VISIBLE);
        } else {
            setVisibility(View.GONE);
        }
        mFlowAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        int index = (Integer) v.getTag();
        if(v.getId() ==  R.id.root){
            //if(mSelectIndex != index) {
                mSelectIndex = index;
                if(mTagViewsChangeListener != null){
                    mTagViewsChangeListener.onSelectChanged(index);
                }
           // }
        } else if(v.getId() == R.id.img_remove){
            if(index == mData.size() - 1 && index > 0){
                mSelectIndex = index - 1;
            }
            mData.remove(index);
            if(mTagViewsChangeListener != null){
                mTagViewsChangeListener.onTagRemoved(index);
            }
        }
        onDataChanged();

    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(View.inflate(getContext(), R.layout.item_tags_view, null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            TextView textView = ((MyHolder) holder).text;
            textView.setText(mData.get(position));
            textView.setTag(position);
            ((MyHolder) holder).remove.setTag(position);
            ((MyHolder) holder).root.setTag(position);
            if(position == mSelectIndex){
                if(mSelectable){
                    textView.setTextColor(getResources().getColorStateList(R.color.color_app_main));
                    textView.setBackgroundResource(R.drawable.tags_view_item_bg_h);
                } else {
                    textView.setTextColor(getResources().getColorStateList(R.color.text_color_dark));
                    if(mIsBgWhite){
                        textView.setBackgroundResource(R.drawable.tags_view_item_bg_white_n);
                    } else {
                        textView.setBackgroundResource(R.drawable.tags_view_item_bg_n);
                    }

                }

            } else {
                textView.setTextColor(getResources().getColorStateList(R.color.text_color_dark));
                if(mIsBgWhite){
                    textView.setBackgroundResource(R.drawable.tags_view_item_bg_white_n);
                } else {
                    textView.setBackgroundResource(R.drawable.tags_view_item_bg_n);
                }
            }
            switch (mRemoveMode){
                case REMOVE_MODE_NONE:
                    ((MyHolder) holder).remove.setVisibility(View.GONE);
                    break;
                case REMOVE_MODE_SELECTED:
                    if(position == mSelectIndex){
                        ((MyHolder) holder).remove.setVisibility(View.VISIBLE);
                    } else {
                        ((MyHolder) holder).remove.setVisibility(View.GONE);
                    }
                    break;
                case REMOVE_MODE_ALL_CAN:
                    ((MyHolder) holder).remove.setVisibility(View.VISIBLE);
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {

            private View root;
            private TextView text;
            private ImageView remove;
            public MyHolder(View itemView) {
                super(itemView);
                root = itemView.findViewById(R.id.root);
                text = (TextView) itemView.findViewById(R.id.tv_info);
                remove = (ImageView) itemView.findViewById(R.id.img_remove);
                root.setOnClickListener(TagsView.this);
                remove.setOnClickListener(TagsView.this);
            }
        }
    }

    public interface TagViewsChangeListener {
        public void onSelectChanged(int position);
        public void onTagRemoved(int position);
    }
    private TagViewsChangeListener mTagViewsChangeListener;
    public void setTagViewsChangeListener(TagViewsChangeListener listener){
        mTagViewsChangeListener = listener;
    }
}

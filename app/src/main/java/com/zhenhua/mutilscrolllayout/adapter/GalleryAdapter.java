package com.zhenhua.mutilscrolllayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zhenhua.mutilscrolllayout.R;
import com.zhenhua.mutilscrolllayout.bean.ModuleItem;
import com.zhenhua.mutilscrolllayout.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack{
        void onItemClick(int pos);
    }

    public ArrayList<ModuleItem> moduleItemList = null;
    private ItemClickCallBack clickCallBack;
    private Context context;

    public GalleryAdapter(ArrayList<ModuleItem> moduleItemList) {
        this.moduleItemList = moduleItemList;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gallery_item,viewGroup,false);
        return new ViewHolder(view);
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {
        viewHolder.iv_module.setImageResource(moduleItemList.get(position).getModuleImage());
        viewHolder.tv_module.setText(moduleItemList.get(position).getModuleName());

        viewHolder.iv_module.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(clickCallBack != null){
                            clickCallBack.onItemClick(position);
                        }
                    }
                }
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return moduleItemList.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_module;
        public TextView tv_module;
        public ViewHolder(View view){
            super(view);
            iv_module = (ImageView) view.findViewById(R.id.iv_module);
            tv_module = (TextView) view.findViewById(R.id.tv_module);
        }
    }
}






















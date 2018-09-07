package com.example.administrator.xy;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Map<String, Object>> mData;

    public MyAdapter(List<Map<String, Object>> data) {
            this.mData = data;
    }

    public void updateData(List<Map<String, Object>> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        switch (viewType) {
            case 0:
                return new ViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_item,parent,false));
            case 1:
                return new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.normal_item,parent,false));
        }

        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // 绑定数据
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                ((ViewHolder1)holder).title.setText(mData.get(position).get("szTitle").toString());
                break;
            case 1:
                ((ViewHolder2)holder).title.setText(mData.get(position).get("szTitle").toString());
                ((ViewHolder2)holder).name.setText(mData.get(position).get("szNickName").toString());
                ((ViewHolder2)holder).comment.setText(mData.get(position).get("iCommentCnt").toString());
                ((ViewHolder2)holder).time.setText(mData.get(position).get("dtTime").toString());
                ((ViewHolder2)holder).read.setText("阅读："+ mData.get(position).get("iReadCnt").toString());
                ((ViewHolder2)holder).content.setText(mData.get(position).get("szSummary").toString());
                ((ViewHolder2)holder).header.setImageURI(mData.get(position).get("szHeaderUrl").toString());
                if(mData.get(position).containsKey("pic1"))((ViewHolder2)holder).pic1.setImageURI(mData.get(position).get("pic1").toString());
                if(mData.get(position).containsKey("pic2"))((ViewHolder2)holder).pic2.setImageURI(mData.get(position).get("pic2").toString());
                if(mData.get(position).containsKey("pic3"))((ViewHolder2)holder).pic3.setImageURI(mData.get(position).get("pic3").toString());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(mData.get(position).get("type").toString());
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder1(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_hot_item);
        }
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView title;
        TextView name;
        TextView comment;
        TextView time;
        TextView read;
        TextView content;
        SimpleDraweeView header;
        SimpleDraweeView pic1;
        SimpleDraweeView pic2;
        SimpleDraweeView pic3;


        public ViewHolder2(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_normal_item_title);
            name = (TextView) itemView.findViewById(R.id.tv_normal_item_name);
            comment = (TextView) itemView.findViewById(R.id.tv_normal_item_comment);
            time = (TextView) itemView.findViewById(R.id.tv_normal_item_time);
            read = (TextView) itemView.findViewById(R.id.tv_normal_item_read);
            content = (TextView) itemView.findViewById(R.id.tv_normal_item_content);
            header = (SimpleDraweeView) itemView.findViewById(R.id.sdv_normal_item_header);
            pic1 = (SimpleDraweeView) itemView.findViewById(R.id.sdv_normal_item_pic1);
            pic2 = (SimpleDraweeView) itemView.findViewById(R.id.sdv_normal_item_pic2);
            pic3 = (SimpleDraweeView) itemView.findViewById(R.id.sdv_normal_item_pic3);
        }
    }
}

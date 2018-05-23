package com.example.week2demo.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.week2demo.R;
import com.example.week2demo.bean.VideoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<VideoBean.DataBean> data;
    private LayoutInflater inflater;

    public VideoAdapter(Context context, List<VideoBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.vedio_item, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
        VideoBean.DataBean dataBean = data.get(position);
        videoViewHolder.imgtou.setImageURI(dataBean.getProfile_image());
        videoViewHolder.text1.setText(dataBean.getText());
        videoViewHolder.text2.setText(dataBean.getName());
        videoViewHolder.videoView.setVideoPath(dataBean.getVideouri());
        videoViewHolder.videoView.start();

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView imgtou;
        private final TextView text2;
        private final TextView text1;
        private final VideoView videoView;

        public VideoViewHolder(View itemView) {
            super(itemView);
            imgtou = itemView.findViewById(R.id.imgtou);
            text2 = itemView.findViewById(R.id.text2);
            text1 = itemView.findViewById(R.id.text1);
            videoView = itemView.findViewById(R.id.surface_view);
        }
    }

    public void setData(List<VideoBean.DataBean> list) {
        if (data != null) {
            data.clear();
            data.addAll(list);
            notifyDataSetChanged();
        }
    }
}

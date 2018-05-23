package com.example.week2demo.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week2demo.R;
import com.example.week2demo.bean.ImgBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class ImgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ImgBean.DataBean> data;
    private LayoutInflater inflater;

    public ImgAdapter(Context context, List<ImgBean.DataBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.img_item, parent, false);
        return new ImgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImgViewHolder imgViewHolder = (ImgViewHolder) holder;
        ImgBean.DataBean dataBean = data.get(position);
        imgViewHolder.imgtou1.setImageURI(dataBean.getProfile_image());
        imgViewHolder.text4.setText(dataBean.getName());
        imgViewHolder.text3.setText(dataBean.getText());
        if (dataBean.isIs_gif()) {
            PipelineDraweeController controller =
                    (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                            .setUri(dataBean.getImage0())
                            .setAutoPlayAnimations(true) //自动播放gif动画
                            .build();
            imgViewHolder.img.setController(controller);
        } else {
            imgViewHolder.img.setImageURI(dataBean.getImage0());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ImgViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView imgtou1;
        private final TextView text4;
        private final TextView text3;
        private final SimpleDraweeView img;

        public ImgViewHolder(View itemView) {
            super(itemView);
            imgtou1 = itemView.findViewById(R.id.imgtou1);
            text4 = itemView.findViewById(R.id.text4);
            text3 = itemView.findViewById(R.id.text3);
            img = itemView.findViewById(R.id.img);
        }
    }

    public void setData(List<ImgBean.DataBean> list){
        if (data!=null){
            data.clear();
            data.addAll(list);
            notifyDataSetChanged();
        }
    }
}

package com.example.week2demo.ui.contract;

import com.example.week2demo.bean.ImgBean;
import com.example.week2demo.bean.VideoBean;
import com.example.week2demo.ui.base.BaseContract;

import java.util.List;

public interface WeekContract {
    interface View extends BaseContract.BaseView {
        void imgSuccess(List<ImgBean.DataBean> data);

        void videoSuccess(List<VideoBean.DataBean> data);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getImage();
        void getVideo();
    }
}

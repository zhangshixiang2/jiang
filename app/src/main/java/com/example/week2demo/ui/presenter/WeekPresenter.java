package com.example.week2demo.ui.presenter;

import com.example.week2demo.bean.ImgBean;
import com.example.week2demo.bean.VideoBean;
import com.example.week2demo.net.WeekApi;
import com.example.week2demo.ui.base.BasePresenter;
import com.example.week2demo.ui.contract.WeekContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class WeekPresenter extends BasePresenter<WeekContract.View> implements WeekContract.Presenter {
    private WeekApi weekApi;

    @Inject
    public WeekPresenter(WeekApi weekApi) {
        this.weekApi = weekApi;
    }

    @Override
    public void getImage() {
        weekApi.getImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ImgBean, List<ImgBean.DataBean>>() {

                    @Override
                    public List<ImgBean.DataBean> apply(ImgBean imgBean) throws Exception {
                        return imgBean.getData();
                    }
                }).subscribe(new Consumer<List<ImgBean.DataBean>>() {
            @Override
            public void accept(List<ImgBean.DataBean> dataBeans) throws Exception {
                if (mView != null) {
                    mView.imgSuccess(dataBeans);
                }
            }
        });
    }

    @Override
    public void getVideo() {
        weekApi.getVideo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<VideoBean, List<VideoBean.DataBean>>() {
                    @Override
                    public List<VideoBean.DataBean> apply(VideoBean videoBean) throws Exception {
                        return videoBean.getData();
                    }
                }).subscribe(new Consumer<List<VideoBean.DataBean>>() {
            @Override
            public void accept(List<VideoBean.DataBean> dataBeans) throws Exception {
                if (mView != null) {
                    mView.videoSuccess(dataBeans);
                }
            }
        });
    }
}

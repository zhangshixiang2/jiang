package com.example.week2demo.net;

import com.example.week2demo.bean.ImgBean;
import com.example.week2demo.bean.VideoBean;

import io.reactivex.Observable;


public class WeekApi {
    private static WeekApi weekApi;
    private WeekApiService weekApiService;

    public WeekApi(WeekApiService weekApiService) {
        this.weekApiService = weekApiService;
    }

    public static WeekApi getWeekApi(WeekApiService weekApiService) {
        if (weekApi == null) {
            weekApi = new WeekApi(weekApiService);
        }
        return weekApi;
    }

    public Observable<ImgBean> getImage() {
        return weekApiService.getImage();
    }

    public Observable<VideoBean> getVideo() {
        return weekApiService.getVideo();
    }
}

package com.example.week2demo.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.week2demo.ui.fragment.ImgFragmet;
import com.example.week2demo.ui.fragment.VideoFragment;

public class TabPageIndicatorAdapter extends FragmentPagerAdapter {
    /**
     * Tab标题
     */
    private static final String[] TITLE = new String[]{"图片", "视频", "另一面", "女人",
            "财经", "数码", "情感", "科技"};

    public TabPageIndicatorAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position % 2 == 0) {
            fragment = new ImgFragmet();
        } else {
            fragment = new VideoFragment();
        }


        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position % TITLE.length];
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }
}

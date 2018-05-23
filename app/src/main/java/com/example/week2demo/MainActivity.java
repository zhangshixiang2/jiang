package com.example.week2demo;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.week2demo.ui.adapter.TabPageIndicatorAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends AppCompatActivity {

    private TabPageIndicator mTabPageIndicator;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
        mVp.setAdapter(adapter);
        mTabPageIndicator.setViewPager(mVp);

    }

    private void initView() {
        mTabPageIndicator = (TabPageIndicator) findViewById(R.id.titles);
        mVp = (ViewPager) findViewById(R.id.vp);
    }


}

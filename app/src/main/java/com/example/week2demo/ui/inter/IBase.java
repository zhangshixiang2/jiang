package com.example.week2demo.ui.inter;

import android.view.View;

public interface IBase {
    int getContentLayout();

    void inject();

    void initView(View view);
}

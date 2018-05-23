package com.example.week2demo.component;

import com.example.week2demo.module.HttpModule;
import com.example.week2demo.ui.fragment.ImgFragmet;
import com.example.week2demo.ui.fragment.VideoFragment;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(ImgFragmet imgFragmet);

    void inject(VideoFragment videoFragment);
}

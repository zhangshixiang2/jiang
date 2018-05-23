package com.example.week2demo.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.week2demo.ui.inter.IBase;

import javax.inject.Inject;

public abstract class BaseFragment<T extends BaseContract.BasePresenter> extends Fragment implements IBase,
        BaseContract.BaseView {

    @Inject
    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        inject();
        View view = inflater.inflate(getContentLayout(), null);
        initView(view);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showLoading() {

    }
}

package com.flyou.lovefood.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.google.gson.Gson;

import org.simple.eventbus.EventBus;

import java.lang.reflect.Type;

/**
 * Created by flyou on 2016/3/1.
 */
public  abstract  class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());//把设置布局文件的操作交给继承的子类
        ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View parentView = contentFrameLayout.getChildAt(0);
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.setFitsSystemWindows(true);
        }
        initView();
        initDate();
        setListener();

    }


  //传入当前布局文件的id 如R.layout.main
    protected abstract int getLayoutResId();
    //初始化view
    protected abstract void initView();

    //初始化date
    protected abstract void initDate();

    //设置adapter
    protected abstract void setListener();


    @Override
    protected void onDestroy() {

        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onResume() {
        EventBus.getDefault().register(this);


        super.onResume();
    }

    /*
 * 对象转 json
 * obj 对象
 * */
    public String toJson(Object obj) {

        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /*
  * json转对象
  * classOfT 对象类型
  * */
    public <T> T toObj(String json, Type typeOfT) {
        Gson gson = new Gson();
        T t = gson.fromJson(json, typeOfT);
        return t;
    }
    }


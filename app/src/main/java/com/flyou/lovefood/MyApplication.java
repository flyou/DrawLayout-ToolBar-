package com.flyou.lovefood;

import android.app.Application;

import com.baidu.apistore.sdk.ApiStoreSDK;

/**
 * Created by flyou on 2016/3/2.
 */
public class MyApplication  extends Application{
    @Override
    public void onCreate() {
        ApiStoreSDK.init(this, "ce478d98b8883be24bad40c9eaa34379");
        super.onCreate();

    }
}

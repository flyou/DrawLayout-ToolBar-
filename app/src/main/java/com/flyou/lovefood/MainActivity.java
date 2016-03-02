package com.flyou.lovefood;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.flyou.lovefood.base.BaseActivity;


public class MainActivity extends BaseActivity {
    Toolbar mToolbar;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("爱美食");
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_share:
                        Parameters para = new Parameters();


                        ApiStoreSDK.execute("http://apis.baidu.com/acman/zhaiyanapi/tcrand",
                                ApiStoreSDK.GET,
                                para,
                                new ApiCallBack() {
                                    @Override
                                    public void onSuccess(int status, String responseString) {
                                        Log.i("sdkdemo", "onSuccess");
                                        Log.i("sdkdemo",responseString);
                                    }

                                    @Override
                                    public void onComplete() {
                                        Log.i("sdkdemo", "onComplete");
                                    }

                                    @Override
                                    public void onError(int status, String responseString, Exception e) {
                                        Log.i("sdkdemo", "onError, status: " + status);
                                        Log.i("sdkdemo", "errMsg: " + (e == null ? "" : e.getMessage()));

                                    }

                                });
                        break;
                    case R.id.action_search:

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



}

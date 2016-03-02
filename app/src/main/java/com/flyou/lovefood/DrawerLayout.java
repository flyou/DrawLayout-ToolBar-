package com.flyou.lovefood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flyou.lovefood.base.BaseActivity;

import java.io.PipedReader;

public class DrawerLayout extends BaseActivity {
    private View mDrawer;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_drawer_layout;

    }

    @Override
    protected void initView() {
        mDrawer = findViewById(R.id.drawer);
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void setListener() {

    }
}

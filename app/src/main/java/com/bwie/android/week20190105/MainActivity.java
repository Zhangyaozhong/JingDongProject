package com.bwie.android.week20190105;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.bwie.android.week20190105.fragment.ClsFragmennt;
import com.bwie.android.week20190105.fragment.HomeFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fl)
    FrameLayout frameLayout;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        // 设置点击监听
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                Object ob = null;
                switch (tabId) {
                    case R.id.tab_home:
                        ob = new HomeFragment();
                        break;
                    case R.id.tab_cls:
                        ob = new ClsFragmennt();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, (Fragment) ob).commit();
            }
        });

    }
}

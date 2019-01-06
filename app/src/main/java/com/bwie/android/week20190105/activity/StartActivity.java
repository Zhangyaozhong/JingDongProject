package com.bwie.android.week20190105.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.bwie.android.week20190105.MainActivity;
import com.bwie.android.week20190105.R;

public class StartActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        imageView = findViewById(R.id.mImg);
        initData();
    }

    private void initData() {
        //隐藏标题栏
        getSupportActionBar().hide();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        屏幕高度
        int heightPixels = displayMetrics.heightPixels;

        //缩放
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(imageView, "scaleX", 2.0f, 1.0f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(imageView, "scaleY", 2.0f, 1.0f);
        //渐变
        ObjectAnimator alphatAnimator = ObjectAnimator.ofFloat(imageView, "alpha", 0, 1);
        //旋转
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360);
        //移动
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(imageView, "translationY", 0, heightPixels / 2 - imageView.getHeight() / 2);
//        组合动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimator).with(scaleYAnimator).with(alphatAnimator).with(rotateAnimator).with(translationYAnimator);
        animatorSet.setDuration(3000);
        animatorSet.start();

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}

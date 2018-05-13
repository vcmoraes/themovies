package br.com.victormoraes.themovie.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import org.androidannotations.annotations.EActivity;

@EActivity
public class SplashActivity extends BaseActivity implements Runnable {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(this, 2000);
    }

    @Override
    public void run() {
        MainMovieActivity_.intent(this).start();
        finish();
    }
}

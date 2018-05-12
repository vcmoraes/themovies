package br.com.victormoraes.themovie;

import android.app.Application;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import br.com.victormoraes.core.api.InitCore;

@EApplication
public class AppApplication extends Application {

    @Bean
    InitCore initCore;

    @Override
    public void onCreate() {
        super.onCreate();
        initCore.init();
    }
}

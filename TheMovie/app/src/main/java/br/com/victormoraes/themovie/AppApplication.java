package br.com.victormoraes.themovie;

import android.app.Application;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import br.com.victormoraes.core.api.InitCore;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@EApplication
public class AppApplication extends Application {

    @Bean
    InitCore initCore;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(getPackageName() + ".realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        initCore.init();
    }
}

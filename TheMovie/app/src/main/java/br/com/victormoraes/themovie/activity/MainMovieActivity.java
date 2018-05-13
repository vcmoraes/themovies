package br.com.victormoraes.themovie.activity;

import android.content.DialogInterface;
import android.support.annotation.NonNull;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

import br.com.victormoraes.themovie.R;
import br.com.victormoraes.themovie.contract.MainMovieContract;
import br.com.victormoraes.themovie.model.Genre;
import br.com.victormoraes.themovie.presenter.MainMoviePresenter;

@EActivity(R.layout.activity_main_movie)
public class MainMovieActivity extends BaseSubscribeActivity implements MainMovieContract.MainMovieView {

    @Bean
    MainMoviePresenter mainMoviePresenter;

    @AfterViews
    public void init() {
        mainMoviePresenter.setView(this);
        getGenres();
    }

    private void getGenres() {
        showLoading(getString(R.string.search));
        mainMoviePresenter.getGenresMovie();
    }

    @Override
    public void onSucessGenres(@NonNull ArrayList<Genre> list) {
        hiddenLoading();
    }

    @Override
    public void onErrorGenres() {
        hiddenLoading();
        showDialogMessage(getResources().getString(R.string.error_dialog_retry), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getGenres();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainMovieActivity.this.finish();
            }
        });
    }
}

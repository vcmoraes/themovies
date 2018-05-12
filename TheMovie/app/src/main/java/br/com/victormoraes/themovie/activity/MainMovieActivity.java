package br.com.victormoraes.themovie.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

import br.com.victormoraes.themovie.R;
import br.com.victormoraes.themovie.contract.MainMovieContract;
import br.com.victormoraes.themovie.presenter.MainMoviePresenter;

@EActivity(R.layout.activity_main_movie)
public class MainMovieActivity extends BaseSubscribeActivity implements MainMovieContract.MainMovieView {

    @Bean
    MainMoviePresenter mainMoviePresenter;

    @AfterViews
    public void init() {
        mainMoviePresenter.setView(this);
    }

    @Override
    public void onSucessGenres() {

    }

    @Override
    public void onErrorGenres() {

    }
}

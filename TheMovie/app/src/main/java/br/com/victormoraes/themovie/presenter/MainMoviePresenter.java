package br.com.victormoraes.themovie.presenter;

import org.androidannotations.annotations.EBean;

import br.com.victormoraes.themovie.contract.MainMovieContract;

@EBean
public class MainMoviePresenter extends Presenter<MainMovieContract.MainMovieView> implements MainMovieContract.MainMoviePresenter {

    @Override
    public void getGenresMovie() {

    }
}

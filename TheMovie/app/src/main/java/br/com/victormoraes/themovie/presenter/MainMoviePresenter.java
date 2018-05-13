package br.com.victormoraes.themovie.presenter;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.victormoraes.core.model.ErrorResponse;
import br.com.victormoraes.themovie.contract.MainMovieContract;
import br.com.victormoraes.themovie.listerner.ResponseViewListerner;
import br.com.victormoraes.themovie.model.Genre;
import br.com.victormoraes.themovie.usecase.movie.GenresUseCase;

@EBean
public class MainMoviePresenter extends Presenter<MainMovieContract.MainMovieView> implements MainMovieContract.MainMoviePresenter {

    @Bean
    GenresUseCase genresUseCase;

    @Override
    public void getGenresMovie() {
        genresUseCase.getGenres(new ResponseViewListerner<ArrayList<Genre>>() {
            @Override
            public void success(@NonNull ArrayList<Genre> list) {
                getView().onSucessGenres(list);
            }

            @Override
            public void error(@NonNull ErrorResponse errorResponse) {
                getView().onErrorGenres();
            }
        });
    }
}

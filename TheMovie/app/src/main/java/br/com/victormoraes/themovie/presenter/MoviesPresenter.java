package br.com.victormoraes.themovie.presenter;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import br.com.victormoraes.core.model.ErrorResponse;
import br.com.victormoraes.themovie.contract.MoviesContract;
import br.com.victormoraes.themovie.listerner.ResponseViewListerner;
import br.com.victormoraes.themovie.model.ListPagination;
import br.com.victormoraes.themovie.model.Movie;
import br.com.victormoraes.themovie.usecase.movie.GetMoviesUseCase;

@EBean
public class MoviesPresenter extends Presenter<MoviesContract.MoviesView> implements MoviesContract.MoviesPresenter {

    @Bean
    GetMoviesUseCase getMoviesUseCase;

    @Override
    public void getMovies(int genrerId, int page) {
        getMoviesUseCase.getMovies(genrerId, page, new ResponseViewListerner<ListPagination<Movie>>() {
            @Override
            public void success(@NonNull ListPagination<Movie> listPagination) {
                getView().onSucessMovies(listPagination);
            }

            @Override
            public void error(@NonNull ErrorResponse errorResponse) {
                getView().onErrorMovies();
            }
        });
    }
}

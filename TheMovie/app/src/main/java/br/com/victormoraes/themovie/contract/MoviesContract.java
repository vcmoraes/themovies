package br.com.victormoraes.themovie.contract;

import android.support.annotation.NonNull;

import br.com.victormoraes.themovie.model.ListPagination;
import br.com.victormoraes.themovie.model.Movie;

public interface MoviesContract {

    interface MoviesView {
        void onSucessMovies(@NonNull ListPagination<Movie> list);

        void onErrorMovies();
    }

    interface MoviesPresenter {
        void getMovies(int genrerId, int page);
    }
}

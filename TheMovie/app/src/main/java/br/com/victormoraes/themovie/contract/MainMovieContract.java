package br.com.victormoraes.themovie.contract;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import br.com.victormoraes.themovie.model.Genre;

public interface MainMovieContract {

    interface MainMovieView {
        void onSucessGenres(@NonNull ArrayList<Genre> list);

        void onErrorGenres();
    }

    interface MainMoviePresenter {
        void getGenresMovie();
    }
}

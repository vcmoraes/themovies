package br.com.victormoraes.themovie.contract;

public interface MainMovieContract {

    interface MainMovieView {
        void onSucessGenres();

        void onErrorGenres();
    }

    interface MainMoviePresenter {
        void getGenresMovie();
    }
}

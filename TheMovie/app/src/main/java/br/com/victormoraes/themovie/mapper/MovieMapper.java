package br.com.victormoraes.themovie.mapper;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.victormoraes.core.modelResponse.MovieResponse;
import br.com.victormoraes.themovie.model.Movie;

@EBean(scope = EBean.Scope.Singleton)
public class MovieMapper {

    @NonNull
    public ArrayList<Movie> toMovie(ArrayList<MovieResponse> listResponse) {
        ArrayList<Movie> list = new ArrayList<>();
        if (listResponse != null) {
            for (MovieResponse movieResponse : listResponse) {
                list.add(toMovie(movieResponse));
            }
        }
        return list;
    }

    @NonNull
    public Movie toMovie(MovieResponse movieResponse) {
        Movie movie = new Movie();
        return movie;
    }
}

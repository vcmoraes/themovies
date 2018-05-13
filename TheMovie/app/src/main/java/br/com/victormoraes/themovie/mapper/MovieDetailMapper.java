package br.com.victormoraes.themovie.mapper;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;

import br.com.victormoraes.core.modelResponse.MovieDetailResponse;
import br.com.victormoraes.themovie.model.MovieDetail;

@EBean(scope = EBean.Scope.Singleton)
public class MovieDetailMapper {

    @NonNull
    public MovieDetail toMovieDetail(MovieDetailResponse movieDetailResponse) {
        MovieDetail movieDetail = new MovieDetail();
        return movieDetail;
    }
}

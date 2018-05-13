package br.com.victormoraes.themovie.usecase.movie;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.victormoraes.core.api.movie.MovieApi;
import br.com.victormoraes.core.listerner.ResponseServer;
import br.com.victormoraes.core.model.ErrorResponse;
import br.com.victormoraes.core.modelResponse.GenreResponse;
import br.com.victormoraes.themovie.listerner.ResponseViewListerner;
import br.com.victormoraes.themovie.mapper.GenreMapper;
import br.com.victormoraes.themovie.model.Genre;
import br.com.victormoraes.themovie.usecase.BaseUseCase;

@EBean(scope = EBean.Scope.Singleton)
public class GenresUseCase extends BaseUseCase {

    @Bean
    MovieApi movieApi;

    @Bean
    GenreMapper genreMapper;

    public void getGenres(@NonNull final ResponseViewListerner<ArrayList<Genre>> listerner) {
        movieApi.getGenres(new ResponseServer<ArrayList<GenreResponse>>() {
            @Override
            public void success(ArrayList<GenreResponse> response) {
                listerner.success(genreMapper.toGenre(response));
            }

            @Override
            public void error(ErrorResponse errorResponse) {
                listerner.error(errorResponse);
            }
        });
    }
}

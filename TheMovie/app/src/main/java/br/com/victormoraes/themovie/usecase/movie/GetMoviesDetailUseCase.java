package br.com.victormoraes.themovie.usecase.movie;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import br.com.victormoraes.core.api.movie.MovieApi;
import br.com.victormoraes.core.listerner.ResponseServer;
import br.com.victormoraes.core.model.ErrorResponse;
import br.com.victormoraes.core.modelResponse.MovieDetailResponse;
import br.com.victormoraes.themovie.listerner.ResponseViewListerner;
import br.com.victormoraes.themovie.mapper.MovieDetailMapper;
import br.com.victormoraes.themovie.model.MovieDetail;

@EBean(scope = EBean.Scope.Singleton)
public class GetMoviesDetailUseCase {

    @Bean
    MovieApi movieApi;

    @Bean
    MovieDetailMapper movieDetailMapper;

    public void getMovieDetail(int movieId, final ResponseViewListerner<MovieDetail> listerner) {
        movieApi.getMovieDetail(movieId, new ResponseServer<MovieDetailResponse>() {
            @Override
            public void success(MovieDetailResponse response) {
                listerner.success(movieDetailMapper.toMovieDetail(response));
            }

            @Override
            public void error(ErrorResponse errorResponse) {
                listerner.error(errorResponse);
            }
        });
    }
}

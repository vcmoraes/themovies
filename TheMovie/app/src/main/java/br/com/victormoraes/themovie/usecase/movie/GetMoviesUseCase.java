package br.com.victormoraes.themovie.usecase.movie;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import br.com.victormoraes.core.api.movie.MovieApi;
import br.com.victormoraes.core.listerner.ResponseServer;
import br.com.victormoraes.core.model.ErrorResponse;
import br.com.victormoraes.core.modelResponse.MovieListResponse;
import br.com.victormoraes.themovie.listerner.ResponseViewListerner;
import br.com.victormoraes.themovie.mapper.MovieMapper;
import br.com.victormoraes.themovie.model.ListPagination;
import br.com.victormoraes.themovie.model.Movie;

@EBean(scope = EBean.Scope.Singleton)
public class GetMoviesUseCase {

    @Bean
    MovieApi movieApi;

    @Bean
    MovieMapper movieMapper;

    public void getMovies(int genreId, int page, final ResponseViewListerner<ListPagination<Movie>> listerner) {
        movieApi.getMovies(genreId, page, new ResponseServer<MovieListResponse>() {
            @Override
            public void success(MovieListResponse response) {
                ListPagination<Movie> listPagination = new ListPagination<>();
                listPagination.setHasMoreItens(response.hasMoreMovies());
                listPagination.setList(movieMapper.toMovie(response.getMoviesResponse()));
                listerner.success(listPagination);
            }

            @Override
            public void error(ErrorResponse errorResponse) {
                listerner.error(errorResponse);
            }
        });
    }
}

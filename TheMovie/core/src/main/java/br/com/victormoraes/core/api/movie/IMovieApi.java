package br.com.victormoraes.core.api.movie;

import java.util.ArrayList;

import br.com.victormoraes.core.listerner.ResponseServer;
import br.com.victormoraes.core.modelResponse.GenreResponse;
import br.com.victormoraes.core.modelResponse.MovieListResponse;
import io.reactivex.annotations.NonNull;

public interface IMovieApi {

    void getGenres(@NonNull final ResponseServer<ArrayList<GenreResponse>> listResponseServer);

    void getMovies(int genreId, int page, @NonNull final ResponseServer<MovieListResponse> listResponseServer);
}

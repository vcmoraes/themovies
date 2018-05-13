package br.com.victormoraes.core.api.movie;

import br.com.victormoraes.core.modelResponse.GenreListResponse;
import br.com.victormoraes.core.modelResponse.MovieListResponse;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieRetrofit {

    @GET("3/genre/movie/list")
    Observable<Response<GenreListResponse>> getGenres();

    @GET("3/genre/{genreId}/movies")
    Observable<Response<MovieListResponse>> getMovies(@Path("genreId") @NonNull int genreId, @Query("page") int page);
}

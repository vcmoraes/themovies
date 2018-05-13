package br.com.victormoraes.core.modelResponse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

public class MovieListResponse {

    @SerializedName("page")
    private Integer page;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("results")
    private ArrayList<MovieResponse> moviesResponse;

    @NonNull
    public int getPage() {
        return page == null ? 0 : page;
    }

    @NonNull
    public int getTotalPages() {
        return totalPages == null ? 0 : totalPages;
    }

    @NonNull
    public ArrayList<MovieResponse> getMoviesResponse() {
        if (moviesResponse == null) {
            moviesResponse = new ArrayList<>();
        }
        return moviesResponse;
    }

    public boolean hasMoreMovies() {
        return getPage() == getTotalPages();
    }
}

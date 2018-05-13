package br.com.victormoraes.core.modelResponse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

public class GenreListResponse {

    @SerializedName("genres")
    private ArrayList<GenreResponse> response;

    @NonNull
    public ArrayList<GenreResponse> getResponse() {
        if (response == null) {
            response = new ArrayList<>();
        }
        return response;
    }
}

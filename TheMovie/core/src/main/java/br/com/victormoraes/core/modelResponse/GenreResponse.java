package br.com.victormoraes.core.modelResponse;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.NonNull;

public class GenreResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @NonNull
    public Integer getId() {
        return id == null ? 0 : id;
    }

    @NonNull
    public String getName() {
        return TextUtils.isEmpty(name) ? "" : name;
    }
}

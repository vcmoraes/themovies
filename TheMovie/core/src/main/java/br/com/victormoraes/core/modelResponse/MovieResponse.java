package br.com.victormoraes.core.modelResponse;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import br.com.victormoraes.core.util.ImageUtil;
import io.reactivex.annotations.NonNull;

public class MovieResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @NonNull
    public Integer getId() {
        return id == null ? 0 : id;
    }

    @NonNull
    public String getTitle() {
        return TextUtils.isEmpty(title) ? "" : title;
    }

    @NonNull
    public String getPoster() {
        return ImageUtil.getUrlImageW500(TextUtils.isEmpty(poster) ? "" : poster);
    }

    @NonNull
    public String getOverview() {
        return TextUtils.isEmpty(overview) ? "" : overview;
    }

    @NonNull
    public String getBackdropPath() {
        return ImageUtil.getUrlImageOriginal(TextUtils.isEmpty(backdropPath) ? "" : backdropPath);
    }
}

package br.com.victormoraes.themovie.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

import br.com.victormoraes.themovie.util.StringUtil;

public class Movie implements Serializable {

    private Integer id;
    private String title;
    private String poster;
    private String overview;
    private String backdropPath;

    @NonNull
    public Integer getId() {
        return id == null ? 0 : id;
    }

    @NonNull
    public String getTitle() {
        return StringUtil.fixString(title);
    }

    @NonNull
    public String getPoster() {
        return StringUtil.fixString(poster);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @NonNull
    public String getOverview() {
        return StringUtil.fixString(overview);
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @NonNull
    public String getBackdropPath() {
        return StringUtil.fixString(backdropPath);
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
}

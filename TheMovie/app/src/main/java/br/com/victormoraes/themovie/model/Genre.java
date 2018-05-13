package br.com.victormoraes.themovie.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public class Genre {

    private Integer id;
    private String name;

    @NonNull
    public Integer getId() {
        return id == null ? 0 : id;
    }

    @NonNull
    public String getName() {
        return TextUtils.isEmpty(name) ? "" : name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package br.com.victormoraes.themovie.mapper;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.victormoraes.core.modelResponse.GenreResponse;
import br.com.victormoraes.themovie.model.Genre;

@EBean(scope = EBean.Scope.Singleton)
public class GenreMapper {

    @NonNull
    public ArrayList<Genre> toGenre(ArrayList<GenreResponse> listResponse) {
        ArrayList<Genre> list = new ArrayList<>();
        if (listResponse != null) {
            for (GenreResponse genreResponse : listResponse) {
                list.add(toGenre(genreResponse));
            }
        }
        return list;
    }

    @NonNull
    public Genre toGenre(GenreResponse genreResponse) {
        Genre genre = new Genre();
        genre.setId(genreResponse.getId());
        genre.setName(genreResponse.getName());
        return genre;
    }
}

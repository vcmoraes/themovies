package br.com.victormoraes.themovie.usecase;

import org.androidannotations.annotations.EBean;

import javax.annotation.Nonnull;

import io.realm.Realm;

@EBean
public class BaseUseCase {

    private Realm realm = Realm.getDefaultInstance();

    @Nonnull
    public Realm getRealm() {
        return realm;
    }
}

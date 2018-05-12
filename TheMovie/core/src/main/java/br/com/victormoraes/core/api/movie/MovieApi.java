package br.com.victormoraes.core.api.movie;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import br.com.victormoraes.core.api.BaseApi;

@EBean(scope = EBean.Scope.Singleton)
public class MovieApi {

    @RootContext
    Context context;

    private BaseApi<MovieRetrofit> serviceApi = new BaseApi<>(MovieRetrofit.class);

}

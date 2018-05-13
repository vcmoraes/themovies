package br.com.victormoraes.core.api.movie;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;

import br.com.victormoraes.core.api.BaseApi;
import br.com.victormoraes.core.listerner.ResponseServer;
import br.com.victormoraes.core.modelResponse.GenreListResponse;
import br.com.victormoraes.core.modelResponse.GenreResponse;
import br.com.victormoraes.core.modelResponse.MovieListResponse;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

@EBean(scope = EBean.Scope.Singleton)
public class MovieApi implements IMovieApi {

    @RootContext
    Context context;

    private BaseApi<MovieRetrofit> serviceApi = new BaseApi<>(MovieRetrofit.class);

    @Override
    public void getGenres(@NonNull final ResponseServer<ArrayList<GenreResponse>> listResponseServer) {
        serviceApi.getApi().getGenres().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Response<GenreListResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<GenreListResponse> arrayListResponse) {
                listResponseServer.success(arrayListResponse.body().getResponse());
            }

            @Override
            public void onError(Throwable e) {
                serviceApi.verifyErrorDefault(context, e, listResponseServer);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getMovies(int genreId, int page, final ResponseServer<MovieListResponse> listResponseServer) {
        serviceApi.getApi().getMovies(genreId, page).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Response<MovieListResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<MovieListResponse> listResponse) {
                listResponseServer.success(listResponse.body());
            }

            @Override
            public void onError(Throwable e) {
                serviceApi.verifyErrorDefault(context, e, listResponseServer);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}

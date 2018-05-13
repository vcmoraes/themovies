package br.com.victormoraes.core.api;

import org.androidannotations.annotations.EBean;

import java.io.IOException;
import java.util.Locale;

import io.reactivex.annotations.NonNull;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@EBean(scope = EBean.Scope.Singleton)
public class InitCore {

    public void init() {
        ApiClient.getInstance().setEndPoint(URLS.URL_BASE, new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", "8c35f1145014c967014940b61100f44d")
                        .addQueryParameter("language", Locale.getDefault().toString())
                        .build();

                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
    }
}

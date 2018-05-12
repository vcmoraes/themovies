package br.com.victormoraes.themovie.listerner;

import android.support.annotation.NonNull;

import br.com.victormoraes.core.model.ErrorResponse;

public interface ResponseViewListerner<MODEL> {

    void success(@NonNull MODEL response);

    void error(@NonNull ErrorResponse errorResponse);
}

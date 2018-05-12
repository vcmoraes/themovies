package br.com.victormoraes.core.api;

import android.content.Context;

import com.google.gson.JsonSyntaxException;

import org.greenrobot.eventbus.EventBus;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import br.com.victormoraes.core.R;
import br.com.victormoraes.core.exceptions.NetworkingProblems;
import br.com.victormoraes.core.listerner.ResponseServer;
import br.com.victormoraes.core.model.ErrorResponse;
import io.reactivex.annotations.NonNull;
import retrofit2.HttpException;

/**
 * Created by lcarvalho on 02/03/2018.
 */

public class BaseApi<I> {

    private I api;

    public BaseApi(@NonNull Class<I> type) {
        this.api = ApiClient.getInstance().getClient().create(type);
    }

    public I getApi() {
        return api;
    }

    public void verifyErrorDefault(Context context, Throwable e, ResponseServer listerner) {
        try {
            if (e instanceof HttpException) {
                HttpException httpException = (HttpException) e;
                if (httpException.code() == 401) {
                    ErrorResponse errorResponse = new ErrorResponse();
                    errorResponse.setMen(context.getResources().getText(R.string.user_unauthorized).toString());
                    errorResponse.setServerError(false);
                    listerner.error(errorResponse);
                    return;
                }
                if (httpException.code() == 503 || httpException.code() == 500 || httpException.code() == 404 || httpException.code() == 400) {
                    ErrorResponse errorResponse = new ErrorResponse();
                    errorResponse.setMen(context.getResources().getText(R.string.men_error_server).toString());
                    errorResponse.setServerError(true);
                    listerner.error(errorResponse);
                    return;
                }
            } else if (e instanceof SocketTimeoutException || e instanceof ConnectException || e instanceof JsonSyntaxException) {
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setMen(context.getResources().getText(R.string.men_error_server).toString());
                errorResponse.setServerError(true);
                listerner.error(errorResponse);
                return;
            }
            EventBus.getDefault().post(new NetworkingProblems());
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMen(context.getResources().getText(R.string.internet_error).toString());
            errorResponse.setServerError(false);
            errorResponse.setInternetError(true);
            listerner.error(errorResponse);
        } catch (Exception ee) {
            try {
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setServerError(true);
                listerner.error(errorResponse);
            } catch (Exception ignore) {
                e.printStackTrace();
            }
        }
    }
}

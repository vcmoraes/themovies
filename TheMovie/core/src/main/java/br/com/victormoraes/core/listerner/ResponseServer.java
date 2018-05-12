package br.com.victormoraes.core.listerner;

import br.com.victormoraes.core.model.ErrorResponse;

public interface ResponseServer<MODEL> {

    void success(MODEL response);

    void error(ErrorResponse errorResponse);
}

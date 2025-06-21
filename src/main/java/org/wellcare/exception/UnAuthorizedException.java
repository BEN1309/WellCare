package org.wellcare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnAuthorizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnAuthorizedException() {
        super("You are not authorized to perform this action.");
    }

    public UnAuthorizedException(String message) {
        super(message);
    }
}

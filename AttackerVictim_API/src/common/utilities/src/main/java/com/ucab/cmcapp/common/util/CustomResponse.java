package com.ucab.cmcapp.common.util;

public class CustomResponse<T> {
    public T response = null;
    public String description;

    public CustomResponse(T response, String description) {
        this.response = response;
        this.description = description;
    }

    public CustomResponse(String description) {
        this.description = description;
    }
}

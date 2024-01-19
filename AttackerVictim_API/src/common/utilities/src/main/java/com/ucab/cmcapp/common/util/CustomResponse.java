package com.ucab.cmcapp.common.util;

public class CustomResponse<T> {
    public T response = null;
    public String description;

    /**
     * Este constructor se usa para crear una instancia de CustomResponse
     * con un Objeto generico y una descripcion
     *
     * @param response Objeto generico
     * @param description descripcion
     */
    public CustomResponse(T response, String description) {
        this.response = response;
        this.description = description;
    }

    /**
     * Este constructor se usa para crear una instancia de CustomResponse
     * unicamente con descripcion (el atributp response queda en null)
     *
     * @param description descripcion
     */
    public CustomResponse(String description) {
        this.description = description;
    }
}

'use client'

// Este archivo permite acceder a una variable que va a contener
// el enlace del servidor donde corre nuestra API.

export let enlaceAPI = "https://big-famous-raccoon.ngrok-free.app";

export const setEnlace = (newUrl) => {
    enlaceAPI = newUrl;
};
export const endGetAllUsers = "/testAPI/api/productos";

export const endGetVictimaByUsername = "/testAPI/api/productos/username/";
export const endGetVictimaByCedula = "/testAPI/api/productos/cedula/";
export const endGetVictimaByCorreo = "/testAPI/api/productos/";

export const endGetAtacanteByUsername = "/testAPI/api/productos/username/";
export const endGetAtacanteByCedula = "/testAPI/api/productos";
export const endGetAtacanteByCorreo = "/testAPI/api/productos";

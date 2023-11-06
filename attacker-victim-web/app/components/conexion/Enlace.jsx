// Este archivo permite acceder a una variable que va a contener
// el enlace del servidor donde corre nuestra API.

export let enlace = "https://big-famous-raccoon.ngrok-free.app";

export const setEnlace = (newUrl) => {
  enlace = newUrl;
};

export const getAllUsers = "/testAPI/api/productos";

export const getVictimaByUsername = "/testAPI/api/productos/username/";
export const getVictimaByCedula = "/testAPI/api/productos/cedula/";
export const getVictimaByCorreo = "/testAPI/api/productos/";

export const getAtacanteByUsername = "/testAPI/api/productos/username/";
export const getAtacanteByCedula = "/testAPI/api/productos";
export const getAtacanteByCorreo = "/testAPI/api/productos";


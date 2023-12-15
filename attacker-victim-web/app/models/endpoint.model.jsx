
// Este archivo permite acceder a una variable que va a contener
// el enlace del servidor donde corre nuestra API.
// Ademas de todos los endpoint del sistema web.

export const enlaceAPI = "https://big-famous-raccoon.ngrok-free.app";

export const endGetAllUsers = `/cmcapp-backend-1.0/api/users/all`;

export const endGetAllAdmins = `/cmcapp-backend-1.0/api/administrator/all`;
export const endGetAllVictims = `/cmcapp-backend-1.0/api/victim/all`;
export const endGetAllAttackers = `/cmcapp-backend-1.0/api/attacker/all`;

export const endGetUserByUsername = "/cmcapp-backend-1.0/api/users/username/";
export const endGetUserByCedula = "/cmcapp-backend-1.0/api/users/personal_id/";
export const endGetUserByEmail = "/cmcapp-backend-1.0/api/users/email/";
export const endGetUserByMAC = "/cmcapp-backend-1.0/api/users/mac/";


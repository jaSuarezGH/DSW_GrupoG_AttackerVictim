
// Este archivo permite acceder a una variable que va a contener
// el enlace del servidor donde corre nuestra API.
// Ademas de todos los endpoint del sistema web.

export const enlaceAPI = "http://127.0.0.1:8080";

export const endGetAllUsers = `/cmcapp-backend-1.0/api/users/all`;

export const endGetAllAdmins = `/cmcapp-backend-1.0/api/administrator/all`;
export const endGetAllVictims = `/cmcapp-backend-1.0/api/victim/all`;
export const endGetAllAttackers = `/cmcapp-backend-1.0/api/attacker/all`;

export const endGetUserByUsername = "/cmcapp-backend-1.0/api/users/username/";
export const endGetUserByCedula = "/cmcapp-backend-1.0/api/users/personal_id/";
export const endGetUserByEmail = "/cmcapp-backend-1.0/api/users/email/";
export const endGetUserByMAC = "/cmcapp-backend-1.0/api/users/mac/";

export const endAddUser = "/cmcapp-backend-1.0/api/users";
export const endAddVictim= "/cmcapp-backend-1.0/api/victim";
export const endAddAttacker= "/cmcapp-backend-1.0/api/attacker";


export const endPutUser= "/cmcapp-backend-1.0/api/users";

export const endGetAllIncidents= "/cmcapp-backend-1.0/api/incident/all";

export const endGetIncidentByVictim= "/cmcapp-backend-1.0/api/incident/victimRegistry/";
export const endGetIncidentByAttacker= "/cmcapp-backend-1.0/api/incident/attackerRegistry/";
export const endAddIncident= "/cmcapp-backend-1.0/api/incident";


export const endGetVictimById= "/cmcapp-backend-1.0/api/victim/";
export const endGetAttackerById= "/cmcapp-backend-1.0/api/attacker/";












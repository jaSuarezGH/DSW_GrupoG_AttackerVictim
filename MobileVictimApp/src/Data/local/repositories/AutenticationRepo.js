import { apiClient } from "../api/ApiService";

export const getDataUsuarioGmail = async (gmail) => {
  try {
    const solicitud = await apiClient.get('/users/email/'+gmail+'');
    if (solicitud !== undefined) {
      if (solicitud.status === 200) { //Condicion del tipo de status que se recibio
        if (solicitud.data.response !== null) {
          return solicitud;
        } else {
          throw new Error(solicitud.data.description);
        }
      } 
    }
  } catch (error) {
    throw error;
  }
};

export const getDataVictimaID = async (id) => {
  try {
    const solicitud = await apiClient.get('/victim/'+id+'');
    if (solicitud !== undefined) {
      if (solicitud.status === 200) { //Condicion del tipo de status que se recibio
        if (solicitud.data.response !== null) {
          return solicitud;
        } else {
          throw new Error(solicitud.data.description);
        }
      } 
    }
  } catch (error) {
    throw error;
  }
};

export const getDataUsuarioUserName = async (userName) => {
  try {
    const solicitud = await apiClient.get('/users/username/'+userName+'');
    if (solicitud !== undefined) {
      if (solicitud.status === 200) { //Condicion del tipo de status que se recibio
        if (solicitud.data.response !== null) {
          return solicitud;
        } else {
          throw new Error(solicitud.data.description);
        }
      } 
    }
  } catch (error) {
    throw error;
  }
};

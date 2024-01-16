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
      }; 
    }
  } catch (error) {
    throw error;
  }
};

export const postVerificacionUsuario = async (userCredential) => {
  try {
    const response = await apiClient.post('/users/auth',userCredential);
    if (response !== undefined) {
      if (response.status === 200) { //Condicion del tipo de status que se recibio
        return response;
      } else {
        throw new Error('Error al verificar los datos del usuario. Por favor, intente nuevamente.');
      }
    }
  } catch (error) {
    throw error;
  }
};

export const getAllDataVictimas = async () => {
  try {
    const solicitud = await apiClient.get('/victim/all');
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


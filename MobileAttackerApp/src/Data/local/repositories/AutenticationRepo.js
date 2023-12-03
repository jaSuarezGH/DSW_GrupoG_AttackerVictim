import { apiClient } from "../api/ApiService";

export const getDataUsuario = async () => {
    try {
      const response = await apiClient.get('/recuperar');
      if (response !== undefined) {
        if (response.status === 200) { //Condicion del tipo de status que se recibio
          return response;
        } 
      }
    } catch (error) {
      return error.response;
    }
};

// Función `postDataUsuario()`
export const postDataUsuario = async (usuario) => {
    try {
      const response = await apiClient.post('/validar', usuario);
      if (response !== undefined) {
        if (response.status === 202) { //Condicion del tipo de status que se recibio
          return response;
        } 
      }
    } catch (error) {
      return error.response;
    }
};

export const postCoordenadas = async (coordenadas) => {
  try {
    const response = await apiClient.post('/coordenadas',coordenadas);
    if (response !== undefined) {
      if (response.status === 200) { //Condicion del tipo de status que se recibio
        return response;
      } 
    }
  } catch (error) {
    return error.response;
  }
};
  
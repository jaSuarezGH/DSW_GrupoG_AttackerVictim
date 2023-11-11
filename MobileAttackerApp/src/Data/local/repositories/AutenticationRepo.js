import { apiClient } from "../api/ApiService";

export const getDataUsuario = async () => {
    try {
      const response = await apiClient.get('/recuperar');
      //console.log(response.status);
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

  
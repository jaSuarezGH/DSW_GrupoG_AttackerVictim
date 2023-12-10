import { apiClient } from "../api/ApiService";

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
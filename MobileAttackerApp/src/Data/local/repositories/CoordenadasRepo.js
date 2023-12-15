import { apiClient } from "../api/ApiService";

export const postCoordenadas = async (coordenadas) => {
    try {
      const response = await apiClient.post('/history',coordenadas);
      if (response !== undefined) {
        if (response.status === 200) { //Condicion del tipo de status que se recibio
          return response;
        } else {
          throw new Error('Error al enviar las coordenadas.');
        }
      }
    } catch (error) {
      throw error;
    }
};
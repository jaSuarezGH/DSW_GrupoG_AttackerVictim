import { apiClient } from "../api/ApiService";

export const postNotificacion = async (notificacion) => {
    try {
      const response = await apiClient.post('/notification',notificacion);
      if (response !== undefined) {
        if (response.status === 200) { //Condicion del tipo de status que se recibio
          return response;
        } else {
          throw new Error('Error al enviar la notificacion.');
        }
      }
    } catch (error) {
      throw error;
    }
};
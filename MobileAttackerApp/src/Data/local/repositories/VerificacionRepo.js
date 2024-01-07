import { apiClient } from "../api/ApiService";

export const getIncidenteAtacante = async (id) => {
    try {
      const solicitud = await apiClient.get('/incident/attackerRegistry/'+id+'');
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


export const getAtacanteZonaSegura = async (incidente) => {
    try {
      const solicitud = await apiClient.get('/operation/attacker-in-safe-zone/'+incidente+'');
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


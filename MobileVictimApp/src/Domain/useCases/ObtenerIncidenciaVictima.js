import { getIncidenteVictima } from "../../Data/local/repositories/VerificacionRepo"; 

export const ObtenerIncidenteVictima = async (id) => {
    return await getIncidenteVictima(id);
}
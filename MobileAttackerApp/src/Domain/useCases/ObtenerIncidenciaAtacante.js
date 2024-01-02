import { getIncidenteAtacante } from "../../Data/local/repositories/VerificacionRepo"; 

export const ObtenerIncidenteAtacante = async (idUsuario) => {
    return await getIncidenteAtacante(idUsuario);
}
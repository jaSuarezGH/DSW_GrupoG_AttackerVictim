import { getDistanciaVictimaAgresor } from "../../Data/local/repositories/VerificacionRepo"; 

export const ObtenerDistanciaVictimaAgresor = async (id) => {
    return await getDistanciaVictimaAgresor(id);
}
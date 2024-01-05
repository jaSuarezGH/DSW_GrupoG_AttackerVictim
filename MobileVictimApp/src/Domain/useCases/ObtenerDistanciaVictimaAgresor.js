import { getDistanciaVictimaAgresor } from "../../Data/local/repositories/VerificacionRepo"; 

export const obtenerDistanciaVictimaAgresor = async (id) => {
    return await getDistanciaVictimaAgresor(id);
}
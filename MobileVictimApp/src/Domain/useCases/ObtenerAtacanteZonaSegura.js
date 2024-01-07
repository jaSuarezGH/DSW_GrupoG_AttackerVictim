import { getAtacanteZonaSegura } from "../../Data/local/repositories/VerificacionRepo"; 

export const obtenerAtacanteZonaSegura = async (id) => {
    return await getAtacanteZonaSegura(id);
}
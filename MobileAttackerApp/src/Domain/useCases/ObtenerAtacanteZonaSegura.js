import { getAtacanteZonaSegura } from "../../Data/local/repositories/VerificacionRepo"; 

export const ObtenerAtacanteZonaSegura = async (id) => {
    return await getAtacanteZonaSegura(id);
}
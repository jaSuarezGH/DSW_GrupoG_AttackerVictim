import { getDataAtacanteID } from "../../Data/local/repositories/AutenticationRepo";

export const obtenerDatosPorIdAtacante= async (id) => {
    return await getDataAtacanteID(id);
};
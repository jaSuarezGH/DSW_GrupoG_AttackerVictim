import { getDataVictimaID } from "../../Data/local/repositories/AutenticationRepo";

export const obtenerDatosVictima = async (id) => {
    return await getDataVictimaID(id);
};
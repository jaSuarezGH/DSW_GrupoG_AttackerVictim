import { getDataUsuarioID } from "../../Data/local/repositories/AutenticationRepo";

export const obtenerVictimaPorID = async (id) => {
    return await getDataUsuarioID(id);
}
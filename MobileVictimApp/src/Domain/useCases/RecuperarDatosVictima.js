import { getAllDataVictimas } from "../../Data/local/repositories/AutenticationRepo";

export const obtenerDatosVictima = async () => {
    return await getAllDataVictimas();
};
import { getAllDataAtacantes } from "../../Data/local/repositories/AutenticationRepo";

export const obtenerDatosAtacante = async () => {
    return await getAllDataAtacantes();
};
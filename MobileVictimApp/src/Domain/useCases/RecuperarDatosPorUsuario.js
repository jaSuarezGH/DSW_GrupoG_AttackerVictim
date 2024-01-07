import { getDataUsuarioUserName } from "../../Data/local/repositories/AutenticationRepo";

export const obtenerDatosPorNombreUsuario = async (usuario) => {
    return await getDataUsuarioUserName(usuario);
};
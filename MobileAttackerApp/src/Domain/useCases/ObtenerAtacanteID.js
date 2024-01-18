import { getDataUsuarioID } from '../../Data/local/repositories/AutenticationRepo';

export const obtenerAtacantePorID = async (id) => {
    return await getDataUsuarioID(id);
}
import {postCoordenadas} from "../../Data/local/repositories/CoordenadasRepo"

export const PostUsuarioCoordenadas = async (coordenadas) => {
    return await postCoordenadas(coordenadas);
}
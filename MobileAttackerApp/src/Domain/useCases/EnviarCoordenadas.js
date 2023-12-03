import {postCoordenadas} from "../../Data/local/repositories/AutenticationRepo"

export const PostUsuarioCoordenadas = async (coordenadas) => {
    return await postCoordenadas(coordenadas);
}
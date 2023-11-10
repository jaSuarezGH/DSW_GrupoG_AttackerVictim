import {postDataUsuario} from "../../Data/local/repositories/AutenticationRepo"

export const PostUserData = async (usuario) => {
    return await postDataUsuario(usuario);
}
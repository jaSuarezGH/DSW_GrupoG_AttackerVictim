import {postVerificacionUsuario} from "../../Data/local/repositories/AutenticationRepo"

export const verficarCredencialesUsuario = async (userCredential) => {
    return await postVerificacionUsuario(userCredential);
}
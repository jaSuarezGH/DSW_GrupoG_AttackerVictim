import { getDataUsuario } from "../../Data/local/repositories/AutenticationRepo";

export const GetUserData = async () => {
    return await getDataUsuario();
};
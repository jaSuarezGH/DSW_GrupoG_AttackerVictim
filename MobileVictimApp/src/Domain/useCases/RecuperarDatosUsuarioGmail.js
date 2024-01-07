import { getDataUsuarioGmail } from "../../Data/local/repositories/AutenticationRepo";

export const getUserDataGmail = async (gmail) => {
    return await getDataUsuarioGmail(gmail);
};
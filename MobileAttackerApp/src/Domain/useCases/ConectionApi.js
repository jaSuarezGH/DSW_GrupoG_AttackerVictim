import { connect } from "../../Data/local/api/ApiService";

export const GetStatusConnection = async (urlApi) => {
    return await connect(urlApi);
}
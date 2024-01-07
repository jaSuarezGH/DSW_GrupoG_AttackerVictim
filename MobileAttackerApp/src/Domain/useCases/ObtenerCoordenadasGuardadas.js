import { getLocations } from "../../Data/local/SQLite/sqlite";

export const ObtenerCoordenadasSQL = async () => {
    return await getLocations();
}
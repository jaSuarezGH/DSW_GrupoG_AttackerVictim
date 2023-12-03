import { saveLocation } from "../../Data/local/SQLite/sqlite";

export const GuardarCoordenadasSQL = async (coordenadas) => {
    return await saveLocation(coordenadas);
}
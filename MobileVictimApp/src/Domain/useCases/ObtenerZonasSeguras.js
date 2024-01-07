import { getZonasSeguras } from "../../Data/local/repositories/CoordenadasRepo";

export const ObtenerZonasSegurasID = async (id) => {
    return await getZonasSeguras(id);
}
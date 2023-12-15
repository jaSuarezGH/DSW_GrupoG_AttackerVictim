import { deleteLocations } from "../../Data/local/SQLite/sqlite"

export const EliminarUsuarioCoordenadas = async () => {
    return await deleteLocations();
}
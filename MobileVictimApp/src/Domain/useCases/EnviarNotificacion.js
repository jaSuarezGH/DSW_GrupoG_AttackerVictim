import { postNotificacion } from "../../Data/local/repositories/NotificacionRepo";

export const PostUsuarioNotificacion = async (notificacion) => {
    return await postNotificacion(notificacion);
}
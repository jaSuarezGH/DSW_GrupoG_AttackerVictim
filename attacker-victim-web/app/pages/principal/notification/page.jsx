import HeaderPrincipal from "@/components/Header/HeaderPrincipal";
import { Navigation } from "@/components/Navigation";
import { endGetAllNotifications } from "@/app/models/endpoint.model";
import TablaAllNotifications from "@/components/Table/Notifications/TablaAllNotification";
import { fetchGetDelete } from "../fetch/fetchGetDelete";
import { DivHeader } from "@/components/Div";

export default async function PrincipalPage() {
  const fetchNotifications = await fetchGetDelete(endGetAllNotifications);
  // Ordenar las notificaciones por fecha descendente.
  fetchNotifications.sort((a, b) => b._full_date - a._full_date);
  return (
    <>
      <div className="bg-white py-2 sm:py-10 ">
        <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-12 px-6 lg:px-8 ">
          <DivHeader
            title="Historial de Notificaciones"
            description="Historal de todas las Notificaciones registradas en el sistema."
            tags={[1,2,3]}
          ></DivHeader>
          <TablaAllNotifications
            notifications={fetchNotifications}
          ></TablaAllNotifications>
        </div>
      </div>
    </>
  );
}

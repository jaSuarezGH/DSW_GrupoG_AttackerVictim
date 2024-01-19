"use client";

import {
  endAddNotification,
  endGetAllNotifications,
  endGetAllUsers,
  endGetHistoryByUserId,
} from "@/app/models/endpoint.model";
import { fetchGetDelete } from "../fetch/fetchGetDelete";
import { DivHeader } from "@/components/Div";
import { useEffect, useRef, useState } from "react";
import { fetchPostPut } from "../fetch/fetchPostPut/fetchPostPut";
import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { TablaAllNotifications } from "@/components/Table/Notifications/TablaAllNotification";

export default function notificationPage() {
  // APARTADO PARA CALCULAR Y CREAR NOTIFICACIONES DE TIPO OFFLINE
  const tiempoRef = useRef(0);
  const [control, setControl] = useState(false);
  const [error, setError] = useState(false);
  const [titleError, setTitleError] = useState("");
  const [descriptionError, setDescriptionError] = useState("");

  const [notifications, setNotifications] = useState([]);

  useEffect(() => {
    const fetchConsult = async () => {
      if (control) {
        // APARTADO PARA MOSTRAR LAS NOTIFICACIONES EN SI
        const fetchNotifications = await fetchGetDelete(endGetAllNotifications);
        if (fetchNotifications) {
          // Ordenar las notificaciones por fecha descendente.
          fetchNotifications.sort((a, b) => b._full_date - a._full_date);

          // Filtrar las notificaciones que cumplen la condición _user._active = true
          const modifiedNotifications = fetchNotifications.filter(
            (notification) => notification._user._active === true
          );
          if (modifiedNotifications) {
            setNotifications(modifiedNotifications);
          } else {
            setError(true);
            setTitleError("No hay Usuarios");
            setDescriptionError(
              `No se encuentran registrados en el sistema actualmente o se encuentan en estado Inactivos.`
            );
          }
        } else {
          setError(true);
          setTitleError("No hay Notificaciones");
          setDescriptionError(
            `No se encuentran registradas notificaciones en el sistema actualmente.`
          );
        }
      }
    };
    //Variable que se encarga de indicar cuando se podria mostrar el error
    fetchConsult();
    setControl(true);
  }, [control]);

  if (error && control) {
    return (
      <InformacionPage
        title={titleError}
        description={descriptionError}
        encabezado="Not Found"
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    );
  }

  if (control)
    return (
      <>
        <div className="bg-white py-2 sm:py-10 ">
          <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-12 px-6 lg:px-8 ">
            <DivHeader
              title="Historial de Notificaciones"
              description="Historal de todas las Notificaciones registradas en el sistema."
              tags={[1, 2, 3]}
            ></DivHeader>
            <TablaAllNotifications
              notifications={notifications}
            ></TablaAllNotifications>
          </div>
        </div>
      </>
    );
}

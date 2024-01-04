"use client";

import {
  endAddNotification,
  endGetAllNotifications,
  endGetAllUsers,
  endGetHistoryByUserId,
} from "@/app/models/endpoint.model";
import TablaAllNotifications from "@/components/Table/Notifications/TablaAllNotification";
import { fetchGetDelete } from "../fetch/fetchGetDelete";
import { DivHeader } from "@/components/Div";
import { useEffect, useRef, useState } from "react";
import { fetchPostPut } from "../fetch/fetchPostPut/fetchPostPut";
import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";

export default function notificationPage() {
  // APARTADO PARA CALCULAR Y CREAR NOTIFICACIONES DE TIPO OFFLINE
  const tiempoRef = useRef(0);
  const [control, setControl] = useState(false);
  const [error, setError] = useState(false);
  const [titleError, setTitleError] = useState('');
  const [descriptionError, setDescriptionError] = useState('');

  const [notifications, setNotifications] = useState([]);

  useEffect(() => {
    const fetchConsult = async () => {
      if (control) {
        const users = await fetchGetDelete(endGetAllUsers);

        if (users) {
        // Recorrer cada usuario.
        for (const user of users) {
          // Solo interesan los usuarios que esten activos

          if (user._active) {
            setError(false);
            // Buscar en la tabla Historial todos los registros del usuario dado.
            const historiales = await fetchGetDelete(
              endGetHistoryByUserId,
              user.id
            );
            for (const historial of historiales) {
              if (tiempoRef.current < historial._full_date) {
                tiempoRef.current = historial._full_date;
              }
            }
            // Los tiempos estan expresados en milisegundos.
            // Si no hay actualizacion del posicionamiento en mas de un 1min.
            // Se crea una notificacion de OFFLINE.
              if (Date.now() - tiempoRef.current > 80000) {
              const bodyNotification = {
                _full_date: Date.now(),
                _status: "USUARIO OFFLINE",
                _user: {
                  id: user.id,
                },
              };
              const newNotificationOffline = await fetchPostPut(
                endAddNotification,
                "POST",
                bodyNotification
              );

              if (!newNotificationOffline) {
                setError(true);
                setTitleError("Error al Actualizar las Notificaciones");
                setDescriptionError(
                  `No se ha podido actualizar las notificaciones en el sistema, intente nuevamente.`
                );
              }
            } 
          } else {
            setError(true);
            setTitleError("No Hay Usuarios Activos");
            setDescriptionError(
              `No se encuentran registrados Usuarios que esten Activos en el sistema actualmente.`
            );
          }
        } 
      } else {
        setError(true);
        setTitleError("No Hay Usuarios");
        setDescriptionError(
          `No se encuentra registrado ningun tipo de Usuario en el sistema actualmente.`
        );
      }
        // APARTADO PARA MOSTRAR LAS NOTIFICACIONES EN SI
        const fetchNotifications = await fetchGetDelete(endGetAllNotifications);
        if (fetchNotifications){
        // Ordenar las notificaciones por fecha descendente.
        fetchNotifications.sort((a, b) => b._full_date - a._full_date);
        setNotifications(fetchNotifications);
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

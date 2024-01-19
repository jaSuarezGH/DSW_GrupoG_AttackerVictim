"use client";

import {
  endGetAllUsers,
  endGetHistoryByUserId,
} from "@/app/models/endpoint.model";
import { useEffect, useRef, useState } from "react";
import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { fetchGetDelete } from "../../fetch/fetchGetDelete";
import { DivHeader } from "@/components/Div";
import { TablaAllOnline } from "@/components/Table/UsersOnline/TablaAllOnline";

export default function statusOnOffPage() {
  // APARTADO PARA CALCULAR Y CREAR NOTIFICACIONES DE TIPO OFFLINE
  const tiempoRef = useRef(0);
  const [control, setControl] = useState(false);
  const [error, setError] = useState(false);
  const [titleError, setTitleError] = useState("");
  const [descriptionError, setDescriptionError] = useState("");

  const [usersConexion, setUsersConexion] = useState([]);

  useEffect(() => {
    const fetchConsult = async () => {
      if (control) {
        const users = await fetchGetDelete(endGetAllUsers);

        if (users) {
          setError(true);
          setTitleError("No Hay Usuarios Activos");
          setDescriptionError(
            `No se encuentran registrados Usuarios que esten Activos en el sistema actualmente.`
          );

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
              if (historiales) {
                for (const historial of historiales) {
                  if (tiempoRef.current < historial._full_date) {
                    tiempoRef.current = historial._full_date;
                  }
                }
                // Los tiempos estan expresados en milisegundos.
                // Si no hay actualizacion del posicionamiento en mas de un 2min.
                // Se establece a ese usuario como OFFLINE.
                const userData = {
                  _username: user._username,
                  _firstname: user._firstname,
                  _lastname: user._lastname,
                  _personal_id: user._personal_id,
                  _email: user._email,
                  _mac: user._mac_address,
                  _online: !(Date.now() - tiempoRef.current > 120000),
                };
                setUsersConexion((usersConexion) => [...usersConexion, userData])
              }
            }
          }
        } else {
          setError(true);
          setTitleError("No Hay Usuarios");
          setDescriptionError(
            `No se encuentra registrado ningun tipo de Usuario en el sistema actualmente.`
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
              title="Estado Online/Offline de Usuarios Victima y Atacante"
              description="Tabla con todos los usuarios activos de tipo Victima o Atacante indicando su estatus de conexion actual."
              tags={[1]}
            ></DivHeader>
            <TablaAllOnline
              usersConexion={usersConexion}
            ></TablaAllOnline>
          </div>
        </div>
      </>
    );
}

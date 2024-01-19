"use client";

import {
  endGetAttackerById,
  endGetIncidentByAttacker,
  endGetIncidentByVictim,
  endGetPositionByAttacker,
  endGetPositionByVictim,
  endGetUserByEmail,
  endGetVictimById,
} from "@/app/models/endpoint.model";
import { Routes } from "@/app/models/routes.model";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { DivHeader } from "@/components/Div";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { ListConsultaUser } from "@/components/List/ListConsultaUser/ListConsultaUser";
import { GoogleMap, LoadScript, MarkerF } from "@react-google-maps/api";
import { useEffect, useState } from "react";

function pageConsultPosicionamiento({ params }) {
  const containerStyle = {
    width: "100%",
    height: "30rem",
  };

  const [user, setUser] = useState(null);
  const [typeUser, setTypeUser] = useState("");
  const [center, setCenter] = useState({});
  const [control, setControl] = useState(false);
  const [title, setTitle] = useState(`Usuario NO Encontrado`);
  const [description, setDescription] = useState(
    `Lo siento, el usuario a consultar el posicionamiento poseedor del Correo Electronico (Email): "${params.position}" no esta registrado o activo.`
  );

  useEffect(() => {
    const fetchConsult = async () => {
      //const positionConsult = await fetchGetDelete()
      const buscarUserByEmail = await fetchGetDelete(
        endGetUserByEmail,
        params.position
      );
      if (buscarUserByEmail) {
        const buscarUserInVictim = await fetchGetDelete(
          endGetVictimById,
          buscarUserByEmail.id
        );
        if (buscarUserInVictim) {
          setTypeUser("Victima");
          const buscarVictimInIncident = await fetchGetDelete(
            endGetIncidentByVictim,
            buscarUserInVictim.id
          );
          if (buscarVictimInIncident) {
            const lastPositionVictim = await fetchGetDelete(
              endGetPositionByVictim,
              buscarVictimInIncident.id
            );
            if (lastPositionVictim) {
              setUser(lastPositionVictim);
              setCenter({
                lat: lastPositionVictim._latitude,
                lng: lastPositionVictim._longitude,
              });
            } else {
              setTitle("Usuario sin Posicionamiento");
              setDescription(
                `Lo siento, el usuario a consultar el posicionamiento poseedor del Correo Electronico (Email): "${params.position}" no posee un ultimo posicionamiento aun.`
              );
            }s
          }
        } else {
          const buscarUserInAttacker = await fetchGetDelete(
            endGetAttackerById,
            buscarUserByEmail.id
          );
          const buscarAttackerInIncident = await fetchGetDelete(
            endGetIncidentByAttacker,
            buscarUserInAttacker.id
          );
          setTypeUser("Atacante");
          if (buscarAttackerInIncident) {
            const lastPositionAttacker = await fetchGetDelete(
              endGetPositionByAttacker,
              buscarAttackerInIncident.id
            );
            if (lastPositionAttacker) {
              setUser(lastPositionAttacker);
              setCenter({
                lat: lastPositionAttacker._latitude,
                lng: lastPositionAttacker._longitude,
              });
            } else {
              setTitle("Usuario sin Posicionamiento");
              setDescription(
                `Lo siento, el usuario a consultar el posicionamiento poseedor del Correo Electronico (Email): "${params.position}" no posee un ultimo posicionamiento aun.`
              );
            }
          }
        }
      }
      //Variable que se encarga de indicar cuando se podria mostrar el error
      setControl(true);
    };

    fetchConsult();
  }, []);

  if ((user === null || user._user._active == false) && control) {
    return (
      <InformacionPage
        title={title}
        description={description}
        encabezado="Not Found"
        link={Routes.GET_LOCATION_HOME}
        linkText="Volver a Buscar"
      ></InformacionPage>
    );
  }
  if (control)
    return (
      <div className="max-w-6xl mb-6 ring-1 ring-opacity-50 ring-zinc-300 rounded-xl shadow-lg shadow-indigo-300 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto gap-x-8 gap-y-12">
        <DivHeader
          title={`Datos y Ultimo Posicionamiento del Usuario ${typeUser}`}
          description={`Todos los datos del usuario ${typeUser} a consultar poseedor del Email: "${params.position}" junto con su ultimo posicionamiento.`}
          tags={typeUser == "Victima" ? [2] : [3]}
        ></DivHeader>

        <ListConsultaUser user={user._user}></ListConsultaUser>

        <div
          className={
            typeUser == "Victima"
              ? `border-4 border-green-200 hover:border-green-400`
              : `border-4 border-red-200 hover:border-red-400`
          }
        >
          <LoadScript googleMapsApiKey="AIzaSyAVCv2edVHkkor2XENUBSsamIXFgMFn8UM">
            <GoogleMap
              mapContainerStyle={containerStyle}
              center={center}
              zoom={14}
            >
              <MarkerF position={center}></MarkerF>
            </GoogleMap>
          </LoadScript>
        </div>
      </div>
    );
}

export default pageConsultPosicionamiento;

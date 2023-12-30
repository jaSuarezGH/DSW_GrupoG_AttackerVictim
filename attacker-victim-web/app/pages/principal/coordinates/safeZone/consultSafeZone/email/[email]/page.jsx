"use client";

import { DivHeader } from "@/components/Div";
import { groupBy } from "lodash";
import { GoogleMap, LoadScript, PolygonF } from "@react-google-maps/api";
import { useEffect, useState } from "react";
import {
  endGetSafeZonesByUser,
  endGetUserByEmail,
  endGetVictimById,
} from "@/app/models/endpoint.model";
import { Routes } from "@/app/models/routes.model";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { InformacionPage } from "@/components/InformationPage/InformationPage";

function pageConsultSafeZoneByEmail({ params }) {
  const containerStyle = {
    width: "100%",
    height: "30rem",
  };

  const [user, setUser] = useState(null);

  const [coordinates, setCoordinates] = useState({});

  const [descriptionError, setDescriptionError] = useState(
    `Lo siento, el usuario a consultar las Zonas Seguras poseedor del Correo Electronico (Email): "${params.email}" no esta registrado o activo.`
  );
  const [titleError, setTitleError] = useState("Usuario NO Encontrado");

  const [control, setControl] = useState(false);

  useEffect(() => {
    const fetchConsult = async () => {
      const getUserInUsers = await fetchGetDelete(
        endGetUserByEmail,
        params.email
      );
      if(getUserInUsers) {
      const getUserInVictim = await fetchGetDelete(
        endGetVictimById,
        getUserInUsers.id
      );
      if (getUserInVictim) {
        if (getUserInUsers) {
          const getSafeZones = await fetchGetDelete(
            endGetSafeZonesByUser,
            getUserInUsers.id
          );
          if (getSafeZones) {
            setUser(getUserInUsers);
            const newCoordinates = [];

            const groupedCoordinates = groupBy(getSafeZones, "_name"); // Agrupar por '_name'
            for (const key of Object.keys(groupedCoordinates)) {
              const groupCoordinates = groupedCoordinates[key].map((index) => ({
                lat: index._coordinate._latitude,
                lng: index._coordinate._longitude,
              }));

              newCoordinates.push(groupCoordinates);
            }

            setCoordinates(newCoordinates);
          } else {
            setTitleError("No hay Zonas Seguras");
            setDescriptionError(
              `El usuario victima poseedor del Correo Electronico (Email): "${params.email}" no posee zonas seguras asociadas.`
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

  if (user === null && control) {
    return (
      <InformacionPage
        title={titleError}
        description={descriptionError}
        encabezado="Not Found"
        link={Routes.CONSULT_ZS}
        linkText="Volver a Buscar"
      ></InformacionPage>
    );
  }

  if (control)
    return (
      <div className="max-w-6xl mb-6 ring-1 ring-opacity-50 ring-zinc-300 rounded-xl shadow-lg shadow-indigo-300 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto gap-x-8 gap-y-12">
        <DivHeader
          title={`Consultar Zonas Seguras de una Victima`}
          description={`Zonas Seguras asociadas al usuario tipo Victima poseedor del Email: "${params.email}" registrado en el sistema.`}
          tags={[2]}
        ></DivHeader>

        <div
          className={`mt-8 border-4 border-green-200 hover:border-green-400`}
        >
          <LoadScript googleMapsApiKey="AIzaSyAVCv2edVHkkor2XENUBSsamIXFgMFn8UM">
            <GoogleMap
              mapContainerStyle={containerStyle}
              zoom={13}
              center={coordinates[0][0]}
            >
              <PolygonF
                paths={coordinates}
                options={{
                  strokeColor: "#FF0000",
                  strokeOpacity: 0.8,
                  strokeWeight: 2,
                  fill: true,
                  fillColor: "#FF0000",
                  fillOpacity: 0.35,
                }}
              />
            </GoogleMap>
          </LoadScript>
        </div>
      </div>
    );
}

export default pageConsultSafeZoneByEmail;

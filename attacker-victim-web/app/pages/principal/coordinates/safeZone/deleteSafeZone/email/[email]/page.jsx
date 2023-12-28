"use client";

import { DivHeader } from "@/components/Div";
import { groupBy } from "lodash";
import { GoogleMap, LoadScript, PolygonF } from "@react-google-maps/api";
import { useEffect, useState } from "react";
import {
  endDeleteSafeZoneById,
  endGetSafeZonesByUser,
  endGetUserByEmail,
  endGetVictimById,
} from "@/app/models/endpoint.model";
import { Routes } from "@/app/models/routes.model";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { ListBoxGet } from "@/components/ListBoxGet/ListBoxGet";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { useRouter } from "next/navigation";

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}

function pageDeleteSafeZoneByEmail({ params }) {
  const containerStyle = {
    width: "100%",
    height: "30rem",
  };

  const router = useRouter();

  const [options, setOptions] = useState([]);
  const [selected, setSelected] = useState(null);

  const [user, setUser] = useState(null);
  const [safeZones, setSafeZones] = useState(null);

  const [coordinates, setCoordinates] = useState({});

  const [descriptionError, setDescriptionError] = useState(
    `Lo siento, el usuario del que se desea eliminar la Zona Segura, poseedor del Correo Electronico (Email): "${params.email}" no esta registrado o activo.`
  );
  const [titleError, setTitleError] = useState("Usuario NO Encontrado");

  const [control, setControl] = useState(false);

  useEffect(() => {
    const fetchConsult = async () => {
      const getUserInUsers = await fetchGetDelete(
        endGetUserByEmail,
        params.email
      );
      if (getUserInUsers) {
        const getUserInVictim = await fetchGetDelete(
          endGetVictimById,
          getUserInUsers.id
        );
        if (getUserInVictim) {
          const getSafeZones = await fetchGetDelete(
            endGetSafeZonesByUser,
            getUserInUsers.id
          );
          if (getSafeZones) {
            setUser(getUserInUsers);
            setSafeZones(getSafeZones);
            const names = [];

            const groupedCoordinates = groupBy(getSafeZones, "_name"); // Agrupar por '_name'
            for (const key of Object.keys(groupedCoordinates)) {
              const groupCoordinates = groupedCoordinates[key].map((index) => ({
                lat: index._coordinate._latitude,
                lng: index._coordinate._longitude,
              }));
              names.push(key);
              setCoordinates(groupCoordinates);
            }
            setOptions(names);
            setSelected(options[0]);
          } else {
            setTitleError("No hay Zonas Seguras");
            setDescriptionError(
              `El usuario victima poseedor del Correo Electronico (Email): "${params.email}" no posee zonas seguras asociadas.`
            );
          }
        }
      }
      //Variable que se encarga de indicar cuando se podria mostrar el error
      setControl(true);
    };

    fetchConsult();
  }, []);

  useEffect(() => {
    setSelected(options[0]);
  }, [options]);

  useEffect(() => {
    const fetchConsult = async () => {

            const groupedCoordinates = groupBy(safeZones, "_name"); // Agrupar por '_name'
            for (const key of Object.keys(groupedCoordinates)) {
              if (key == selected) {
                const groupCoordinates = groupedCoordinates[key].map(
                  (index) => ({
                    lat: index._coordinate._latitude,
                    lng: index._coordinate._longitude,
                  })
                );
                setCoordinates(groupCoordinates);
              }
          }
  };

    fetchConsult();
  }, [selected]);

  if (user === null && control) {
    return (
      <InformacionPage
        title={titleError}
        description={descriptionError}
        encabezado="Not Found"
        link={Routes.DELETE_ZS}
        linkText="Volver a Buscar"
      ></InformacionPage>
    );
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    for (const zone of safeZones){
      if(zone._name == selected){
        const deleteSafeZone = await fetchGetDelete(endDeleteSafeZoneById, zone.id, 'DELETE');
      }
    }
    router.push(Routes.DELETE_ZS_RESPONSE);
  };

  if (control)
    return (
      <div className="max-w-6xl mb-6 ring-1 ring-opacity-50 ring-zinc-300 rounded-xl shadow-lg shadow-indigo-300 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto gap-x-8 gap-y-12">
        <DivHeader
          title={`Eliminar Zona Segura de una Victima`}
          description={`Selecciona una Zona Segura asociada al usuario tipo Victima poseedor del Email: "${params.email}" registrado en el sistema.`}
          tags={[2]}
        ></DivHeader>
        <form className="m-10 mb-6" onSubmit={onSubmit}>
          <ListBoxGet
            selected={selected}
            onChange={setSelected}
            options={options}
            classNames={classNames}
            textLabel="Selecionar Zona Segura a eliminar:"
          ></ListBoxGet>

          <div
            className={`mt-8 border-2 border-green-200 hover:border-green-400`}
          >
            <LoadScript googleMapsApiKey="AIzaSyAVCv2edVHkkor2XENUBSsamIXFgMFn8UM">
              <GoogleMap
                mapContainerStyle={containerStyle}
                zoom={16}
                center={coordinates[0]}
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
          {/* Boton Submit */}
        <div className="mb-6 mt-16 flex items-center justify-end gap-x-6">
          <div className="w-60">
            <ButtonSubmit
              text="Eliminar Zona Segura"
              styles="px-3 py-3 text-lg"
            ></ButtonSubmit>
          </div>
        </div>
        </form>
      </div>
    );
}

export default pageDeleteSafeZoneByEmail;

"use client";

import { DivHeader } from "@/components/Div";
import { DivFormElement } from "@/components/Div/DivFormElement/DivFormElement";
import { GoogleMap, LoadScript, PolygonF } from "@react-google-maps/api";
import { useEffect, useState } from "react";

function pageCreateSafeZone({ params }) {
  const containerStyle = {
    width: "100%",
    height: "30rem",
  };

  const coordinates = [
    { lat: 33.774, lng: -130.419 },
    { lat: 37.774, lng: -124.43 },
    { lat: 31.774, lng: -120.43 },
  ];

  const [user, setUser] = useState(null);

  const [safeZoneID, setSafeZoneID] = useState("");

  const [center, setCenter] = useState({ lat: 33.774, lng: -130.419 });
  const [control, setControl] = useState(false);

  useEffect(() => {
    const fetchConsult = async () => {
      /* navigator.geolocation.getCurrentPosition(
        (position) => {
          setCenter({
            lat: position.coords.latitude,
            lng: position.coords.longitude,
          });
        },
        (error) => console.log(error),
        { enableHighAccuracy: true }
      ); */
      //Variable que se encarga de indicar cuando se podria mostrar el error
      setControl(true);
    };

    fetchConsult();
  }, []);

  /*  if ((user === null || user._user._active == false) && control) {
    const description = `Lo siento, el usuario a consultar el posicionamiento poseedor del Correo Electronico (Email): "${params.position}" no esta registrado o activo.`;
    return (
      <InformacionPage
        title="Usuario NO Encontrado"
        description={description}
        encabezado="Not Found"
        link={Routes.GET_LOCATION_HOME}
        linkText="Volver a Buscar"
      ></InformacionPage>
    );
  } */

  const onSubmit = (e) => {
    e.PreventDefault();
  };

  if (control)
    return (
      <div className="max-w-6xl mb-6 ring-1 ring-opacity-50 ring-zinc-300 rounded-xl shadow-lg shadow-indigo-300 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto gap-x-8 gap-y-12">
        <DivHeader
          title={`Crear Zona Segura de la Victima`}
          description={`Indique un Nombre identificador y el area en el mapa para establecer la Zona Segura del usuario victima a consultar poseedor del Email: "${params.position}".`}
          tags={[2]}
        ></DivHeader>
        <form className="mb-6" onSubmit={onSubmit}>
          <DivFormElement
            id="safeZoneID"
            name="safeZoneID"
            textLabel="Nombre Identificador de la Zona Segura"
            type="text"
            placeholder="Ingrese aqui el nombre identificador de la Zona Segura"
            value={safeZoneID}
            onChange={(e) => {
              setSafeZoneID(e.target.value);
            }}
          ></DivFormElement>
          <div
            className={`mt-8 border-4 border-green-200 hover:border-green-400`}
          >
            <LoadScript googleMapsApiKey="AIzaSyAVCv2edVHkkor2XENUBSsamIXFgMFn8UM">
              <GoogleMap
                mapContainerStyle={containerStyle}
                center={center}
                zoom={5}
              >
                <PolygonF
                  paths={coordinates}
                  options={{
                    draggable: true,
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
        </form>
      </div>
    );
}

export default pageCreateSafeZone;

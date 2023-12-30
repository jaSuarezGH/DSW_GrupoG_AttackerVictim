"use client";

import { DivHeader } from "@/components/Div";
import { DivFormElement } from "@/components/Div/DivFormElement/DivFormElement";
import { GoogleMap, LoadScript, PolygonF } from "@react-google-maps/api";
import { useEffect, useState } from "react";
import { fetchGetDelete } from "../../../../../fetch/fetchGetDelete";
import {
  endAddCoordinate,
  endAddSafeZone,
  endGetSafeZonesByUser,
  endGetUserByEmail,
  endGetVictimById,
} from "@/app/models/endpoint.model";
import AlertError from "@/components/Alert/AlertError";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { fetchPostPut } from "@/app/pages/principal/fetch/fetchPostPut/fetchPostPut";
import { useRouter } from "next/navigation";
import AlertInformation from "@/components/Alert/AlertInformation";

function pageCreateSafeZone({ params }) {
  const containerStyle = {
    width: "100%",
    height: "30rem",
  };

  const router = useRouter();

  const [user, setUser] = useState(null);
  const [coordinatesF, setCoordinatesF] = useState([]);

  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");

  const [safeZoneID, setSafeZoneID] = useState("");

  const [center, setCenter] = useState(coordinatesF[0]);

  const [control, setControl] = useState(false);

  useEffect(() => {
    const fetchConsult = async () => {
      const getUserInUser = await fetchGetDelete(
        endGetUserByEmail,
        params.email
      );

      if (getUserInUser) {
        const getUserInVictim = await fetchGetDelete(
          endGetVictimById,
          getUserInUser.id
        );

        if (getUserInVictim) {
          setUser(getUserInVictim);

          navigator.geolocation.getCurrentPosition(
            (position) => {
              setCenter({
                lat: position.coords.latitude,
                lng: position.coords.longitude,
              });
            },
            (error) => console.log(error),
            { enableHighAccuracy: true }
          );
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
        title="Usuario NO Encontrado"
        description={`Lo siento, el usuario a crear la Zona Segura, poseedor del Correo Electronico (Email): "${params.email}" no esta registrado o activo.`}
        encabezado="Not Found"
        link={Routes.CREATE_ZS}
        linkText="Volver a Buscar"
      ></InformacionPage>
    );
  }



  const onSubmit = async (e) => {
    e.preventDefault();
    if (coordinatesF.length > 2) {
      const getSafeZonesByUser = await fetchGetDelete(
        endGetSafeZonesByUser,
        user._user.id
      );
      let safeZoneIDExistente = false;
      for (const safeZone of getSafeZonesByUser) {
        if (safeZone._name == safeZoneID) {
          safeZoneIDExistente = true;
          break;
        }
      }
      if (!safeZoneIDExistente) {
        setErrorInfo(false);

        // Crear una coordenada en la tabla Coordinate y luego asociarla al
        // crear una zona segura. Asi en ciclo hasta recorrer todas las coordenadas.
        for(const coordenada of coordinatesF){
          const aggCoordinate = await fetchPostPut(endAddCoordinate, 'POST', {
            "_latitude": coordenada.lat,
            "_longitude": coordenada.lng
        });
        const aggSafeZone = await fetchPostPut(endAddSafeZone, 'POST', {
          "_name": safeZoneID,
          "_user": {
              "id": user._user.id
          },
          "_coordinate": {
              "id": aggCoordinate.id
          }
      })
        }
        
        router.push(Routes.CREATE_ZS_RESPONSE);

      } else {
        setDescriptionError(
          `El Nombre Identificador de la Zona Segura ya se encuentra registrado para este usuario, ingrese otro.`
        );
        setErrorInfo(true);
      }
    } else {
      setDescriptionError(
        `El area de la Zona Segura debe estar conformada por un minimo de tres puntos (Coordenadas).`
      );
      setErrorInfo(true);
    }
  };

  const onClick = (event) => {
    const newCoordinate = { lat: event.latLng.lat(), lng: event.latLng.lng() };
    setCoordinatesF([...coordinatesF, newCoordinate]);
  };

  const onRightClick = (event) => {
    // Saca el ultimo elemento a coordinates y luego asigna ese arreglo nuevo a coordinates
    setCoordinatesF(coordinatesF.slice(0, -1));
  };

  if (control)
    return (
      <div className="max-w-6xl mb-6 ring-1 ring-opacity-50 ring-zinc-300 rounded-xl shadow-lg shadow-indigo-300 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto gap-x-8 gap-y-12">
        <DivHeader
          title={`Crear Zona Segura de la Victima`}
          description={`Indique un Nombre identificador y el area en el mapa para establecer la Zona Segura del usuario victima a consultar poseedor del Email: "${params.email}".`}
          tags={[2]}
        ></DivHeader>
        <form className="mb-6" onSubmit={onSubmit}>
          {errorInfo && (
            <div className="mb-8">
              <AlertError description={descriptionError}></AlertError>
            </div>
          )}
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
          <div className="mt-6 mb-2">
          <AlertInformation description={'Para indicar un punto de coordenada del area de la Zona Segura, presione click Izquierdo (con dos puntos es que se genera visualmente el poligono. Click Derecho para eliminar el ultimo punto del poligono (deshacer).'}></AlertInformation>
          </div>
          <div
          >
            <LoadScript googleMapsApiKey="AIzaSyAVCv2edVHkkor2XENUBSsamIXFgMFn8UM">
              <GoogleMap
                clickableIcons={false}
                onClick={onClick}
                onRightClick={onRightClick}
                mapContainerStyle={containerStyle}
                center={center}
                zoom={13}
              >
                <PolygonF
                  visible={true}
                  paths={coordinatesF}
                  onRightClick={onRightClick}
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
          {errorInfo && (
            <div className="mt-8">
              <AlertError description={descriptionError}></AlertError>
            </div>
          )}
          {/* Boton Submit */}
          <div className="mb-8 mt-12 flex items-center justify-end gap-x-6 pr-6">
            <div className="w-1/3">
              <ButtonSubmit
                text="Crear Zona Segura"
                styles="px-3 py-3 text-lg"
              ></ButtonSubmit>
            </div>
          </div>
        </form>
      </div>
    );
}

export default pageCreateSafeZone;

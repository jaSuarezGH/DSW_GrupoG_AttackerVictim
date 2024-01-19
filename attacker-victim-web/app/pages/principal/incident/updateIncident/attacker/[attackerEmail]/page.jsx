"use client";

import {
  endGetIncidentByAttacker,
  endGetUserByEmail,
  endGetAttackerById,
  endPutIncident,
} from "@/app/models/endpoint.model";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";
import { DivSubHeader } from "@/components/Div/Header/DivSubHeader/DivSubHeader";
import { useEffect, useState } from "react";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivFormElement } from "@/components/Div/DivFormElement/DivFormElement";
import { useRouter } from "next/navigation";
import { DivHeader } from "@/components/Div";
import { fetchPostPut } from "@/app/pages/principal/fetch/fetchPostPut/fetchPostPut";
import { AlertError } from "@/components/Alert/AlertError";

export default function getIncidentByAttackerEmailPage({ params }) {
  const router = useRouter();

  const [distanciaAlejamiento, setDistanciaAlejamiento] = useState(0);
  const [incident, setIncident] = useState(null);

  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");

  const [control, setControl] = useState(false);

  useEffect(() => {
    const fetchDataUser = async () => {
      const user = await fetchGetDelete(
        endGetUserByEmail,
        params.attackerEmail
      );

      if (user != null) {
        const attacker = await fetchGetDelete(endGetAttackerById, user.id);

        if (attacker != null) {
          const incident = await fetchGetDelete(
            endGetIncidentByAttacker,
            attacker.id
          );
          if (incident != null) {
            setIncident(incident);
            setDistanciaAlejamiento(incident._separation_distance);
          }
        }
      }

      //Variable que se encarga de indicar cuando se podria mostrar el error
      setControl(true);

      // Aunque se haga el setUser, no se actualiza ese valor dentro del effect
      // Se debe usar entonces la variable misma que realizo el fethc, pero
      // igualmente hacer setUser, para que el resto de la app lo use.
    };

    fetchDataUser();
  }, []);

  if (incident === null && control) {
    const description = `Lo siento, el usuario a modificar poseedor del Correo Electronico (Email): "${decodeURIComponent(params.attackerEmail)}" no se encuentra registrado.`;
    return (
      <InformacionPage
        title="Usuario NO Encontrado"
        description={description}
        encabezado="Not Found"
        link={Routes.UPDATE_RELATION}
        linkText="Volver a Buscar"
      ></InformacionPage>
    );
  }

  const onSubmit = async (e) => {
    e.preventDefault();

    if (distanciaAlejamiento > 0) {
      incident._separation_distance = distanciaAlejamiento;

      const updateIncident = await fetchPostPut(
        endPutIncident,
        "PUT",
        incident
      );
      if (updateIncident != null) {
        setErrorInfo(false);
        router.push("/pages/principal/incident/updateIncident/response");
      } else {
        setDescriptionError(
          "Ha ocurrido un error inesperado al realizar la operacion de Modificacion de Incidente. Por favor intente nuevamente mas tarde."
        );
        setErrorInfo(true);
      }
    } else {
      setDescriptionError(
        "La Distancia de Alejamiento entre la Victima y el Atacante debe ser un numero positivo (mayor a 0)."
      );
      setErrorInfo(true);
    }
  };

  return (
    <>
      <div className="mt-8 mx-auto grid gap-x-8 gap-y-12 px-6 lg:px-8">
        <DivHeader
          title="Modificar Relacion Victima/Atacante"
          description="Ingrese los nuevos datos correspondiente a la Relacion (Incidente) entre los usuarios Victima/Atacante."
          tags={[2, 3]}
        ></DivHeader>
      </div>
      <form className="m-10 mb-6" onSubmit={onSubmit}>
        {/* DATOS DE LA RELACION VIC/ATA */}
        <div className="space-y-12 mt-10">
          <DivSubHeader
            title="Datos de la relacion entre la Victima y el Atacante"
            description="Ingrese los datos correspondiente de la relacion entre la Victima
            y el Atacante ingresados previamente."
          ></DivSubHeader>

          <div className="border-b border-gray-900/10 pb-12">
            <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
              <DivFormElement
                textLabel="Distancia de Alejamiento (en metros)"
                type="number"
                id="alejamiento"
                name="alejamiento"
                placeholder="Ingrese la distancia en metros de alejamiento minimo entre los usuarios aqui"
                onChange={(e) => {
                  setDistanciaAlejamiento(e.target.value);
                }}
                value={distanciaAlejamiento}
              ></DivFormElement>
            </div>
          </div>
        </div>
        {errorInfo && (
          <div className="mt-8">
            <AlertError description={descriptionError}></AlertError>
          </div>
        )}
        {/* Boton Submit */}
        <div className="mb-8 mt-12 flex items-center justify-end gap-x-6 pr-6">
          <div className="w-1/6">
            <ButtonSubmit
              text="Modificar Relacion"
              styles="px-3 py-3 text-lg"
            ></ButtonSubmit>
          </div>
        </div>
      </form>
    </>
  );
}

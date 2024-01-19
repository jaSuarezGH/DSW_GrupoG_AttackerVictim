import {
    endGetIncidentByAttacker,
    endGetUserByEmail,
    endGetAttackerById,
  } from "@/app/models/endpoint.model";
  import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
  import { InformacionPage } from "@/components/InformationPage/InformationPage";
  import { Routes } from "@/app/models/routes.model";
  import { DivHeader } from "@/components/Div";
  import { ListConsultaUser } from "@/components/List/ListConsultaUser/ListConsultaUser";
  import { DivSubHeader } from "@/components/Div/Header/DivSubHeader/DivSubHeader";
import { DivDefinitionListElement } from "@/components/Div/DivResponseUser/DivDefinitionListElement/DivDefinitionListElement";
  
  export default async function getIncidentByAttackerEmailPage({ params }) {
    const description = `Lo siento, el usuario tipo Atacante a consultar poseedor del Email: "${decodeURIComponent(params.attackerEmail)}" no se encuentra registrado.`;
  
    try {
      const user = await fetchGetDelete(endGetUserByEmail, params.attackerEmail);
      if (!user) {
        throw new Error("Usuario no encontrado");
      }
  
      const attacker = await fetchGetDelete(endGetAttackerById, user.id);
  
      if (!attacker) {
        throw new Error("Atacante no encontrada");
      }
  
      const incident = await fetchGetDelete(endGetIncidentByAttacker, attacker.id);
  
      if (!incident) {
        throw new Error("Incidente no encontrado");
      }
  
      return (
        <>
          <div className="max-w-6xl mb-6 ring-1 ring-opacity-50 ring-zinc-300 rounded-xl shadow-lg shadow-indigo-300 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto gap-x-8 gap-y-12">
            <DivHeader
              title="Consultar la Relacion Victima/Atacante por Correo Electronico"
              description={`Todos los datos de la Relacion (Incidente) del usuario a consultar poseedor del email: "${decodeURIComponent(params.attackerEmail)}".`}
              tags={[3]}
            ></DivHeader>
            <DivSubHeader
              title={`Datos del Usuario Atacante`}
              description={`Datos correspondientes al Usuario Atacante consultado.`}
            ></DivSubHeader>
            <ListConsultaUser user={incident._attacker._user}></ListConsultaUser>
            <DivSubHeader
              title={`Datos del Usuario Victima`}
              description={`Datos correspondientes al Usuario Victima relacionado al Atacante.`}
            ></DivSubHeader>
            <ListConsultaUser user={incident._victim._user}></ListConsultaUser>
            <DivSubHeader
              title={`Datos de la Relacion Victima/Atacante`}
              description={`Datos correspondientes a la Relacion (Incidente) entre Victima y Atacante.`}
            ></DivSubHeader>
            <DivDefinitionListElement
              title="Distancia de Alejamiento"
              value={`${incident._separation_distance} `+` metros`}
            ></DivDefinitionListElement>
          </div>
        </>
      );
    } catch (error) {
      return (
        <InformacionPage
          title="Usuario NO Encontrado"
          description={description}
          encabezado="Not Found"
          link={Routes.GET_RELATION}
          linkText="Volver a Consultar"
        ></InformacionPage>
      );
    }
  }
  
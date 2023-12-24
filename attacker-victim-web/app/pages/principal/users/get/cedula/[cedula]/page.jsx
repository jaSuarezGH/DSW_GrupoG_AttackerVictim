import { DivResponseUser } from "@/components/Div/DivResponseUser/DivResponseUser";
import { endGetUserByCedula } from "@/app/models/endpoint.model";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete" ;
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";

export default async function getVictimaCedulaPage({ params }) {
  
  const user = await fetchGetDelete(endGetUserByCedula, params.cedula);
  
  if (user === null) {
    
    const description = `Lo siento, el usuario a consultar poseedor de la Cedula: "${params.cedula}" no se encuentra registrado.`
    return (
      <InformacionPage
      title="Usuario NO Encontrado"
      description={description}
      encabezado="Not Found"
      link={Routes.GET_USER}
      linkText="Volver a Consultar"
    ></InformacionPage>
    )
  }
  

  return (
    <DivResponseUser
      user={user}
      title="Consultar Usuario por Cedula"
      description={`Todos los datos del usuario a consultar poseedor de la cedula: ${user._personal_id}.`}
      tags={[]}
    ></DivResponseUser>
  );
}

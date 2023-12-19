import { DivResponseUser } from "@/components/Div/DivResponseUser/DivResponseUser";
import { endGetUserByMAC } from "@/app/models/endpoint.model";
import { fetchGetDelete } from "../../../fetch/fetchGetDelete";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";

export default async function getVictimaMACPage({ params }) {
  
  const user = await fetchGetDelete(endGetUserByMAC, params.mac);
  
  if (user === null) {
    
    const description = `Lo siento, el usuario a consultar poseedor de la Direccion MAC: "${params.mac}" no se encuentra registrado.`
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
      title="Consultar Usuario por Direccion MAC"
      description={`Todos los datos del usuario a consultar poseedor de la Direccion MAC: ${user.mac}.`}
      tags={[]}
    ></DivResponseUser>
  );
}

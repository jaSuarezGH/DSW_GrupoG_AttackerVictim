import { DivResponseUser } from "@/components/Div/DivResponseUser/DivResponseUser";
import { endGetUserByEmail } from "@/app/models/endpoint.model";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";

export default async function getVictimaEmailPage({ params }) {
  
  const user = await fetchGetDelete(endGetUserByEmail, params.email);
  
  if (user === null) {
    
    const description = `Lo siento, el usuario a consultar poseedor del Email: "${decodeURIComponent(params.email)}" no se encuentra registrado.`
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
      title="Consultar Usuario por Correo Electronico"
      description={`Todos los datos del usuario a consultar poseedor del email: ${decodeURIComponent(user._email)}.`}
      tags={[]}
    ></DivResponseUser>
  );
}

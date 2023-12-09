import { DivResponseUser } from "@/components/Div/DivResponseUser/DivResponseUser";
import { endGetUserByEmail } from "@/app/models/endpoint.model";
import { UsersFetch } from "../../../fetch/UsersFetch";

export default async function getVictimaEmailPage({ params }) {
  
  const user = await UsersFetch (endGetUserByEmail, params.email);
  
  if (user === null) {
    
    const description = `Lo siento, el usuario a consultar poseedor de la Cedula: ${params.cedula} no se encuentra registrado.`
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
      description={`Todos los datos del usuario a consultar poseedor del email: ${user.correo}.`}
      tags={[user.tipo]}
    ></DivResponseUser>
  );
}

import { DivResponseUser } from "@/components/Div/DivResponseUser/DivResponseUser";
import { endGetUserByUsername } from "@/app/models/endpoint.model";
import { UsersFetch } from "../../../fetch/UsersFetch";

export default async function getUserUsernamePage({ params }) {
  
  const user = await UsersFetch (endGetUserByUsername, params.username);

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
      title="Consultar Usuario por Nombre de Usuario (Username)"
      description={`Todos los datos del usuario a consultar poseedor del Username: ${user.username}.`}
      tags={[user.tipo]}
    ></DivResponseUser>
  );
}

import { DivResponseUser } from "@/components/Div/DivResponseUser/DivResponseUser";
import { endGetUserByCedula } from "@/app/models/endpoint.model";
import { UsersFetch } from "../../../fetch/UsersFetch";

export default async function getVictimaCedulaPage({ params }) {
  
  const user = await UsersFetch (endGetUserByCedula, params.cedula);

  return (
    <DivResponseUser
      user={user}
      title="Consultar Usuario por Cedula"
      description={`Todos los datos del usuario a consultar poseedor de la cedula: ${user.cedula}.`}
      tags={[user.tipo]}
    ></DivResponseUser>
  );
}

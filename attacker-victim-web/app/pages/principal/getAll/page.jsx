import { UsersFetch } from "@/app/components/getAll/UsersFetch";
import { enlace } from "@/app/components/conexion/Enlace";
import {Navegacion} from '@/app/components/compartido/Navegacion'

async function UsersPage() {
  return <>
  <Navegacion number={0}></Navegacion>
  <UsersFetch enlace={enlace}></UsersFetch>;
  </>
}

export default UsersPage;

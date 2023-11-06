import { fetchAllUsers } from "@/app/components/getAll/UsersFetch";
import {Navegacion} from '@/app/components/compartido/Navegacion';
import {GetAllAtacantes} from '@/app/components/users/atacante/getAll/GetAllAtacantes'

export default async function getAllAtacantesPage() {

    const users = await fetchAllUsers();

  return <>
  <Navegacion number={2}></Navegacion>
  <GetAllAtacantes users={users}></GetAllAtacantes>
  </>
}

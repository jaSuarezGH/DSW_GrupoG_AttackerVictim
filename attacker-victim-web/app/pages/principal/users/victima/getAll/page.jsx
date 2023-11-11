import { fetchAllUsers } from "@/app/components/getAll/UsersFetch";
import {Navegacion} from '@/app/components/compartido/Navegacion';
import {GetAllVictimas} from '@/app/components/users/victima/getAll/GetAllVictimas'

export default async function getAllVictimasPage() {

    const users = await fetchAllUsers();

  return <>
  <Navegacion number={1}></Navegacion>
  <GetAllVictimas users={users}></GetAllVictimas>
  </>
}

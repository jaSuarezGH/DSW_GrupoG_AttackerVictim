import { ListaUsuarios } from "@/app/components/getAll/ListaUsuarios";
import { enlace, getAllUsers } from "@/app/components/conexion/Enlace";

export async function fetchAllUsers() {
  // Revalidate significa que comprueba la data cada x segundos, y la actualiza de ser el caso
  const response = await fetch(enlace + getAllUsers, { next: { revalidate: 20 }}).then((res) =>
    res.json()
  );

  return response;
}

export async function UsersFetch() {
  const users = await fetchAllUsers();

  return <ListaUsuarios users={users}></ListaUsuarios>;
}

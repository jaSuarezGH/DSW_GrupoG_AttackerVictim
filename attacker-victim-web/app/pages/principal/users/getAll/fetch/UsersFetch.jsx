import { endGetAllUsers, enlaceAPI } from "@/app/models/endpoint.model";


async function FetchGetAllUsers() {
  // Revalidate significa que comprueba la data cada x segundos, y la actualiza de ser el caso
  return await fetch(`${enlaceAPI}${endGetAllUsers}`, {
    next: { revalidate: 10 },
  }).then((res) => res.json());
}

export async function UsersFetch() {
  return await FetchGetAllUsers();
}

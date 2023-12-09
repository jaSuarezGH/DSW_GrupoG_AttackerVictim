import { enlaceAPI } from "@/app/models/endpoint.model";

async function fetchGetUsers(endpoint, value) {
  // Revalidate significa que comprueba la data cada x segundos, y la actualiza de ser el caso
  const res = await fetch(`${enlaceAPI}${endpoint}${value}`, {
    method: "GET",
    next: { revalidate: 0 },
  });
  if(res.status == '400'){
    return null;
  }
  return await res.json();
}

export async function UsersFetch(endpoint, value = "") {
  return await fetchGetUsers(endpoint, value);
}

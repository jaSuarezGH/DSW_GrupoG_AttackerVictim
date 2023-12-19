import { enlaceAPI } from "@/app/models/endpoint.model";

async function fetchGetDeleteAPI(endpoint, value, method) {
  // Revalidate significa que comprueba la data cada x segundos, y la actualiza de ser el caso
  const res = await fetch(`${enlaceAPI}${endpoint}${value}`, {
    method: `${method}`,
    next: { revalidate: 0 },
  });
  const data = await res.json();

  return await data.response;
}

export async function fetchGetDelete(endpoint, value = "", method = "GET") {
  return await fetchGetDeleteAPI(endpoint, value, method);
}

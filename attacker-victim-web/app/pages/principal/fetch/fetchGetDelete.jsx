import { enlaceAPI } from "@/app/models/endpoint.model";
import { Routes } from "@/app/models/routes.model";

async function fetchGetDeleteAPI(endpoint, value, method) {
  // Revalidate significa que comprueba la data cada x segundos, y la actualiza de ser el caso
  try {
    const res = await fetch(`${enlaceAPI}${endpoint}${value}`, {
      method: `${method}`,
      next: { revalidate: 0 },
    });

    const data = await res.json();
    return await data.response;
  } catch (error) {
    // Maneja el error de forma adecuada según el entorno
    if (typeof window !== "undefined") {
      // Entorno del lado del servidor (navegador)
      window.location.href = Routes.FETCH_ERROR;
    } 
  }
}

export async function fetchGetDelete(endpoint, value = "", method = "GET") {
  return await fetchGetDeleteAPI(endpoint, value, method);
}

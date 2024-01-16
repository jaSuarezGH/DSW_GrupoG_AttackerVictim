import { enlaceAPI } from "@/app/models/endpoint.model";
import { Routes } from "@/app/models/routes.model";

async function fetchBody(endpoint, method, body) {
  // Revalidate significa que comprueba la data cada x segundos, y la actualiza de ser el caso
  try {
    const res = await fetch(`${enlaceAPI}${endpoint}`, {
      method: `${method}`,
      body: JSON.stringify(body),
      headers: {
        // Necesario cuando se debe realizar un POST para indicar que tipo de cuerpo es el enviado.
        "Content-Type": "application/json",
      },
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

export async function fetchPostPut(endpoint, method, body) {
  return await fetchBody(endpoint, method, body);
}

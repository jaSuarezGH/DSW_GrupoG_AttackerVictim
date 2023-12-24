import { enlaceAPI } from "@/app/models/endpoint.model";

async function fetchBody(endpoint, method, body) {
  // Revalidate significa que comprueba la data cada x segundos, y la actualiza de ser el caso
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
}

export async function fetchPostPut(endpoint, method, body) {
  return await fetchBody(endpoint, method, body);
}

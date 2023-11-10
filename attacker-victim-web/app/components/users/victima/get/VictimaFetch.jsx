'use client'

import { endGetVictimaByCedula, enlaceAPI } from "@/app/models/endpoint.model";


export const getVictima = (valor) => {
  return fetch(`${enlaceAPI}${endGetVictimaByCedula}${valor}`)
  .then((res) => res.json());
};

export async function VictimaFetch(valor) {
  const user = await getVictima(valor);
  return <div>{JSON.stringify(user)}</div>
}

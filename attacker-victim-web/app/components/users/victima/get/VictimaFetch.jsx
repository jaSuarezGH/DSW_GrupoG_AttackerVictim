'use client'

import { enlace, getVictimaByCedula } from "@/app/components/conexion/Enlace";

export const getVictima = (valor) => {
  return fetch(`${enlace}${getVictimaByCedula}${valor}`)
  .then((res) => res.json());
};

export async function VictimaFetch(valor) {
  const user = await getVictima(valor);
  return <div>{JSON.stringify(user)}</div>
}

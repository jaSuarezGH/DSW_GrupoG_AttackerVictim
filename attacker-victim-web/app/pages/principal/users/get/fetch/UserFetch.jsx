
import { enlaceAPI } from "@/app/models/endpoint.model";


export const getUser = async (value, endpoint) => {
  console.log(`${enlaceAPI}${endpoint}${value}`);
  const res = await fetch(`https://big-famous-raccoon.ngrok-free.app/testAPI/api/productos/cedula/27904275`);
  return await res.json();
};

export async function UserFetch({value, endpoint = ''}) {
  
  return await getUser(value, endpoint); 
}

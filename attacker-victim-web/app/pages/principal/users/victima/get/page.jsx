import {Navegacion} from '@/app/components/compartido/Navegacion';
import {ConsultarVictima} from '@/app/components/users/victima/get/ConsultarVictima'


export default async function getVictimaPage() {


  return <>
  <Navegacion number={1}></Navegacion>
  <ConsultarVictima></ConsultarVictima>
  
  </>
}

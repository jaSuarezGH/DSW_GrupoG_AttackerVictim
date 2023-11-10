import {ConsultarVictima} from '@/app/components/users/victima/get/ConsultarVictima'
import { Navigation } from '@/components/Navigation';


export default async function getVictimaPage() {


  return <>
  <Navigation number={1}></Navigation>
  <ConsultarVictima></ConsultarVictima>
  
  </>
}

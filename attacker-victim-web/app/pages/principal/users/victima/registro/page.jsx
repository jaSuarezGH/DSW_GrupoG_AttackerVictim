import { Navegacion } from "@/app/components/compartido/Navigation";
import { RegistrarVictima } from "@/app/components/users/victima/registro/RegistrarVictima";


export default function RegistrarVictimaPage() {

  return(
    <>
    <Navegacion number={1}></Navegacion>
    <RegistrarVictima></RegistrarVictima>
    </>
  )
}

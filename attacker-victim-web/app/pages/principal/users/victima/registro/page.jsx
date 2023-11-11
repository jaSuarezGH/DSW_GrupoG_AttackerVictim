import { Navegacion } from "@/app/components/compartido/Navegacion";
import { RegistrarVictima } from "@/app/components/users/victima/registro/RegistrarVictima";


export default function RegistrarVictimaPage() {

  return(
    <>
    <Navegacion number={1}></Navegacion>
    <RegistrarVictima></RegistrarVictima>
    </>
  )
}

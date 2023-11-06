import { Navegacion } from "@/app/components/compartido/Navegacion";
import { RegistrarAtacante } from "@/app/components/users/atacante/registro/RegistrarAtacante";


export default function RegistrarAtacantePage() {

  return(
    <>
    <Navegacion number={2}></Navegacion>
    <RegistrarAtacante></RegistrarAtacante>
    </>
  )
}
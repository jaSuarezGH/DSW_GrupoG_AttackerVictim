import { Navegacion } from "@/app/components/compartido/Navigation";
import { RegistrarAtacante } from "@/app/components/users/atacante/registro/RegistrarAtacante";


export default function RegistrarAtacantePage() {

  return(
    <>
    <Navegacion number={2}></Navegacion>
    <RegistrarAtacante></RegistrarAtacante>
    </>
  )
}

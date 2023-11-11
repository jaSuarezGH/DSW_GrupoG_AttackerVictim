import { Navegacion } from "@/app/components/compartido/Navegacion";
import {RegistrarRelacion} from '@/app/components/users/relacion/RegistrarRelacion'


export default function RegistrarRelacionPage() {

  return(
    <>
    <Navegacion number={3}></Navegacion>
    <RegistrarRelacion></RegistrarRelacion>
    </>
  )
}

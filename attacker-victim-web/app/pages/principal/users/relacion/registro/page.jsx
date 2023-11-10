import { Navegacion } from "@/app/components/compartido/Navigation";
import {RegistrarRelacion} from '@/app/components/users/relacion/RegistrarRelacion'


export default function RegistrarRelacionPage() {

  return(
    <>
    <Navegacion number={3}></Navegacion>
    <RegistrarRelacion></RegistrarRelacion>
    </>
  )
}

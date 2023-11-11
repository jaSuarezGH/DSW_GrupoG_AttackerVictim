import {Navegacion} from '@/app/components/compartido/Navegacion'
import {FuncionesPrincipal} from '@/app/components/principal/FuncionesPrincipal'

export default function PrincipalPage() {

  return (
    <>
      <Navegacion number={0}></Navegacion>
      <FuncionesPrincipal></FuncionesPrincipal>
    </>
  );
}
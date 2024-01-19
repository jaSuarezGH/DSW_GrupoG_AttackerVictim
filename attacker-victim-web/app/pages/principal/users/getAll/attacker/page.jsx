
import { fetchGetDelete } from '@/app/pages/principal/fetch/fetchGetDelete';
import { DivHeader } from '@/components/Div';
import { endGetAllAttackers } from '@/app/models/endpoint.model';
import { InformacionPage } from '@/components/InformationPage/InformationPage';
import { Routes } from '@/app/models/routes.model';
import { TablaAllVictimsAttackers } from '@/components/Table/VictimAttacker/TablaVictimAttacker';

export default async function getAllAttackersPage() {

    const users = await fetchGetDelete(endGetAllAttackers);

    if (users === null) return (
      <InformacionPage
        title="No hay Atacantes"
        description="Lo siento, no se encuentra ningun usuario de tipo Atacante registrado en el sistema."
        encabezado="Error 404"
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    );

  if (users === undefined) return (
    <InformacionPage
      title="Error de Conexion"
      description="Lo siento, la conexion ha fallado o el servidor no se encuentra disponible."
      encabezado="Error 404"
      link={Routes.PRINCIPAL}
      linkText="Volver al Inicio"
    ></InformacionPage>
  );

  return <>
  <div className="bg-white py-2 sm:py-10 ">
      <div className="mx-auto grid max-w-full gap-x-8 gap-y-12 px-6 lg:px-8 ">
        <DivHeader title='Usuarios Atacante en el Sistema' description='Usuarios de tipo Atacante registrados en el sistema.' tags={[3]}></DivHeader>
        
        <TablaAllVictimsAttackers users={users}></TablaAllVictimsAttackers>
        
      </div>
    </div>
  </>
}

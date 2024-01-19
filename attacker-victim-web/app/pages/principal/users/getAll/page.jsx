import { DivHeader } from "@/components/Div";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { endGetAllUsers } from "@/app/models/endpoint.model";
import { Suspense } from "react";
import { Loading } from "@/components/Loading/Loading";
import { TablaAllUsers } from "@/components/Table/AllUsers/TablaAllUsers";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";

export default async function UsersPage() {
  const users = await fetchGetDelete(endGetAllUsers);
  
  if (users === null) return (
    <InformacionPage
      title="No hay Usuarios"
      description="Lo siento, no se encuentra ningun usuario de tipo Victima o Atacante registrado en el sistema."
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

  return (
    <>
      <div className="bg-white py-2 sm:py-10 ">
        <div className="mx-auto grid max-w-full gap-x-8 gap-y-12 px-6 lg:px-8 ">
          <DivHeader
            title="Usuarios Victima/Atacante del Sistema"
            description="Usuarios de tipo Victima o Atacante registrados en el
            sistema."
            tags={[2, 3]}
          ></DivHeader>
          <Suspense fallback={<Loading />}>
            <TablaAllUsers users={users}></TablaAllUsers>
          </Suspense>
        </div>
      </div>
    </>
  );
}

import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { DivHeader } from "@/components/Div";
import { endGetAllAdmins } from "@/app/models/endpoint.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";
import { TablaAllAdmins } from "@/components/Table/Admin/TablaAllAdmins";

export default async function getAllAdminsPage() {
  const users = await fetchGetDelete(endGetAllAdmins);

  if (!users)
    return (
      <InformacionPage
        title="No hay Administradores"
        description="Lo siento, no se encuentra ningun usuario de tipo Administrador registrado en el sistema."
        encabezado="Error 404"
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    );

  if (users === undefined)
    return (
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
        <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-12 px-6 lg:px-8 ">
          <DivHeader
            title="Usuarios Administradores en el Sistema"
            description="Usuarios de tipo Adminstrador registrados en el sistema."
            tags={[1]}
          ></DivHeader>

          <TablaAllAdmins users={users}></TablaAllAdmins>
        </div>
      </div>
    </>
  );
}

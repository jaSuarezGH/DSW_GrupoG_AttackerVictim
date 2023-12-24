import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";

export default function ExitoAddAdminPage() {
  return (
    <>
      <InformacionPage
        title="Administrador Eliminado"
        encabezado="Completado"
        description="El usuario tipo Administrador se ha eliminado correctamente del sistema."
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    </>
  );
}

import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";

export default function ExitoUpdateAdminPage() {
  return (
    <>
      <InformacionPage
        title="Administrador Modificado"
        encabezado="Completado"
        description="El usuario tipo Administrador se ha modificado correctamente en el sistema."
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    </>
  );
}

import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";

export default function ExitoAddAdminPage() {
  return (
    <>
      <InformacionPage
        title="Administrador Registrado"
        encabezado="Completado"
        description="El usuario tipo Administrador se ha registrado correctamente en el sistema."
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    </>
  );
}

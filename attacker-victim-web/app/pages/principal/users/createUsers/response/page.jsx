import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Navigation } from "@/components/Navigation";

export default function ExitoPage() {
  return (
    <>
      <Navigation number={0}></Navigation>
      <InformacionPage
        title="Usuarios Registrados"
        encabezado="Completado"
        description="Los Usuarios ingresados y su respectiva relacion se registraron correctamente."
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    </>
  );
}
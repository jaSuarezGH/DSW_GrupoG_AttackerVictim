import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";

export default function ExitoUpdateResponsePage() {
  return (
    <>
      <InformacionPage
        title="Usuario Modificado"
        encabezado="Completado"
        description="El Usuario registrado en el sistema se ha modificado correctamente."
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    </>
  );
}

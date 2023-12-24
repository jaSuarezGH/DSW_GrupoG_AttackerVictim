import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";

export default function ExitoResponsePage() {
  return (
    <>
      <InformacionPage
        title="Usuario Eliminado"
        encabezado="Completado"
        description="El Usuario registrado en el sistema se ha eliminado correctamente junto a su usuario relacionado."
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    </>
  );
}

import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";

export default function ExitoPage() {
  return (
    <>
      <InformacionPage
        title="Zona Segura Eliminada"
        encabezado="Completado"
        description="La Zona Segura del usuario tipo Victima indicado se elimino correctamente."
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    </>
  );
}

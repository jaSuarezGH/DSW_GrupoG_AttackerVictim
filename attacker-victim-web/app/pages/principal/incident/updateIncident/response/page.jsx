import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";

export default function ExitoPage() {
  return (
    <>
      <InformacionPage
        title="Relacion Modificada"
        encabezado="Completado"
        description="La Relacion (incidente) del usuario indicado se modifico correctamente."
        link={Routes.PRINCIPAL}
        linkText="Volver al Inicio"
      ></InformacionPage>
    </>
  );
}

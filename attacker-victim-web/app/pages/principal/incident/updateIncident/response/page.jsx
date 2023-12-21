import { Routes } from "@/app/models/routes.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Navigation } from "@/components/Navigation";

export default function ExitoPage() {
  return (
    <>
      <Navigation number={0}></Navigation>
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

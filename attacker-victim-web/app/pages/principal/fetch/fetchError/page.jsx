import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";

export default function ErrorFetch() {
  return (
    <InformacionPage
      title="Error de Conexion"
      description="Lo siento, la conexion ha fallado o el servidor no se encuentra disponible."
      encabezado="Error 404"
      link={Routes.HOME}
      linkText="Volver al Inicio"
    ></InformacionPage>
  );
}

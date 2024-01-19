
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";

export default function NoFoundRoot() {
  return (
    <InformacionPage
      title="Dirección de Enlace Invalida"
      description="Lo siento, el enlace ingresado no es valido o no se encuentra disponible."
      encabezado="Error 404"
      link={Routes.HOME}
      linkText="Volver a Conectar"
    ></InformacionPage>
  );
}

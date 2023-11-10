"use client";

import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "./models";

export default function ErrorRoot() {
  return (
    <InformacionPage
      title="Pagina no encontrada"
      description="Lo siento, el enlace ingresado no es valido o no se encuentra disponible."
      encabezado="Error 404"
      link={Routes.HOME}
      linkText="Volver a Conectar"
    ></InformacionPage>
  );
}

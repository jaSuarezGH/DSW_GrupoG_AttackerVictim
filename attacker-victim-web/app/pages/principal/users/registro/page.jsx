"use client";

import { Routes } from "@/app/models/routes.model";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivHeader } from "@/components/Div";
import { DivForm } from "@/components/Div/DivForm/DivForm";
import { DivFormElement } from "@/components/Div/DivFormElement/DivFormElement";
import { DivSubHeader } from "@/components/Div/Header/DivSubHeader/DivSubHeader";
import { Navigation } from "@/components/Navigation";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function RegistrarVictimaPage() {
  const router = useRouter();

  const [isSubmitted, setIsSubmitted] = useState(false);

  const onSubmit = (e) => {
    e.preventDefault();
    if (!isSubmitted) {
      router.push(Routes.INF_REGISTER);
    }
    setIsSubmitted(true);
  };

  return (
    <>
      <Navigation></Navigation>

      <div className="mt-8 mx-auto grid gap-x-8 gap-y-12 px-6 lg:px-8">
        <DivHeader
          title="Registrar Usuarios"
          description="Ingrese los datos correspondientes de los usuarios a registrar, junto con las zonas seguras para dicha Victima y la relacion con el Atacante."
          tags={[2, 3]}
        ></DivHeader>
      </div>

      <form className="m-10 mb-6" onSubmit={onSubmit}>
        {/* DATOS DE LA VICTIMA */}
        <DivForm user="Victima"></DivForm>

        {/* DATOS DEL ATACANTE */}
        <DivForm user="Atacante"></DivForm>

        {/* DATOS DE LA RELACION VIC/ATA */}

        <div className="space-y-12 mt-10">
          <DivSubHeader
            title="Datos de la relacion entre la Victima y el Atacante"
            description="Ingrese los datos correspondiente de la relacion entre la Victima
            y el Atacante ingresados previamente."
          ></DivSubHeader>

          <div className="border-b border-gray-900/10 pb-12">
            <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
              <DivFormElement
                textLabel="Distancia de Alejamiento (en metros)"
                type="number"
                id="alejamiento"
                name="alejamiento"
                placeholder="Ingrese la distancia en metros de alejamiento minimo entre los usuarios aqui"
              ></DivFormElement>
            </div>

            {/* Agregar aqui el input y boton dinamico para crear las zonas seguras */}
          </div>
        </div>

        {/* Boton Submit */}
        <div className="mb-8 mt-12 flex items-center justify-end gap-x-6 pr-6">
          <div className="w-1/6">
            <ButtonSubmit
              text="Registrar"
              styles="px-3 py-3 text-lg"
            ></ButtonSubmit>
          </div>
        </div>
      </form>
    </>
  );
}

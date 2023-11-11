"use client";

import { Routes } from "@/app/models";
import { DivHeader } from "@/components/Div";
import { DivFormElement } from "@/components/Div/DivFormElement/DivFormElement";
import { DivSubHeader } from "@/components/Div/Header/DivSubHeader/DivSubHeader";
import { Navigation } from "@/components/Navigation";
import Link from "next/link";
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
      <Navigation number={1}></Navigation>

      <div className="mt-8 mx-auto grid gap-x-8 gap-y-12 px-6 lg:px-8">
        <DivHeader
          title="Registrar Usuarios"
          description="Ingrese los datos correspondientes de los usuarios a registrar, junto con las zonas seguras para dicha Victima y la relacion con el Atacante."
          tags={[2, 3]}
        ></DivHeader>
      </div>

      <form className="m-10 mb-6" onSubmit={onSubmit}>


        {/* DATOS DE LA VICTIMA */}

        <div className="space-y-12">
          <DivSubHeader
            title="Datos de la Victima"
            description="Ingrese los datos correspondiente al usuario tipo Victima."
          ></DivSubHeader>

          <div className="border-b border-gray-900/10 pb-12">
            <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
              <DivFormElement
                textLabel="Primer Nombre"
                type="text"
                name="primer-nombre"
                id="primer-nombre"
                placeholder="Ingrese el Nombre de la Victima aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Apellidos"
                type="text"
                name="apellido"
                id="apellido"
                placeholder="Ingrese los Apellidos de la Victima aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Nombre de Usuario (Username)"
                type="text"
                name="user"
                id="user"
                placeholder="Ingrese el usuario de la Victima aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Correo Electronico"
                type="email"
                name="email"
                id="email"
                placeholder="Ingrese el correo electronico (unico) de la Victima aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Cedula de Identidad"
                type="number"
                name="cedula"
                id="cedula"
                placeholder="Ingrese el numero de identifcacion ciudadana de la Victima aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Dirección de Bluetooth (MAC)"
                type="text"
                name="bluetooth"
                id="bluetooth"
                placeholder="Ingrese la direccion MAC del Bluetooth del dispositivo movil de la Victima aqui"
              ></DivFormElement>
            </div>
          </div>
        </div>

        {/* DATOS DEL ATACANTE */}
        <div className="space-y-12 mt-10">
          <DivSubHeader
            title="Datos del Atacante"
            description="Ingrese los datos correspondiente al usuario tipo Atacante.
            Relacionado con la Victima ingresada Previamente."
          ></DivSubHeader>

          <div className="border-b border-gray-900/10 pb-12">
            <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
              <DivFormElement
                textLabel="Primer Nombre"
                type="text"
                name="primer-nombre"
                id="primer-nombre"
                placeholder="Ingrese el Nombre del Atacante aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Apellidos"
                type="text"
                name="apellido"
                id="apellido"
                placeholder="Ingrese los Apellidos del Atacante aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Nombre de Usuario (Username)"
                type="text"
                name="user"
                id="user"
                placeholder="Ingrese el usuario del Atacante aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Correo Electronico"
                type="email"
                name="email"
                id="email"
                placeholder="Ingrese el correo electronico (unico) del Atacante aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Cedula de Identidad"
                type="number"
                name="cedula"
                id="cedula"
                placeholder="Ingrese el numero de identifcacion ciudadana del Atacante aqui"
              ></DivFormElement>

              <DivFormElement
                textLabel="Dirección de Bluetooth (MAC)"
                type="text"
                name="bluetooth"
                id="bluetooth"
                placeholder="Ingrese la direccion MAC del Bluetooth del dispositivo movil del Atacante aqui"
              ></DivFormElement>
            </div>
          </div>
        </div>

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

        <div className="mb-0 mt-6 flex items-center justify-end gap-x-6 mr-8 pb-0">
          <Link
            href={Routes.PRINCIPAL}
            className=" mb-0 text-sm font-semibold leading-6 text-gray-900 px-4 py-2 bg-slate-200 rounded-md mr-2"
          >
            Cancelar
          </Link>

          <button
            type="submit"
            className=" mb-0 rounded-md bg-indigo-600 px-7 py-3 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
          >
            Siguiente
          </button>
        </div>
      </form>
    </>
  );
}

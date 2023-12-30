"use client";

import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivHeader } from "@/components/Div";

import { useRouter } from "next/navigation";
import { useState } from "react";
import { Routes } from "@/app/models/routes.model";

export default function createSafeZonePage() {
  const [valor, setValor] = useState("");

  const router = useRouter();

  const onSubmit = (e) => {
    e.preventDefault();
  router.push(`${Routes.CREATE_ZS_EMAIL}${valor}`);
        
  };

  return (
    <>
      <div className="ring-1 ring-opacity-40 ring-zinc-300 rounded-xl shadow-md shadow-indigo-100 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto max-w-7xl gap-x-8 gap-y-12">
        <DivHeader
          title="Crear una Zona Segura a un Usuario Victima"
          description="Crear una Zona Segura para un usuario tipo Victima registrado en el sistema."
          tags={[2]}
        ></DivHeader>
        <div className="ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 mb-6 rounded-lg p-9 sm:mx-auto sm:w-full sm:max-w-sm">
          <form className="space-y-6 " onSubmit={onSubmit}>

            <div>
              <div className="flex items-center justify-between mt-4">
                <label className="block text-sm font-medium leading-6 text-gray-900">
                  Correo Electronico de la Victima (Email):
                </label>
              </div>
              <div className="mt-2">
                <input
                  id="valorConsulta"
                  name="valorConsulta"
                  type="text"
                  required
                  placeholder="Ingrese aqui el Correo Electronico (Email)"
                  onChange={(e) => {
                    setValor(e.target.value);
                  }}
                  className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                />
              </div>
            </div>

            <ButtonSubmit text="Buscar Usuario"></ButtonSubmit>
          </form>
        </div>
      </div>
    </>
  );
}

"use client";

import { useRouter } from "next/navigation";
import { useState } from "react";

export function RegistrarAtacante() {
  const router = useRouter();

  const [isSubmitted, setIsSubmitted] = useState(false);
  const [isCanceled, setIsCanceled] = useState(false);

  const onSubmit = (e) => {
    e.preventDefault();
    if (!isSubmitted) {
      router.push("/pages/principal/users/relacion/registro");
    }
    setIsSubmitted(true);
  };

  const onClick = (e) => {
    e.preventDefault();
    if (!isCanceled) {
      router.back();
    }
    setIsCanceled(true);
  };

  return (
    <form className="m-14 mt-4 mb-6" onSubmit={onSubmit}>
      <div className="space-y-12">
        <div className="border-b border-gray-900/10 pb-3 pt-2">
          <h2 className="text-base font-semibold leading-7 text-gray-900">
            Datos del Atacante
          </h2>
          <p className="mt-1 text-sm leading-6 text-gray-600">
            Ingrese los datos correspondiente al usuario tipo Atacante.
            Relacionado con la Victima ingresada Previamente.
          </p>
        </div>

        <div className="border-b border-gray-900/10 pb-12">
          <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
            <div className="sm:col-span-3">
              <label
                htmlFor="first-name"
                className="block text-sm font-medium leading-6 text-gray-900"
              >
                Primer Nombre
              </label>
              <div className="mt-2">
                <input
                  type="text"
                  name="primer-nombre"
                  id="primer-nombre"
                  autoComplete="given-name"
                  className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                />
              </div>
            </div>

            <div className="sm:col-span-3">
              <label
                htmlFor="last-name"
                className="block text-sm font-medium leading-6 text-gray-900"
              >
                Apellido
              </label>
              <div className="mt-2">
                <input
                  type="text"
                  name="apellido"
                  id="apellido"
                  autoComplete="family-name"
                  className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                />
              </div>
            </div>

            <div className=" sm:col-span-3">
              <label
                htmlFor="text"
                className="block text-sm font-medium leading-6 text-gray-900"
              >
                Nombre de Usuario
              </label>
              <div className="mt-2">
                <input
                  id="user"
                  name="user"
                  type="text"
                  autoComplete="text"
                  className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                />
              </div>
            </div>

            <div className=" sm:col-span-3">
              <label
                htmlFor="email"
                className="block text-sm font-medium leading-6 text-gray-900"
              >
                Correo Electronico
              </label>
              <div className="mt-2">
                <input
                  id="email"
                  name="email"
                  type="email"
                  autoComplete="email"
                  className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                />
              </div>
            </div>

            <div className="sm:col-span-3">
              <label
                htmlFor="cedula"
                className="block text-sm font-medium leading-6 text-gray-900"
              >
                Cedula de Identidad
              </label>
              <div className="mt-2">
                <input
                  id="cedula"
                  name="cedula"
                  type="number"
                  pattern="[0-9]{10}"
                  maxLength={"10"}
                  minLength={"6"}
                  autoComplete="cedula"
                  className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                />
              </div>
            </div>

            <div className="sm:col-span-2">
              <label
                htmlFor="bluetooth"
                className="block text-sm font-medium leading-6 text-gray-900"
              >
                Dirección de Bluetooth
              </label>
              <div className="mt-2">
                <input
                  type="text"
                  name="bluetooth"
                  id="bluetooth"
                  autoComplete="bluetooth"
                  className="block w-full rounded-md border-0 pt-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                />
              </div>
            </div>
          </div>
        </div>
      </div>

      <div className="mb-0 mt-6 flex items-center justify-end gap-x-6 mr-8 pb-0">
        <button
          type="button"
          onClick={onClick}
          className=" mb-0 text-sm font-semibold leading-6 text-gray-900 px-4 py-2 bg-slate-200 rounded-md mr-2"
        >
          Volver
        </button>

        <button
          type="onSubmit"
          className=" mb-0 rounded-md bg-indigo-600 px-7 py-3 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
        >
          Siguiente
        </button>
      </div>
    </form>
  );
}

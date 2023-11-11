"use client";

import { useRouter } from "next/navigation";
import { useState } from "react";

export function RegistrarRelacion() {
  const router = useRouter();

  const [isSubmitted, setIsSubmitted] = useState(false);
  const [isCanceled, setIsCanceled] = useState(false);

  const onSubmit = (e) => {
    e.preventDefault();
    if (!isSubmitted) {
      router.push("/pages/informacion/exitoRegistro");
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
            Datos de la relacion entre la Victima y el Atacante
          </h2>
          <p className="mt-1 text-sm leading-6 text-gray-600">
            Ingrese los datos correspondiente de la relacion entre la Victima y el Atacante ingresados previamente.
          </p>
        </div>

        <div className="border-b border-gray-900/10 pb-12 justify-center place-items-center">
          <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6 justify-center">

            <div className="sm:col-span-3 place-items-center justify-center">
              <label
                htmlFor="alejamiento"
                className="flex text-sm font-medium leading-6 text-gray-900"
              >
                Distancia de Alejamiento (en metros)
              </label>
              <div className="mt-2">
                <input
                  id="alejamiento"
                  name="alejamiento"
                  type="number"
                  pattern="[0-9]{10}"
                  autoComplete="alejamiento"
                  className=" justify-center flex w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
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

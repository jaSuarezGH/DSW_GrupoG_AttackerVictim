"use client";

import { useRouter } from "next/navigation";
import { useState } from "react";

export function RecuperarClave() {
  const [clave, setClave] = useState("");
  const [claveConfirm, setClaveConfirm] = useState("");

  const router = useRouter();

  return (
    <div className="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
      <div className="text-center sm:mx-auto sm:w-full sm:max-w-sm">
        <img className="mx-auto h-28 w-auto" src="/logo.png" alt="Logo" />
        <h2 className="text-center mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
          Recuperacion de Contraseña
        </h2>
        <p className="mt-6 text-sm leading-7 text-gray-600">
          Ingrese la nueva contraseña asociado al correo electronico previamente
          ingresado.
        </p>
      </div>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form className="space-y-6" action="#" method="POST">
          <div>
            <label
              htmlFor="password"
              className="block text-sm font-medium leading-6 text-gray-900"
            >
              Contraseña Nueva
            </label>
            <div className="mt-2">
              <input
                id="password"
                name="password"
                type="password"
                required
                onChange={(e) => {
                  setClave(e.target.value);
                }}
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

          <div>
            <div className="flex items-center justify-between">
              <label
                htmlFor="password"
                className="block text-sm font-medium leading-6 text-gray-900"
              >
                Confirme la Contraseña Nueva
              </label>
            </div>
            <div className="mt-2">
              <input
                id="password"
                name="password"
                type="password"
                required
                onChange={(e) => {
                  setClaveConfirm(e.target.value);
                }}
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

          <div>
            <button
              type="button"
              className="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
              onClick={() => {
                if (!(claveConfirm === "" || clave === "")) {
                  if (clave === claveConfirm) router.push("/pages/login");
                  else alert("Las claves no coinciden.");
                } else alert("Rellene todos los campos.");
              }}
            >
              Actualizar Clave
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

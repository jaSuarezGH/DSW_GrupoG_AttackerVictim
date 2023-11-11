"use client";

import { useRouter } from "next/navigation";
import { useState } from "react";

export function Login() {
  
  const [usuario, setUsuario] = useState("");
  const [clave, setClave] = useState("");
  const router = useRouter();

  const [isSubmitted, setIsSubmitted] = useState(false);

  const onSubmit = (e) => {
    if (!isSubmitted) {
      router.push("/pages/login/recuperarClave");
    }
    setIsSubmitted(true);
  };

  return (
    <div className="flex min-h-full flex-1 flex-col justify-center px-6 py-12 lg:px-8">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm">
        <img
          className="mx-auto h-28 w-auto"
          src="/logo.png"
          alt="Logo"
        />
        <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
          Inicia sesion en tu cuenta
        </h2>
      </div>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form className="space-y-6" action="#" method="POST">
          <div>
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
                required
                onChange={(e) => {
                    setUsuario(e.target.value);
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
                Contraseña
              </label>
              <div className="text-sm">
                <button
                type="button"
                  onClick={onSubmit}
                  className="font-semibold text-indigo-600 hover:text-indigo-500"
                >
                  ¿Olvidó su Contraseña?
                </button>
              </div>
            </div>
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
            <button
              type="button"
              className="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
              onClick={() => {
                if (!(usuario === "" || clave === "")) {
                  
                router.push("/pages/principal");
              }
                else alert("Rellene todos los campos.")

            }}
            >
              Iniciar Sesion
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}


"use client";

import { useRouter } from "next/navigation";
import { useState } from "react";

export function FuncionesPrincipal() {
  const router = useRouter();
  const [control, setControl] = useState(false);

  const onControlAllUsers = (e) => {
    if (!control) {
      router.push("/pages/principal/getAll");
    }
    setControl(true);
  };

  const onControlAllVictimas = (e) => {
    if (!control) {
      router.push("/pages/principal/users/victima/getAll");
    }
    setControl(true);
  };

  const onControlAllAtacantes = (e) => {
    if (!control) {
      router.push("/pages/principal/users/atacante/getAll");
    }
    setControl(true);
  };

  const onControlConsultarVictima = (e) => {
    if (!control) {
      router.push("/pages/principal/users/victima/get");
    }
    setControl(true);
  };


  const onControlConsultarAtacante = (e) => {
    if (!control) {
      router.push("/pages/principal/users/atacante/get");
    }
    setControl(true);
  };

  return (
    <>
    
    <header className="border-b-2 bg-white shadow">
          <div className="mx-auto max-w-full px-4 py-6 sm:px-6 lg:px-8">
                <h1 className="ml-4 text-3xl font-bold tracking-tight text-gray-900"> 
                  Inicio
                </h1>
          </div>
        </header>
    <section class="px-6 py-20 mx-auto max-w-8xl pt-10">
      <div class=" mx-4 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 gap-x-16 lg:gap-x-20 gap-y-18">
        
        {/* CONSULTAR TODOS LOS USUARIOS */}
        <button
          onClick={onControlAllUsers}
          className="text-left bg-zinc-50 text-gray-700 hover:text-blue-700 shadow-none hover:shadow-blue-200 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-blue-600 px-4 py-4 rounded-lg"
        >
          <span className="inline-flex items-center rounded-md bg-blue-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-blue-700 ring-1 ring-inset ring-blue-700/10">
            Administrador
          </span>
          <span className="inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>
          <span className="inline-flex items-center rounded-md bg-red-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">
            Atacante
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Consultar Usuarios
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Consultar a todos los usuarios registrados en el sistema.
          </p>
        </button>

        {/* HISTORIAL DE NOTIFICACIONES */}
        <button className="text-left bg-zinc-50 text-gray-700 hover:text-blue-700 shadow-none hover:shadow-blue-200 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-blue-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-blue-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-blue-700 ring-1 ring-inset ring-blue-700/10">
            Administrador
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Historial de Notificaciones
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Ver un historial de todas las distintas notificaciones o alertas
            recibidas.
          </p>
        </button>

        {/* CONSULTAR VICTIMAS */}
        <button
          onClick={onControlAllVictimas}
          className="text-left bg-zinc-50 text-gray-700 hover:text-green-700 shadow-none hover:shadow-green-200 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-green-600 px-4 py-4 rounded-lg"
        >
          <span className="inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Consultar Victimas
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Consultar a todos los usuarios de tipo "Victima" registrados en el
            sistema.
          </p>
        </button>

        {/* CONSULTAR ATACANTES */}
        <button
          onClick={onControlAllAtacantes}
          className="text-left bg-zinc-50 text-gray-700 hover:text-red-700 shadow-none hover:shadow-red-200 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-red-600 px-4 py-4 rounded-lg"
        >
          <span className="inline-flex items-center rounded-md bg-red-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">
            Atacante
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Consultar Atacantes
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Consultar a todos los usuarios de tipo "Atacante" registrados en el
            sistema.
          </p>
        </button>

        {/* CONSULTAR VICTIMA */}
        <button 
        onClick={onControlConsultarVictima}
        className="text-left bg-zinc-50 text-gray-700 hover:text-green-700 shadow-none hover:shadow-green-200 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-green-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Consultar una Victima
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Consultar a un usuario de tipo "Victima" registrado en el sistema.
          </p>
        </button>

        {/* CONSULTAR ATACANTE */}
        <button 
        onClick={onControlConsultarAtacante}
        className="text-left bg-zinc-50 text-gray-700 hover:text-red-700 shadow-none hover:shadow-red-200 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-red-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-red-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">
            Atacante
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Consultar un Atacante
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Consultar a un usuario de tipo "Atacante" registrado en el sistema.
          </p>
        </button>

        {/* Modificar Zonas Seguras de Victima. */}
        <button className="text-left bg-zinc-50 text-gray-700 hover:text-green-700 shadow-none hover:shadow-green-200 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-green-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Modificar Zonas Seguras de Victima
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Modificar las Zonas Seguras relacionadas a un usuario de tipo
            "Victima" registrado en el sistema.
          </p>
        </button>

        {/* Modificar Relación Victima/Atacante */}
        <button className="text-left bg-zinc-50 text-gray-700 hover:text-purple-700 shadow-none hover:shadow-purple-300 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-purple-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>
          <span className="inline-flex items-center rounded-md bg-red-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">
            Atacante
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Modificar Relación Victima/Atacante
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Modificar la relacion entre un usuario "Victima" y un usuario
            "Atacante".
          </p>
        </button>

        {/* Posicionamiento de Victima/Atacante */}
        <button className="text-left bg-zinc-50 text-gray-700 hover:text-purple-700 shadow-none hover:shadow-purple-300 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-purple-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>
          <span className="inline-flex items-center rounded-md bg-red-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">
            Atacante
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Posicionamiento de Victima/Atacante
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Consultar el ultimo posicionamiento de un usuario tipo "Victima" o
            un usuario "Atacante"
          </p>
        </button>

        {/* Crear Usuario Victima y Atacante */}
        <button className="text-left bg-zinc-50 text-gray-700 hover:text-purple-700 shadow-none hover:shadow-purple-300 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-purple-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>
          <span className="inline-flex items-center rounded-md bg-red-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">
            Atacante
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Crear Usuario Victima y Atacante
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Crear usuarios de tipo "Victima" y su respectivo usuario "Atacante"
            relacionado.
          </p>
        </button>

        {/* Modificar una Victima */}
        <button className="text-left bg-zinc-50 text-gray-700 hover:text-green-700 shadow-none hover:shadow-green-200 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-green-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Modificar una Victima
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Modificar a un usuario de tipo "Victima" registrado en el sistema.
          </p>
        </button>

        {/* Modificar un Atacante */}
        <button className="text-left bg-zinc-50 text-gray-700 hover:text-red-700 shadow-none hover:shadow-red-200 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-red-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-red-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">
            Atacante
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Modificar un Atacante
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Modificar a un usuario de tipo "Atacante" registrado en el sistema.
          </p>
        </button>

        {/* Eliminar Usuario Victima y Atacante */}
        <button className="text-left bg-zinc-50 text-gray-700 hover:text-purple-700 shadow-none hover:shadow-purple-300 hover:shadow-xl mb-12 ring-2 ring-inset ring-slate-600 hover:ring-purple-600 px-4 py-4 rounded-lg">
          <span className="inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>
          <span className="inline-flex items-center rounded-md bg-red-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">
            Atacante
          </span>

          <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">
            Eliminar Usuario Victima y Atacante
          </h3>
          <p class=" text-left text-sm text-gray-600">
            Eliminar un usuario de tipo "Victima" y su respectivo usuario
            "Atacante" relacionado.
          </p>
        </button>

      </div>
    </section>
    </>
  );
}

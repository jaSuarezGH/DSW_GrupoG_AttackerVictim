"use client";

import { Fragment, useState } from "react";
import { Listbox, Transition } from "@headlessui/react";
import { CheckIcon, ChevronUpDownIcon } from "@heroicons/react/20/solid";

import { useRouter } from "next/navigation";

import {VictimaFetch} from '@/app/components/users/victima/get/VictimaFetch'

const opcion = [
  "Username",
  "Correo Electronico",
  "Cedula de Identidad",
];

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}

function ConvertirUsuario(user){
  return {
    'nombres': user.nombres,
    'apellidos': user.apellidos,
    'cedula': user.cedula,
  }
}



export function ConsultarVictima() {

  const [selected, setSelected] = useState(opcion[0]);
  const [valor, setValor]= useState("");

  const router = useRouter();

  const onSubmit = (e) => {
    e.preventDefault();
    
    const usuario = VictimaFetch(valor);
    /* const victima = ConvertirUsuario(usuario);
    router.push(`/pages/principal/users/victima/get/response/`); */
  };


  return (
    <div className="ring-1 ring-opacity-30 ring-zinc-300 rounded-xl shadow-md shadow-indigo-100 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto max-w-7xl gap-x-8 gap-y-12">
      <div className="block max-w-full mt-3">
        <span className=" items-center rounded-md bg-green-50 px-2 py-1 ml-2 mr-2 font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
          Victima
        </span>
        <h2 className="mt-3 text-3xl font-bold tracking-tight text-gray-900">
          Consultar Victima
        </h2>
        <p className="mt-4 mb-2 text-lg leading-8 text-gray-600 block">
          Consulta un usuario de tipo Victima registrado en el sistema.
        </p>
      </div>
      <div className=" ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 mb-6 rounded-lg p-9 sm:mx-auto sm:w-full sm:max-w-sm">
        <form
          className="space-y-6 "
          action="#"
          method="POST"
          onSubmit={onSubmit}
        >
          <Listbox value={selected} onChange={setSelected}>
            {({ open }) => (
              <div>
                <Listbox.Label className="text-sm font-medium leading-6 text-gray-900">
                  Buscar por:
                </Listbox.Label>
                <div className="relative mt-2">
                  <Listbox.Button className="mb-2 relative cursor-default rounded-md bg-white py-1.5 pl-3 pr-10 text-left text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:outline-none focus:ring-2 focus:ring-indigo-500 sm:text-sm sm:leading-6">
                    <span className="flex items-center">
                      <span className="ml-3 block truncate">{selected}</span>
                    </span>

                    {/* Flechas de Arriba/Abajo */}
                    <span className="pointer-events-none absolute inset-y-0 right-0 ml-3 flex items-center pr-2">
                      <ChevronUpDownIcon
                        className="h-5 w-5 text-gray-400"
                        aria-hidden="true"
                      />
                    </span>
                  </Listbox.Button>

                  <Transition
                    show={open}
                    as={Fragment}
                    leave="transition ease-in duration-100"
                    leaveFrom="opacity-100"
                    leaveTo="opacity-0"
                  >
                    <Listbox.Options className="absolute z-10 mt-1 max-h-56 overflow-auto rounded-md bg-white py-1 text-lg shadow-lg ring-2 ring-black ring-opacity-5 focus:outline-none sm:text-sm shadow-indigo-400">
                      {opcion.map((opcion) => (
                        <Listbox.Option
                          key={opcion}
                          className={({ active }) =>
                            classNames(
                              active
                                ? "bg-indigo-600 text-white"
                                : "text-gray-900",
                              "relative cursor-default select-none py-3 pl-3 pr-12"
                            )
                          }
                          value={opcion}
                        >
                          {({ selected, active }) => (
                            <>
                              <div className="flex items-center">
                                <span
                                  className={classNames(
                                    selected ? "font-semibold" : "font-normal",
                                    "ml-3 block truncate"
                                  )}
                                >
                                  {opcion}
                                </span>
                              </div>

                              {selected ? (
                                <span
                                  className={classNames(
                                    active ? "text-white" : "text-indigo-600",
                                    "absolute inset-y-0 right-0 flex items-center pr-4"
                                  )}
                                >
                                  <CheckIcon
                                    className="h-5 w-5"
                                    aria-hidden="true"
                                  />
                                </span>
                              ) : null}
                            </>
                          )}
                        </Listbox.Option>
                      ))}
                    </Listbox.Options>
                  </Transition>
                </div>
              </div>
            )}
          </Listbox>

          <div>
            <div className="flex items-center justify-between mt-4">
              <label className="block text-sm font-medium leading-6 text-gray-900">
                Valor del Identificador:
              </label>
            </div>
            <div className="mt-2">
              <input
                id="valorConsulta"
                name="valorConsulta"
                type="text"
                required
                placeholder="Ingrese aqui el valor del identificador"
                onChange={(e) => {
                  setValor(e.target.value);
              }}
                className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
              />
            </div>
          </div>

          <div>
            <button
              type="submit"
              className="flex w-full justify-center rounded-md bg-indigo-600 mt-12 px-3 py-2 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
            >
              Buscar Victima
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

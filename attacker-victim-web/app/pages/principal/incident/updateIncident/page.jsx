"use client";

import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivHeader } from "@/components/Div";
import { ListBoxGet } from "@/components/ListBoxGet/ListBoxGet";

import { useRouter } from "next/navigation";
import { useState } from "react";
import { Routes } from "@/app/models/routes.model";
import { optionsConsultIncident } from "../models/optionsConsultIncident";

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}

export default function getIncidentPage() {
  const [selected, setSelected] = useState(optionsConsultIncident[0]);
  const [valor, setValor] = useState("");

  const router = useRouter();

  const onSubmit = (e) => {
    e.preventDefault();

    switch (selected) {
      case "Correo Electronico de la Victima":
        router.push(`${Routes.UPDATE_RELATION_VICTIM}${valor}`);
        break;

      case "Correo Electronico del Atacante":
        router.push(`${Routes.UPDATE_RELATION_ATTACKER}${valor}`);
        break;
    }
  };

  return (
    <>
      <div className="ring-1 ring-opacity-40 ring-zinc-300 rounded-xl shadow-md shadow-indigo-100 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto max-w-7xl gap-x-8 gap-y-12">
        <DivHeader
          title="Consultar la Relacion entre Victima/Atacante"
          description="Consultar la relacion registrada en el sistema entre un usuario Victima y Atacante."
          tags={[2, 3]}
        ></DivHeader>
        <div className="ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 mb-6 rounded-lg p-9 sm:mx-auto sm:w-full sm:max-w-sm">
          <form className="space-y-6 " onSubmit={onSubmit}>
            <ListBoxGet
              selected={selected}
              onChange={setSelected}
              options={optionsConsultIncident}
              classNames={classNames}
            ></ListBoxGet>

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

            <ButtonSubmit text="Buscar Usuario"></ButtonSubmit>
          </form>
        </div>
      </div>
    </>
  );
}

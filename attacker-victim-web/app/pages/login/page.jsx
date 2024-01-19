"use client";

import { Routes } from "@/app/models/routes.model";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivImageHeader } from "@/components/Div/Header/DivImageHeader/DivImageHeader";
import { Input } from "@/components/Input/Input";
import { Label } from "@/components/Label/Label";
import { useRouter } from "next/navigation";
import { useState } from "react";
import { endPostAuthAdmin } from "@/app/models/endpoint.model";
import { fetchPostPut } from "../principal/fetch/fetchPostPut/fetchPostPut";
import { AlertInformation } from "@/components/Alert/AlertInformation";
import { AlertError } from "@/components/Alert/AlertError";
import Link from "next/link";

export default function LoginPage() {
  const [username, setUsername] = useState("");
  const [clave, setClave] = useState("");

  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");

  const [alertInfo, setAlertInfo] = useState(false);
  const [descriptionInfo, setDescriptionInfo] = useState("");

  const router = useRouter();

  const onSubmit = async (e) => {
    e.preventDefault();
    const admin = await fetchPostPut(endPostAuthAdmin, "POST", {
      _username: username,
      _password: clave,
    });
    if (admin) {
      setErrorInfo(false);
      setDescriptionInfo("Inciando sesion ....");
      setAlertInfo(true);
      router.push("/pages/principal");
    } else {
      setDescriptionError(
        "El Username o contraseña es invalido, intente nuevamente."
      );
      setErrorInfo(true);
    }
  };

  return (
    <div className="px-6 pb-8 pt-2 mt-10 mb-6 ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 rounded-lg sm:mx-auto sm:w-full sm:max-w-md">
      <DivImageHeader title="Inicia sesion en tu cuenta"></DivImageHeader>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form className="space-y-6" onSubmit={onSubmit}>
          <div>
            <Label text="Nombre de Usuario"></Label>
            <div className="mt-2 mb-6">
              <Input
                id="username"
                name="username"
                type="text"
                placeholder="Ingresa tu nombre de usuario (Username) aqui"
                value={username}
                onChange={(e) => {
                  setUsername(e.target.value);
                }}
              ></Input>
            </div>
          </div>

          <div>
            <div className="flex items-center justify-between">
              <Label text="Contraseña"></Label>
              <div className="text-sm">
                <Link
                  href={Routes.FORGOT_PASS}
                  className="font-semibold text-indigo-600 hover:text-indigo-500"
                >
                  ¿Olvidó su Contraseña?
                </Link>
              </div>
            </div>
            <div className="mt-2 mb-10">
              <Input
                id="password"
                name="password"
                type="password"
                placeholder="Ingresa tu contraseña aqui"
                value={clave}
                onChange={(e) => {
                  setClave(e.target.value);
                }}
              ></Input>
            </div>
          </div>

          <div>
            <ButtonSubmit text="Iniciar Sesion"></ButtonSubmit>
          </div>
          {errorInfo && (
            <div className="mt-8">
              <AlertError description={descriptionError}></AlertError>
            </div>
          )}
          {alertInfo && (
            <div className="mt-8">
              <AlertInformation
                description={descriptionInfo}
              ></AlertInformation>
            </div>
          )}
        </form>
      </div>
    </div>
  );
}

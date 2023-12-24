"use client";

import { Routes } from "@/app/models/routes.model";
import AlertError from "@/components/Alert/AlertError";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivImageHeader } from "@/components/Div/Header/DivImageHeader/DivImageHeader";
import { Input } from "@/components/Input/Input";
import { Label } from "@/components/Label/Label";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { useState } from "react";
import { fetchGetDelete } from "../principal/fetch/fetchGetDelete";
import { endGetAdminByEmail } from "@/app/models/endpoint.model";
import AlertInformation from "@/components/Alert/AlertInformation";

export default function LoginPage() {
  const [email, setEmail] = useState("");
  const [clave, setClave] = useState("");

  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");
  
  const [alertInfo, setAlertInfo] = useState(false);
  const [descriptionInfo, setDescriptionInfo] = useState("");

  
  

  const router = useRouter();


  const onSubmit = async (e) => {
    e.preventDefault();
    const admin = await fetchGetDelete(endGetAdminByEmail, email);

    if (admin) {
      if (admin._password == clave){
        setErrorInfo(false);
        setDescriptionInfo("Inciando sesion ....");
        setAlertInfo(true);
        router.push("/pages/principal");
      } else {
        setAlertInfo(false);
        setDescriptionError(
          "La Contraseña es invalida, intente nuevamente."
        );
        setErrorInfo(true);
      }
      
    } else {
      setDescriptionError(
        "El Correo Electronico es invalido, intente nuevamente."
      );
      setErrorInfo(true);
    }
  }

  return (
    <div className="px-6 pb-8 pt-2 mt-10 mb-6 ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 rounded-lg sm:mx-auto sm:w-full sm:max-w-md">
      <DivImageHeader
        title="Inicia sesion en tu cuenta"
      ></DivImageHeader>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form className="space-y-6" method="POST"
        onSubmit={onSubmit}
        >
          <div>
            <Label text="Correo Electronico"></Label>
            <div className="mt-2 mb-6">
              <Input
                id="email"
                name="email"
                type="email"
                placeholder="Ingresa tu correo electronico aqui"
                value={email}
                onChange={(e) => {
                  setEmail(e.target.value);
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
                placeholder="Ingresa tu clave aqui"
                value={clave}
                onChange={(e) => {
                  setClave(e.target.value);
                }}
              ></Input>
            </div>
          </div>
          
          <div>
            <ButtonSubmit text='Iniciar Sesion'></ButtonSubmit>
          </div>
          {errorInfo && (
          <div className="mt-8">
            <AlertError description={descriptionError}></AlertError>
          </div>
        )}
          {alertInfo && (
          <div className="mt-8">
            <AlertInformation description={descriptionInfo}></AlertInformation>
          </div>
        )}
        
        </form>
      </div>
    </div>
  );
}

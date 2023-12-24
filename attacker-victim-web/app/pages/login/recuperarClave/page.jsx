"use client";

import AlertConfirm from "@/components/Alert/AlertConfirm";
import AlertError from "@/components/Alert/AlertError";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivImageHeader } from "@/components/Div/Header/DivImageHeader/DivImageHeader";
import { Input } from "@/components/Input/Input";
import { Label } from "@/components/Label/Label";
import { useRouter } from "next/navigation";
import { useState } from "react";
import { fetchGetDelete } from "../../principal/fetch/fetchGetDelete";
import { endGetAdminByEmail } from "@/app/models/endpoint.model";

export default function RecuperarClavePage() {
  const [email, setEmail] = useState("");
  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");
  const [claveInfo, setClaveInfo] = useState(false);
  const [descriptionClave, setDescriptionClave] = useState("");

  const router = useRouter();

  const onSubmit = async (e) => {
    e.preventDefault();

    const emailUser = await fetchGetDelete(endGetAdminByEmail, email);
    if (emailUser) {
      setErrorInfo(false);
      setClaveInfo(true);
      setDescriptionClave(`SU CLAVE ES: ${emailUser._password}`);
    } else {
      setClaveInfo(false);
      setDescriptionError(
        "El Correo Electronico es invalido, intente nuevamente."
      );
      setErrorInfo(true);
    }
  };

  return (
    <div className="px-6 pb-8 pt-2 mt-16 ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 rounded-lg sm:mx-auto sm:w-full sm:max-w-md">
      <DivImageHeader
        title="Recuperacion de Contraseña"
        description="Ingrese el Correo Electronico (Email) de su Cuenta."
      ></DivImageHeader>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form className="space-y-6" method="POST" onSubmit={onSubmit}>
          <div className="mb-12">
            <Label text="Correo Electronico"></Label>
            <div className="mt-2">
              <Input
                id="email"
                name="email"
                placeholder="Ingrese el correo Electronico aqui"
                type="email"
                value={email}
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
              ></Input>
            </div>
          </div>
          {errorInfo && (
            <div className="mt-8">
              <AlertError description={descriptionError}></AlertError>
            </div>
          )}
          {claveInfo && (
            <div className="mt-8">
              <AlertConfirm description={descriptionClave}></AlertConfirm>
            </div>
          )}
          <div>
            <ButtonSubmit text="Obtener Contraseña"></ButtonSubmit>
          </div>
        </form>
      </div>
    </div>
  );
}

"use client";

import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivImageHeader } from "@/components/Div/Header/DivImageHeader/DivImageHeader";
import { Input } from "@/components/Input/Input";
import { Label } from "@/components/Label/Label";
import { useState } from "react";
import { fetchGetDelete } from "../../principal/fetch/fetchGetDelete";
import { endGetAdminByUsername } from "@/app/models/endpoint.model";
import { AlertConfirm } from "@/components/Alert/AlertConfirm";
import { AlertError } from "@/components/Alert/AlertError";

export default function RecuperarClavePage() {
  const [username, setUsername] = useState("");
  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");
  const [claveInfo, setClaveInfo] = useState(false);
  const [descriptionClave, setDescriptionClave] = useState("");


  const onSubmit = async (e) => {
    e.preventDefault();

    const emailUser = await fetchGetDelete(endGetAdminByUsername, username);
    if (emailUser) {
      setErrorInfo(false);
      setClaveInfo(true);
      setDescriptionClave(`SU CLAVE ES: ${emailUser._password}`);
    } else {
      setClaveInfo(false);
      setDescriptionError(
        "El Username es invalido, intente nuevamente."
      );
      setErrorInfo(true);
    }
  };

  return (
    <div className="px-6 pb-8 pt-2 mt-10 mb-6 ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 rounded-lg sm:mx-auto sm:w-full sm:max-w-md">
      <DivImageHeader
        title="Recuperacion de Contraseña"
        description="Ingrese el Nombre de Usuario (Username) de su Cuenta."
      ></DivImageHeader>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form className="space-y-6" onSubmit={onSubmit}>
          <div className="mb-8">
            <Label text="Nombre de Usuario"></Label>
            <div className="mt-2">
              <Input
                id="username"
                name="username"
                placeholder="Ingrese el Username aqui"
                type="text"
                value={username}
                onChange={(e) => {
                  setUsername(e.target.value);
                }}
              ></Input>
            </div>
          </div>
          {errorInfo && (
              <AlertError description={descriptionError}></AlertError>
          )}
          {claveInfo && (
              <AlertConfirm description={descriptionClave}></AlertConfirm>
          )}
          <div>
            <ButtonSubmit text="Obtener Contraseña"></ButtonSubmit>
          </div>
        </form>
      </div>
    </div>
  );
}

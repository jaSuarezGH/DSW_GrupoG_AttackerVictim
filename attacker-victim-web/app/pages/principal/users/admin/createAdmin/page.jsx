"use client";

import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivHeader } from "@/components/Div";
import { DivFormElement } from "@/components/Div/DivFormElement/DivFormElement";
import { useRouter } from "next/navigation";
import { useState } from "react";
import {
  endAddAdmin,
  endGetAdminByEmail,
  endGetAdminByUsername,
} from "@/app/models/endpoint.model";
import { fetchPostPut } from "../../../fetch/fetchPostPut/fetchPostPut";
import { fetchGetDelete } from "../../../fetch/fetchGetDelete";
import { AlertError } from "@/components/Alert/AlertError";

export default function RegistrarAdminPage() {
  const router = useRouter();

  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");

  const [usernameAdmin, setUsernameAdmin] = useState("");
  const [emailAdmin, setEmailAdmin] = useState("");
  const [passwordAdmin, setPasswordAdmin] = useState("");
  const [passwordConfirmAdmin, setPasswordConfirmAdmin] = useState("");

  const onSubmit = async (e) => {
    e.preventDefault();
    if (passwordAdmin == passwordConfirmAdmin) {
      if (!(await fetchGetDelete(endGetAdminByEmail, emailAdmin))) {
        if (!(await fetchGetDelete(endGetAdminByUsername, usernameAdmin))) {
          const dataAdmin = {
            _username: usernameAdmin,
            _email: emailAdmin,
            _password: passwordAdmin,
          };
          const aggAdmin = await fetchPostPut(endAddAdmin, "POST", dataAdmin);
          if (aggAdmin != null) {
            setErrorInfo(false);
            router.push("/pages/principal/users/admin/createAdmin/response");
          } else {
            setDescriptionError(
              "Ha ocurrido un error inesperado al momento de registrar al Administrador en el sistema, por favor intente nuevamente mas tarde."
            );
            setErrorInfo(true);
          }
        } else {
          setDescriptionError(
            "El Nombre de Usuario (Username) del Administrador ya se encuentra registrado, ingrese otro valido."
          );
          setErrorInfo(true);
        }
      } else {
        setDescriptionError(
          "La Direccion de Correo Electronico (Email) del Administrador ya se encuentra registrado, ingrese otro valido."
        );
        setErrorInfo(true);
      }
    } else {
      setDescriptionError(
        "La Contraseña del Administrador no es igual que la ingresada en el campo de confirmacion de contraseña."
      );
      setErrorInfo(true);
    }
  };

  return (
    <>
      <div className="mt-8 mx-auto grid gap-x-8 gap-y-12 px-6 lg:px-8">
        <DivHeader
          title="Registrar Administrador"
          description="Ingrese los datos correspondientes del Administrador a registrar en el sistema."
          tags={[1]}
        ></DivHeader>
      </div>

      <form className="m-10 mb-6" onSubmit={onSubmit}>
        {/* DATOS DEL ADMIN */}
        <div className="space-y-12 mt-10">

          <div className="border-b border-gray-900/10 pb-12">
            <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
              <DivFormElement
                textLabel="Correo Electronico (Email)"
                type="email"
                id="email"
                name="email"
                placeholder="Ingrese la direccion de Correo Electronico (Email) aqui"
                value={emailAdmin}
                onChange={(e) => {
                  setEmailAdmin(e.target.value);
                }}
              ></DivFormElement>
              <DivFormElement
                textLabel="Nombre de Usuario (Username)"
                type="text"
                id="text"
                name="text"
                placeholder="Ingrese el Nombre de Usuario (Username) aqui"
                value={usernameAdmin}
                onChange={(e) => {
                  setUsernameAdmin(e.target.value);
                }}
              ></DivFormElement>
            </div>
          </div>
          <div className="border-b border-gray-900/10 pb-12">
            <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
              <DivFormElement
                textLabel="Contraseña"
                type="password"
                id="password"
                name="password"
                placeholder="Ingrese la Contraseña del Administrador aqui"
                value={passwordAdmin}
                onChange={(e) => {
                  setPasswordAdmin(e.target.value);
                }}
              ></DivFormElement>
              <DivFormElement
                textLabel="Confirmar Contraseña"
                type="password"
                id="passwordConfirm"
                name="passwordConfirm"
                placeholder="Ingrese nuevamente la Contraseña aqui"
                value={passwordConfirmAdmin}
                onChange={(e) => {
                  setPasswordConfirmAdmin(e.target.value);
                }}
              ></DivFormElement>
            </div>
          </div>
        </div>

        {errorInfo && (
          <div className="mt-8">
            <AlertError description={descriptionError}></AlertError>
          </div>
        )}

        {/* Boton Submit */}
        <div className="mb-8 mt-12 flex items-center justify-end gap-x-6 pr-6">
          <div className="w-1/6">
            <ButtonSubmit
              text="Crear Administrador"
              styles="px-3 py-3 text-lg"
            ></ButtonSubmit>
          </div>
        </div>
      </form>
    </>
  );
}

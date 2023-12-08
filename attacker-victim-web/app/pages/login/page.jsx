"use client";

import { Routes } from "@/app/models/routes.model";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivImageHeader } from "@/components/Div/Header/DivImageHeader/DivImageHeader";
import { Input } from "@/components/Input/Input";
import { Label } from "@/components/Label/Label";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function LoginPage() {
  const [usuario, setUsuario] = useState("");
  const [clave, setClave] = useState("");
  const router = useRouter();


  return (
    <div className="px-6 pb-8 pt-2 mt-16 ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 rounded-lg sm:mx-auto sm:w-full sm:max-w-md">
      <DivImageHeader
        title="Inicia sesion en tu cuenta"
      ></DivImageHeader>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form className="space-y-6" method="POST"
        onSubmit={() => {
          if (!(usuario === "" || clave === "")) {
            router.push("/pages/principal");
          } else alert("Rellene todos los campos.");
        }}
        >
          <div>
            <Label text="Correo Electronico"></Label>
            <div className="mt-2 mb-6">
              <Input
                id="email"
                name="email"
                type="email"
                placeholder="Ingresa tu correo electronico aqui"
                onChange={(e) => {
                  setUsuario(e.target.value);
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
                onChange={(e) => {
                  setClave(e.target.value);
                }}
              ></Input>
            </div>
          </div>

          <div>
            <ButtonSubmit text='Iniciar Sesion'></ButtonSubmit>
            
          </div>
        </form>
      </div>
    </div>
  );
}

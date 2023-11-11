"use client";

import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivImageHeader } from "@/components/Div/Header/DivImageHeader/DivImageHeader";
import { Input } from "@/components/Input/Input";
import { Label } from "@/components/Label/Label";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function RecuperarClavePage() {
  const [clave, setClave] = useState("");
  const [claveConfirm, setClaveConfirm] = useState("");

  const router = useRouter();

  return (
    <div className="px-6 pb-8 pt-2 mt-16 ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 rounded-lg sm:mx-auto sm:w-full sm:max-w-md">
      <DivImageHeader
        title="Recuperacion de Contraseña"
        description="Ingrese la nueva contraseña asociado al correo electronico previamente
          ingresado."
      ></DivImageHeader>

      <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <form
          className="space-y-6"
          method="POST"
          onSubmit={() => {
            if (!(claveConfirm === "" || clave === "")) {
              if (clave === claveConfirm) router.push("/pages/login");
              else alert("Las claves no coinciden.");
            } else alert("Rellene todos los campos.");
          }}
        >
          <div>
            <Label text="Contraseña Nueva"></Label>
            <div className="mt-2">
              <Input
                id="password"
                name="password"
                placeholder="Ingrese la nueva contraseña aqui"
                type="password"
                onChange={(e) => {
                  setClave(e.target.value);
                }}
              ></Input>
            </div>
          </div>

          <div>
            <div className="flex items-center justify-between">
              <Label text="Confirme la Contraseña Nueva"></Label>
            </div>
            <div className="mt-2">
              <Input
                id="password"
                name="password"
                placeholder="Confirme la nueva contraseña aqui"
                type="password"
                onChange={(e) => {
                  setClaveConfirm(e.target.value);
                }}
              ></Input>
            </div>
          </div>

          <div>
            <ButtonSubmit text="Actualizar Clave"></ButtonSubmit>
          </div>
        </form>
      </div>
    </div>
  );
}

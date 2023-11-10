"use client";

import "@/tailwind.config";
import { useRouter } from "next/navigation";
import { useState } from "react";
import { Label } from "@/components/Llabel/Label";
import { Input } from "@/components/Input/Input";
import { DivImageHeader } from "@/components/Div/Header/DivImageHeader/DivImageHeader";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { setEnlace } from "./models/endpoint.model";


export default function RootPage() {
  const [url, setUrl] = useState("");
  const router = useRouter();

  return (
    <>
      <div className="px-6 pb-8 pt-2 mt-20 ring-1 ring-opacity-70 ring-zinc-300 shadow-lg shadow-indigo-300 rounded-lg sm:mx-auto sm:w-full sm:max-w-md">
        <DivImageHeader
          title="Ingresa la direccion del Servidor"
        ></DivImageHeader>

        <div className="mt-10  sm:mx-auto sm:w-full sm:max-w-sm">
          <form
            className="space-y-6"
            method="POST"
            onSubmit={(evento) => {
              evento.preventDefault();
              fetch(url)
                .then((response) => {
                  if (response.ok) {
                    setEnlace(url);
                    alert("Conexión Exitosa");
                    router.push("pages/login");
                  }
                })
                .catch((error) => {
                  if (error.message === "Failed to fetch")
                    router.push("pages/informacion/errorConexion");
                });
            }}
          >
            <div>
              <Label text="URL del Servidor"></Label>

              <div className="mt-2 mb-12">
                <Input
                  id="url"
                  name="url"
                  type="url"
                  placeholder="http://ejemplo.com"
                  onChange={(evento) => setUrl(evento.target.value)}
                ></Input>
              </div>
            </div>

              <ButtonSubmit text="Conectar"></ButtonSubmit>
              
          </form>
        </div>
      </div>
    </>
  );
}

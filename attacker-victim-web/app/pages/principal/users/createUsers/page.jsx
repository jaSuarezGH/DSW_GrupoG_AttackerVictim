"use client";

import { Routes } from "@/app/models/routes.model";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivHeader } from "@/components/Div";
import { DivForm } from "@/components/Div/DivForm/DivForm";
import { DivFormElement } from "@/components/Div/DivFormElement/DivFormElement";
import { DivSubHeader } from "@/components/Div/Header/DivSubHeader/DivSubHeader";
import { Navigation } from "@/components/Navigation";
import { data } from "autoprefixer";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function RegistrarVictimaPage() {
  const router = useRouter();

  const [nombreVictima, setNombreVictima] = useState("");
  const [apellidoVictima, setApellidoVictima] = useState("");
  const [usernameVictima, setUsernameVictima] = useState("");
  const [cedulaVictima, setcedulaVictima] = useState(0);
  const [emailVictima, setEmailVictima] = useState("");
  const [macVictima, setMacVictima] = useState("");
  const [passwordVictima, setPasswordVictima] = useState("");
  const [passwordConfirmVictima, setPasswordConfirmVictima] = useState("");

  const [nombreAtacante, setNombreAtacante] = useState("");
  const [apellidoAtacante, setApellidoAtacante] = useState("");
  const [usernameAtacante, setUsernameAtacante] = useState("");
  const [cedulaAtacante, setcedulaAtacante] = useState(0);
  const [emailAtacante, setEmailAtacante] = useState("");
  const [macAtacante, setMacAtacante] = useState("");
  const [passwordAtacante, setPasswordAtacante] = useState("");
  const [passwordConfirmAtacante, setPasswordConfirmAtacante] = useState("");


  const [distanciaAlejamiento, setDistanciaAlejamiento] = useState(0);


  const onSubmit = (e) => {
    e.preventDefault();

    const dataVictim = {
      "_firstname": nombreVictima,
      "_lastname": apellidoVictima,
      "_username": usernameVictima,
      "_personal_id": cedulaVictima,
      "_email": emailVictima,
      "_mac_address": macVictima,
      "_active": true,
      "_password": passwordVictima  
    }

    const dataAttacker = {
      "_firstname": nombreAtacante,
      "_lastname": apellidoAtacante,
      "_username": usernameAtacante,
      "_personal_id": cedulaAtacante,
      "_email": emailAtacante,
      "_mac_address": macAtacante,
      "_active": true,
      "_password": passwordAtacante  
    }

    const dataDistancia = {
      "_victim": {
          "_user": {
              "id": 2 //Usuario
          },
          "id": 7 //Victima
      },
      "_attacker": {
          "_user": {
              "id": 8
          },
          "id": 8
      },
      "_separation_distance": 9.9
  }

    //router.push(Routes.INF_REGISTER);
  };

  return (
    <>
      <Navigation></Navigation>
      <div className="mt-8 mx-auto grid gap-x-8 gap-y-12 px-6 lg:px-8">
        <DivHeader
          title="Registrar Usuarios"
          description="Ingrese los datos correspondientes de los usuarios a registrar, junto con las zonas seguras para dicha Victima y la relacion con el Atacante."
          tags={[2, 3]}
        ></DivHeader>
      </div>

      <form className="m-10 mb-6" onSubmit={onSubmit}>

        {/* DATOS DE LA VICTIMA */}
        <DivForm
          user="Victima"
          onChangeNombre={(e) => { setNombreVictima(e.target.value) }}
          onChangeApellido={(e) => { setApellidoVictima(e.target.value) }}
          onChangeUsername={(e) => { setUsernameVictima(e.target.value) }}
          onChangeEmail={(e) => { setEmailVictima(e.target.value) }}
          onChangePassword={(e) => { setPasswordVictima(e.target.value) }}
          onChangePasswordConfirm={(e) => { setPasswordConfirmVictima(e.target.value) }}
          onChangeCedula={(e) => { setcedulaVictima(e.target.value) }}
          onChangeBluetooth={(e) => { setMacVictima(e.target.value) }}
          
        ></DivForm>


        {/* DATOS DEL ATACANTE */}
        <DivForm
          user="Atacante"
          onChangeNombre={(e) => { setNombreAtacante(e.target.value) }}
          onChangeApellido={(e) => { setApellidoAtacante(e.target.value) }}
          onChangeUsername={(e) => { setUsernameAtacante(e.target.value) }}
          onChangeEmail={(e) => { setEmailAtacante(e.target.value) }}
          onChangePassword={(e) => { setPasswordAtacante(e.target.value) }}
          onChangePasswordConfirm={(e) => { setPasswordConfirmAtacante(e.target.value) }}
          onChangeCedula={(e) => { setcedulaAtacante(e.target.value) }}
          onChangeBluetooth={(e) => { setMacAtacante(e.target.value) }}
          
        ></DivForm>

        {/* DATOS DE LA RELACION VIC/ATA */}
        <div className="space-y-12 mt-10">
          <DivSubHeader
            title="Datos de la relacion entre la Victima y el Atacante"
            description="Ingrese los datos correspondiente de la relacion entre la Victima
            y el Atacante ingresados previamente."
          ></DivSubHeader>

          <div className="border-b border-gray-900/10 pb-12">
            <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
              <DivFormElement
                textLabel="Distancia de Alejamiento (en metros)"
                type="number"
                id="alejamiento"
                name="alejamiento"
                placeholder="Ingrese la distancia en metros de alejamiento minimo entre los usuarios aqui"
                onChange={(e) => { setDistanciaAlejamiento(e.target.value) }}
              ></DivFormElement>
            </div>

            {/* Agregar aqui el input y boton dinamico para crear las zonas seguras */}
          </div>
        </div>
        ERROR: CAMPO *************************************
        {/* Boton Submit */}
        <div className="mb-8 mt-12 flex items-center justify-end gap-x-6 pr-6">
          <div className="w-1/6">
            <ButtonSubmit
              text="Crear Usuarios"
              styles="px-3 py-3 text-lg"
            ></ButtonSubmit>
          </div>
        </div>
      </form>
    </>
  );
}

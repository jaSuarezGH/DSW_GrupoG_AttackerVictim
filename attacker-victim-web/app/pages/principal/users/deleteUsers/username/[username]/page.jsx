"use client";

import {
  endGetAttackerById,
  endGetIncidentByAttacker,
  endGetIncidentByVictim,
  endGetUserByUsername,
  endGetVictimById,
  endPutUser,
} from "@/app/models/endpoint.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivHeader } from "@/components/Div";
import AlertWarning from "@/components/Alert/AlertWarning";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { fetchPostPut } from "@/app/pages/principal/fetch/fetchPostPut/fetchPostPut";
import { DivResponseUser } from "@/components/Div/DivResponseUser/DivResponseUser";

export default function deleteUsernamePage({ params }) {
  const router = useRouter();

  const [control, setControl] = useState(false);
  const [show, setShow] = useState(false);

  const [user, setUser] = useState(null);

  useEffect(() => {
    const fetchDataUser = async () => {
      // Aunque se haga el setUser, no se actualiza ese valor dentro del effect
      // Se debe usar entonces la variable misma que realizo el fethc, pero
      // igualmente hacer setUser, para que el resto de la app lo use.
      const userFetch = await fetchGetDelete(
        endGetUserByUsername,
        params.username
      );
      setUser(userFetch);
      //Variable que se encarga de indicar cuando se podria mostrar el error
      setControl(true);

      if (userFetch) setShow(true);
    };

    fetchDataUser();
  }, []);

  if (user === null && control) {
    const description = `Lo siento, el usuario a eliminar poseedor del Nombre de Usuario (Username): "${params.username}" no se encuentra registrado.`;
    return (
      <InformacionPage
        title="Usuario NO Encontrado"
        description={description}
        encabezado="Not Found"
        link={Routes.UPDATE_USER}
        linkText="Volver a Buscar"
      ></InformacionPage>
    );
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    // VALIDACIONES Y GUARDAR LA MODIFICACION.

    //OPERACION PARA ELIMINAR EL DATO EN EL API

    // - PONER EN INACTIVO AL USUARIO CONSULTADO.
    user._active = false;
    const deleteUser = await fetchPostPut(endPutUser, "PUT", user);

    //-------------------------------------------
    //BUSCAR A SU RESPECTIVO USUARIO RELACIONADO:
    //-------------------------------------------

    // 1. Obterner el id de user de mi usuario consultado:
    // user.id;

    // 2.  Buscar si ese id (user o deleteUser) se encuentra registrado en la tabla Victima, sino buscarlo en la Atacante.
    // 2.1. Buscando en tabla victima:
    const userInTableVictim = await fetchGetDelete(
      endGetVictimById,
      deleteUser.id
    );
    // 2.1.1. Valida si el usuario no se encontro en la tabla victima.
    if (userInTableVictim == null) {
      //2.1.2. Si no se encontro, entonces es que debe estar en la tabla atacante, se busca en atacante:
      const userInTableAttacker = await fetchGetDelete(
        endGetAttackerById,
        deleteUser.id
      );

      // 3. Buscar en la tabla Incident por el id del atacante (No el de user) obtenido de userInTableAttacker
      const attackerInIncident = await fetchGetDelete(
        endGetIncidentByAttacker,
        userInTableAttacker.id
      );

      // 4. De esta tabla (incident) se consiguio el id (de user) del usuario victima relacionado
      // Ahora con ese id, se puede realizar el PUT para poner a la victima inactiva tambien:
      
      const victimPut = attackerInIncident._victim._user;
      victimPut._active = false;

      const userVictimInUser = await fetchPostPut(
        endPutUser,
        "PUT",
        victimPut
      );

      router.push("/pages/principal/users/deleteUsers/response"); 
      
    } else {
      //-------------------------------------------
      //CASO EN QUE EL USUARIO A ELIMINAR SI ESTE EN LA TABLA VICTIMA:
      //-------------------------------------------

      // 3. Buscar en la tabla Incident por el id de la victima (No el de user) obtenido de userInTableVictim
      const victimInIncident = await fetchGetDelete(
        endGetIncidentByVictim,
        userInTableVictim.id
      );

      // 4. De esta tabla (incident) se consiguio el id (de user) del usuario atacante relacionado
      // Ahora con ese id, se puede realizar el PUT para poner al atacante inactivo tambien:
      const atacantePut = victimInIncident._attacker._user;
      atacantePut._active = false;

      const userAttackerInUser = await fetchPostPut(
        endPutUser,
        "PUT",
        atacantePut
      );

      router.push("/pages/principal/users/deleteUsers/response");
    }
  };

  return (
    <>
      <div className="mt-8 mx-auto grid gap-x-8 gap-y-12 px-6 lg:px-8">
        <DivHeader
          title="Eliminar Usuario"
          description="Confirme si el siguiente usuario tipo Victima o Atacante es el deseado a eliminar."
          tags={[2, 3]}
        ></DivHeader>
      </div>

      <form className="m-10 mb-2" onSubmit={onSubmit}>
        {show && (
          <DivResponseUser
            user={user}
            title="Informacion del usuario"
            description={`Todos los datos del usuario a consultar poseedor del Nombre de Usuario: "${params.username}".`}
            tags={[]}
          ></DivResponseUser>
        )}

        <AlertWarning
          title="ADVERTENCIA"
          description="Al eliminar un usuario este seguira en el sistema pero con estando de Inactivo. Ademas tambien el usuario relacionado a el tambien pasara a estado de Inactivo"
        ></AlertWarning>

        {/* Boton Submit */}
        <div className="mb-8 flex items-center justify-end gap-x-6 pr-6">
          <div className="w-1/6">
            <ButtonSubmit
              text="Eliminar Usuario"
              styles="px-3 py-3 text-lg"
            ></ButtonSubmit>
          </div>
        </div>
      </form>
    </>
  );
}

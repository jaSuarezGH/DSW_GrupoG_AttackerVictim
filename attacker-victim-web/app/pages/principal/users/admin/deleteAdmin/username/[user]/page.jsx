"use client";

import {
  endDeleteAdmin,
  endGetAdminByUsername,
} from "@/app/models/endpoint.model";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import { DivHeader } from "@/components/Div";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { ListConsultAdmin } from "@/components/List/ListConsultAdmin/ListConsultAdmin";
import AlertError from "@/components/Alert/AlertError";

export default function deleteEmailAdminPage({ params }) {
  const router = useRouter();

  const [control, setControl] = useState(false);
  const [show, setShow] = useState(false);

  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");

  const [user, setUser] = useState(null);

  useEffect(() => {
    const fetchDataUser = async () => {
      // Aunque se haga el setUser, no se actualiza ese valor dentro del effect
      // Se debe usar entonces la variable misma que realizo el fethc, pero
      // igualmente hacer setUser, para que el resto de la app lo use.
      const userFetch = await fetchGetDelete(endGetAdminByUsername, params.user);
      setUser(userFetch);
      //Variable que se encarga de indicar cuando se podria mostrar el error
      setControl(true);

      if (userFetch) setShow(true);
    };

    fetchDataUser();
  }, []);

  if (user === null && control) {
    const description = `Lo siento, el usuario Administrador a eliminar poseedor del Nombre de Usuario (Username): "${params.user}" no se encuentra registrado.`;
    return (
      <InformacionPage
        title="Usuario NO Encontrado"
        description={description}
        encabezado="Not Found"
        link={Routes.DELETE_ADMIN}
        linkText="Volver a Buscar"
      ></InformacionPage>
    );
  }

  const onSubmit = async (e) => {
    e.preventDefault();

    const deleteAdmin = await fetchGetDelete(endDeleteAdmin, user.id, "DELETE");

    if (deleteAdmin) {
      setErrorInfo(false);
      router.push("/pages/principal/users/admin/deleteAdmin/response");
    } else {
      setDescriptionError(
        "Ha ocurrido un error inesperado al momento de eliminar al Administrador del sistema, por favor intente nuevamente mas tarde."
      );
      setErrorInfo(true);
    }
  };

  return (
    <>
      <div className="mt-8 mx-auto grid gap-x-8 gap-y-12 px-6 lg:px-8">
        <DivHeader
          title="Eliminar Administrador"
          description="Confirme si el siguiente usuario Administrador es el deseado a eliminar."
          tags={[1]}
        ></DivHeader>
      </div>

      <form className="m-10 mb-2" onSubmit={onSubmit}>
        {show && <ListConsultAdmin user={user} />}

        {errorInfo && (
          <div className="mt-8 mb-8">
            <AlertError description={descriptionError}></AlertError>
          </div>
        )}

        {/* Boton Submit */}
        <div className="mb-8 flex items-center justify-end gap-x-6 pr-6">
          <div className="w-1/6">
            <ButtonSubmit
              text="Eliminar Administrador"
              styles="px-3 py-3 text-lg"
            ></ButtonSubmit>
          </div>
        </div>
      </form>
    </>
  );
}

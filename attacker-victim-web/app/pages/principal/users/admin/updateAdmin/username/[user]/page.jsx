"use client";

import {
  endGetAdminByEmail,
  endGetAdminByUsername,
  endPutAdmin,
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
import { fetchPostPut } from "@/app/pages/principal/fetch/fetchPostPut/fetchPostPut";
import { DivFormAdmin } from "@/components/Div/DivFormAdmin/DivFormAdmin";

export default function updateEmailAdminPage({ params }) {
  const router = useRouter();

  const [control, setControl] = useState(false);

  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");

  const [user, setUser] = useState(null);

  const [id, setId] = useState(0);
  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [passwordConfirm, setPasswordConfirm] = useState("");

  useEffect(() => {
    const fetchDataUser = async () => {
      // Aunque se haga el setUser, no se actualiza ese valor dentro del effect
      // Se debe usar entonces la variable misma que realizo el fethc, pero
      // igualmente hacer setUser, para que el resto de la app lo use.
      const userFetch = await fetchGetDelete(endGetAdminByUsername, params.user);
      setUser(userFetch);
      //Variable que se encarga de indicar cuando se podria mostrar el error
      setControl(true);

      if (userFetch) {
        setUsername(userFetch._username);
        setEmail(userFetch._email);
        setPassword(userFetch._password);
        setPasswordConfirm(userFetch._password);
        setId(userFetch.id);
      }
    };

    fetchDataUser();
  }, []);

  if (user === null && control) {
    const description = `Lo siento, el usuario Administrador a modificar poseedor del Nombre de Usuario (Username): "${params.user}" no se encuentra registrado.`;
    return (
      <InformacionPage
        title="Usuario NO Encontrado"
        description={description}
        encabezado="Not Found"
        link={Routes.UPDATE_ADMIN}
        linkText="Volver a Buscar"
      ></InformacionPage>
    );
  }

  const onSubmit = async (e) => {
    e.preventDefault();

    if (password == passwordConfirm) {
      user._password = password;
      const validateEmail = await fetchGetDelete(endGetAdminByEmail, email);
      if (validateEmail == null || validateEmail.id == id) {
        user._email = email;
        const validateUsername = await fetchGetDelete(
          endGetAdminByUsername,
          username
        );
        if (validateUsername == null || validateUsername.id == id) {
          user._username = username;
          // Fetch para hacer PUT. Modificar al administrador con los nuevos datos.
          const updateAdmin = await fetchPostPut(endPutAdmin, "PUT", user);
          if (updateAdmin) {
            setErrorInfo(false);
            router.push("/pages/principal/users/admin/updateAdmin/response");
          } else {
            setDescriptionError(
              "Ha ocurrido un error inesperado al momento de modificar al Administrador del sistema, por favor intente nuevamente mas tarde."
            );
            setErrorInfo(true);
          }
        } else {
          setDescriptionError(
            "El Nombre de usuario (Username) ingresado del Administrador ya se encuentra registrado por otro usuario en el sistema, ingrese otra."
          );
          setErrorInfo(true);
        }
      } else {
        setDescriptionError(
          "El Correo Electronico (Email) ingresado del Administrador ya se encuentra registrado por otro usuario en el sistema, ingrese otra."
        );
        setErrorInfo(true);
      }
    } else {
      setDescriptionError(
        "La Contraseña ingresada no concuerda con la confirmacion de la Contraseña."
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
        <DivFormAdmin
          onChangeUsername={(e) => {
            setUsername(e.target.value);
          }}
          onChangeEmail={(e) => {
            setEmail(e.target.value);
          }}
          onChangePassword={(e) => {
            setPassword(e.target.value);
          }}
          onChangePasswordConfirm={(e) => {
            setPasswordConfirm(e.target.value);
          }}
          valueEmail={email}
          valuePassword={password}
          valuePasswordConfirm={passwordConfirm}
          valueUsername={username}
        ></DivFormAdmin>

        {errorInfo && (
          <div className="mt-8">
            <AlertError description={descriptionError}></AlertError>
          </div>
        )}

        {/* Boton Submit */}
        <div className="mb-8 mt-8 flex items-center justify-end gap-x-6 pr-6">
          <div className="w-1/6">
            <ButtonSubmit
              text="Modificar Administrador"
              styles="px-3 py-3 text-lg"
            ></ButtonSubmit>
          </div>
        </div>
      </form>
    </>
  );
}

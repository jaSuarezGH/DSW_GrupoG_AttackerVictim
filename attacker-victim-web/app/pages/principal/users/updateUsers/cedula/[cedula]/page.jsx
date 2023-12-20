"use client";

import {
  endGetUserByCedula,
  endGetUserByEmail,
  endGetUserByMAC,
  endGetUserByUsername,
  endPutUser,
} from "@/app/models/endpoint.model";
import { fetchGetDelete } from "../../../fetch/fetchGetDelete";
import { InformacionPage } from "@/components/InformationPage/InformationPage";
import { Routes } from "@/app/models/routes.model";
import { DivForm } from "@/components/Div/DivForm/DivForm";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import { ButtonSubmit } from "@/components/Button/ButtonSubmit";
import AlertError from "@/components/Alert/AlertError";
import { DivHeader } from "@/components/Div";
import { fetchPostPut } from "../../../fetch/fetchPostPut/fetchPostPut";

export default function UpdateCedulaPage({ params }) {
  
  const router = useRouter();

  const [control, setControl] = useState(false);

  const [user, setUser] = useState(null);

  const [errorInfo, setErrorInfo] = useState(false);
  const [descriptionError, setDescriptionError] = useState("");

  const [id, setId] = useState(0);
  const [nombre, setNombre] = useState("");
  const [apellido, setApellido] = useState("");
  const [username, setUsername] = useState("");
  const [cedula, setCedula] = useState(0);
  const [email, setEmail] = useState("");
  const [mac, setMac] = useState("");
  const [password, setPassword] = useState("");
  const [passwordConfirm, setPasswordConfirm] = useState("");

  useEffect(() => {
    const fetchDataUser = async () => {
      // Aunque se haga el setUser, no se actualiza ese valor dentro del effect
      // Se debe usar entonces la variable misma que realizo el fethc, pero
      // igualmente hacer setUser, para que el resto de la app lo use.
      const userFetch = await fetchGetDelete(endGetUserByCedula, params.cedula);
      setUser(userFetch);
      //Variable que se encarga de indicar cuando se podria mostrar el error
      setControl(true);
      if (userFetch != null) {
        setNombre(userFetch._firstname);
        setApellido(userFetch._lastname);
        setCedula(userFetch._personal_id);
        setUsername(userFetch._username);
        setEmail(userFetch._email);
        setMac(userFetch._mac_address);
        setPassword(userFetch._password);
        setPasswordConfirm(userFetch._password);
        setId(userFetch.id);
      }
    };

    fetchDataUser();
  }, []);

  if (user === null && control) {
    const description = `Lo siento, el usuario a modificar poseedor de la Cedula: "${params.cedula}" no se encuentra registrado.`;
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
    if (password == passwordConfirm) {
      user._firstname = nombre;
      user._lastname = apellido;
      user._password = password;
      const validateCedula = await fetchGetDelete(endGetUserByCedula, cedula);
      if (validateCedula == null || validateCedula.id == id) {
        user._personal_id = cedula;
        const validateUsername = await fetchGetDelete(
          endGetUserByUsername,
          username
        );

        if (validateUsername == null || validateUsername.id == id) {
          user._username = username;
          const validateEmail = await fetchGetDelete(endGetUserByEmail, email);
          if (validateEmail == null || validateEmail.id == id) {
            user._email = email;

            const validateMAC = await fetchGetDelete(endGetUserByMAC, mac);

            if (validateMAC == null || validateMAC.id == id) {
                user._mac_address = mac;
                setErrorInfo(false);

                //OPERACION PARA MODIFICAR EL DATO EN EL API
                const updateUser = await fetchPostPut(endPutUser, "PUT", user);
                if (updateUser != null){
                  router.push('/pages/principal/users/updateUsers/response');
                } else {
                  setDescriptionError(
                    "Ha ocurrido un error inesperado al realizar la operacion de Modificacion de Usuario. Por favor intente nuevamente mas tarde."
                  );
                  setErrorInfo(true);
                }

            }else {
              setDescriptionError(
                "La Direccion MAC del Bluetooth ingresado del usuario ya se encuentra registrado por otro usuario en el sistema, ingrese otra."
              );
              setErrorInfo(true);
            }
          } else {
            setDescriptionError(
              "El Correo Electronico (Email) ingresado del usuario ya se encuentra registrado por otro usuario en el sistema, ingrese otra."
            );
            setErrorInfo(true);
          }
        } else {
          setDescriptionError(
            "El Nombre de usuario (Username) ingresado del usuario ya se encuentra registrada por otro usuario en el sistema, ingrese otra."
          );
          setErrorInfo(true);
        }
      } else {
        setDescriptionError(
          "La Cedula ingresada del usuario ya se encuentra registrada por otro usuario en el sistema, ingrese otra."
        );
        setErrorInfo(true);
      }
    } else {
      setDescriptionError(
        "La Contraseña del usuario no es igual que la ingresada en el campo de confirmacion de contraseña."
      );
      setErrorInfo(true);
    }
  };

  return (
    <>
      <div className="mt-8 mx-auto grid gap-x-8 gap-y-12 px-6 lg:px-8">
        <DivHeader
          title="Modificar Usuario"
          description="Ingrese los nuevos datos del usuario tipo Victima o Atacante a modificar."
          tags={[2, 3]}
        ></DivHeader>
      </div>

      <form className="m-10 mb-6" onSubmit={onSubmit}>
        {errorInfo && (
          <div className="mt-8">
            <AlertError description={descriptionError}></AlertError>
          </div>
        )}

        {/* DATOS DEL USUARIO */}
        <DivForm
          user=""
          onChangeNombre={(e) => {
            setNombre(e.target.value);
          }}
          onChangeApellido={(e) => {
            setApellido(e.target.value);
          }}
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
          onChangeCedula={(e) => {
            setCedula(e.target.value);
          }}
          onChangeBluetooth={(e) => {
            setMac(e.target.value);
          }}
          valueNombre={nombre}
          valueApellido={apellido}
          valueCedula={cedula}
          valueEmail={email}
          valueMAC={mac}
          valuePassword={password}
          valuePasswordConfirm={passwordConfirm}
          valueUsername={username}
        ></DivForm>

        {errorInfo && (
          <div className="mt-8">
            <AlertError description={descriptionError}></AlertError>
          </div>
        )}

        {/* Boton Submit */}
        <div className="mb-8 mt-12 flex items-center justify-end gap-x-6 pr-6">
          <div className="w-1/6">
            <ButtonSubmit
              text="Modificar Usuario"
              styles="px-3 py-3 text-lg"
            ></ButtonSubmit>
          </div>
        </div>
      </form>
    </>
  );
}

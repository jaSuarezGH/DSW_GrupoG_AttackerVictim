import { Routes } from "@/app/models/routes.model";

import Card from "@/components/Card/Card";
import HeaderPrincipal from "@/components/Header/HeaderPrincipal";
import { Navigation } from "@/components/Navigation";

export default function PrincipalVictimPage() {
  return (
    <>
      <Navigation number={1}></Navigation>

      <HeaderPrincipal texto="Seccion Victima"></HeaderPrincipal>

      <section class="px-6 py-20 mx-auto max-w-8xl pt-10">
        <div class=" mx-4 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 gap-x-16 lg:gap-x-20 gap-y-18">
          {/* CONSULTAR VICTIMAS */}
          <Card
            title="Consultar Victimas"
            description='Consultar a todos los usuarios de tipo "Victima" registrados en el
            sistema.'
            link={Routes.GETALL_VICTIMS}
            tags={[2]}
          ></Card>

      

          {/* CONSULTAR UN USUARIO */}
          <Card
            title="Consultar un Usuario"
            description='Consultar a un usuario de tipo "Victima" registrado en el sistema.'
            link={Routes.GET_USER}
            tags={[1, 2, 3]}
          ></Card>

          {/* Modificar Zonas Seguras de Victima. */}
          <Card
            title="Modificar Zonas Seguras de Victima"
            description='Modificar las Zonas Seguras relacionadas a un usuario de tipo
            "Victima" registrado en el sistema.'
            link={Routes.GET_USER}
            tags={[2]}
          ></Card>

          {/* Modificar Relación Victima/Atacante */}
          <Card
            title="Modificar Relación Victima/Atacante"
            description='Modificar la relacion entre un usuario "Victima" y un usuario
            "Atacante".'
            link={Routes.GET_USER}
            tags={[2, 3]}
          ></Card>

          {/* Posicionamiento de Victima/Atacante */}
          <Card
            title="Posicionamiento de Victima/Atacante"
            description='Consultar el ultimo posicionamiento de un usuario tipo "Victima" o
            un usuario "Atacante".'
            link={Routes.GET_USER}
            tags={[2, 3]}
          ></Card>

          {/* Crear Usuario Victima y Atacante */}
          <Card
            title="Crear Usuario Victima y Atacante"
            description='Crear usuarios de tipo "Victima" y su respectivo usuario
            "Atacante" relacionado.'
            link={Routes.CREATE_USER}
            tags={[2, 3]}
          ></Card>

          {/* Modificar un Usuario */}
          <Card
            title="Modificar Usuario"
            description="Modificar a un usuario registrado en el sistema."
            link={Routes.GET_USER}
            tags={[1, 2, 3]}
          ></Card>

          {/* Eliminar Usuario Victima y Atacante */}
          <Card
            title="Eliminar Usuario Victima y Atacante"
            description='Eliminar un usuario de tipo "Victima" y su respectivo usuario
            "Atacante" relacionado.'
            link={Routes.CREATE_USER}
            tags={[2, 3]}
          ></Card>

        </div>
      </section>
    </>
  );
}

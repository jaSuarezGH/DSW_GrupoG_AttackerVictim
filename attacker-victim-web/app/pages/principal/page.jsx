
import { Routes } from "@/app/models/routes.model";
import { Card } from "@/components/Card/Card";
import { HeaderPrincipal } from "@/components/Header/HeaderPrincipal";

export default async function PrincipalPage() {

  return (
    <>

      <HeaderPrincipal texto="Funcionalidades"></HeaderPrincipal>

      <section className="px-6 mx-auto max-w-8xl pt-10">
        <div className=" mx-4 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 gap-x-16 lg:gap-x-20 gap-y-18">
          
          {/* CONSULTAR TODOS LOS ADMINISTRADORES */}
          <Card
            title="Consultar Administradores"
            description="Consultar a todos los usuarios de tipo Administrador registrados en el sistema."
            link={Routes.GETALL_ADMINS}
            tags={[1]}
          ></Card>

          
          {/* Crear Usuario Administrador */}
          <Card
            title="Crear Usuario Administrador"
            description='Crear usuarios de tipo "Administrador" y su respectivo usuario.'
            link={Routes.CREATE_ADMIN}
            tags={[1]}
          ></Card>

          {/* Modificar Administrador */}
          <Card
            title="Modificar Usuario Administrador"
            description="Modificar a un usuario de tipo Administrador registrado en el sistema."
            link={Routes.UPDATE_ADMIN}
            tags={[1]}
          ></Card>

          {/* Eliminar Usuario Administrador */}
          <Card
            title="Eliminar Usuario Administrador"
            description='Eliminar un usuario de tipo "Administrador" registrado en el sistema.'
            link={Routes.DELETE_ADMIN}
            tags={[1]}
          ></Card>

          {/* HISTORIAL DE NOTIFICACIONES */}
          <Card
            title="Historial de Notificaciones"
            description="Ver un historial de todas las distintas notificaciones o alertas recibidas."
            link={Routes.GET_ALL_NOTIFICATIONS}
            tags={[1]}
          ></Card>


          {/* CONSULTAR VICTIMAS */}
          <Card
            title="Consultar Victimas"
            description='Consultar a todos los usuarios de tipo "Victima" registrados en el
            sistema.'
            link={Routes.GETALL_VICTIMS}
            tags={[2]}
          ></Card>


          {/* Crear Zona Segura */}
          <Card
            title="Crear Zona Segura"
            description='Crear Zona Segura para un usuario de tipo "Victima" registrado en el sistema.'
            link={Routes.CREATE_ZS}
            tags={[2]}
          ></Card>

          {/* Consultar Zona Segura */}
          <Card
            title="Consultar Zona Segura"
            description='Consultar Zona Segura de un usuario de tipo "Victima" registrado en el sistema.'
            link={Routes.CONSULT_ZS}
            tags={[2]}
          ></Card>

          {/* Eliminar Zona Segura */}
          <Card
            title="Eliminar Zona Segura"
            description='Eliminar Zona Segura de un usuario de tipo "Victima" registrado en el sistema.'
            link={Routes.DELETE_ZS}
            tags={[2]}
          ></Card>

          {/* CONSULTAR ATACANTES */}
          <Card
            title="Consultar Atacantes"
            description='Consultar a todos los usuarios de tipo "Atacante" registrados en
            el sistema.'
            link={Routes.GETALL_ATTACKERS}
            tags={[3]}
          ></Card>

          {/* CONSULTAR TODOS LOS USUARIOS */}
          <Card
            title="Consultar todos los Victima/Atacante"
            description="Consultar a todos los usuarios tipo Victima o Atacante registrados en el sistema."
            link={Routes.GETALL_USERS}
            tags={[2, 3]}
          ></Card>

          {/* CONSULTAR UN USUARIO */}
          <Card
            title="Consultar un Usuario Victima/Atacante"
            description="Consultar a un unico usuario de tipo Victima o Atacante registrados en el sistema."
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
            title="Modificar Usuario Victima/Atacante"
            description="Modificar a un usuario de tipo Victima o Atacante registrado en el sistema."
            link={Routes.UPDATE_USER}
            tags={[2, 3]}
          ></Card>


          {/* Consultar la Relación Victima/Atacante */}
          <Card
            title="Consultar Relación Victima/Atacante"
            description='Consultar la relacion entre un usuario "Victima" y un usuario
            "Atacante".'
            link={Routes.GET_RELATION}
            tags={[2, 3]}
          ></Card>

          {/* Modificar Relación Victima/Atacante */}
          <Card
            title="Modificar Relación Victima/Atacante"
            description='Modificar la relacion entre un usuario "Victima" y un usuario
            "Atacante".'
            link={Routes.UPDATE_RELATION}
            tags={[2, 3]}
          ></Card>

          {/* Posicionamiento de Victima/Atacante */}
          <Card
            title="Posicionamiento de Victima/Atacante"
            description='Consultar el ultimo posicionamiento de un usuario tipo "Victima" o
            un usuario "Atacante".'
            link={Routes.GET_LOCATION_HOME}
            tags={[2, 3]}
          ></Card>

          {/* Eliminar Usuario Victima y Atacante */}
          <Card
            title="Eliminar Usuario Victima y Atacante"
            description='Eliminar un usuario de tipo "Victima" y su respectivo usuario
            "Atacante" relacionado.'
            link={Routes.DELETE_USER}
            tags={[2, 3]}
          ></Card>


        </div>
      </section>
    </>
  );
}

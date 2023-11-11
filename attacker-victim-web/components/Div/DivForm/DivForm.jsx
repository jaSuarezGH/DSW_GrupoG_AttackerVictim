import { DivFormElement } from "../DivFormElement/DivFormElement";
import { DivSubHeader } from "../Header/DivSubHeader/DivSubHeader";

export function DivForm({ user }) {
  return (
    <div className="space-y-12 mt-10">
      <DivSubHeader
        title={`Datos del Usuario ${user}`}
        description={`Ingrese los datos correspondiente al Usuario tipo ${user}.`}
      ></DivSubHeader>

      <div className="border-b border-gray-900/10 pb-12">
        <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
          <DivFormElement
            textLabel="Primer Nombre"
            type="text"
            name="primer-nombre"
            id="primer-nombre"
            placeholder={`Ingrese el Nombre del usuario ${user} aqui`}
          ></DivFormElement>

          <DivFormElement
            textLabel="Apellidos"
            type="text"
            name="apellido"
            id="apellido"
            placeholder={`Ingrese los Apellidos del usuario ${user} aqui`}
          ></DivFormElement>

          <DivFormElement
            textLabel="Nombre de Usuario (Username)"
            type="text"
            name="user"
            id="user"
            placeholder={`Ingrese el Nombre de Usuario (user) del usuario ${user} aqui`}
          ></DivFormElement>

          <DivFormElement
            textLabel="Correo Electronico"
            type="email"
            name="email"
            id="email"
            placeholder={`Ingrese el Correo Electronico del usuario ${user} aqui`}
          ></DivFormElement>

          <DivFormElement
            textLabel="Cedula de Identidad"
            type="number"
            name="cedula"
            id="cedula"
            placeholder={`Ingrese el numero de Documento de Identificacion del usuario ${user} aqui`}
          ></DivFormElement>

          <DivFormElement
            textLabel="Dirección de Bluetooth (MAC)"
            type="text"
            name="bluetooth"
            id="bluetooth"
            placeholder={`Ingrese la Direccion Bluetooth (MAC) dispositivo movil del usuario ${user} aqui`}
          ></DivFormElement>
        </div>
      </div>
    </div>
  );
}

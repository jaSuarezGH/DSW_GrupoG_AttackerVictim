import { DivFormElement } from "../DivFormElement/DivFormElement";
import { DivSubHeader } from "../Header/DivSubHeader/DivSubHeader";

export function DivForm({
  user,
  onChangeNombre,
  onChangeApellido,
  onChangeUsername,
  onChangeEmail,
  onChangePassword,
  onChangePasswordConfirm,
  onChangeCedula,
  onChangeBluetooth
}) {
  return (
    <div className="space-y-12 mt-10">
      <DivSubHeader
        title={`Datos del Usuario ${user}`}
        description={`Ingrese los datos correspondiente al Usuario tipo ${user}.`}
      ></DivSubHeader>

      <div className="border-b border-gray-900/10 pb-12">
        <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
          <DivFormElement
            textLabel="Nombres"
            type="text"
            name={`nombre${user}`}
            id={`nombre${user}`}
            placeholder={`Ingrese el Nombre del usuario ${user} aqui`}
            onChange={onChangeNombre}
          ></DivFormElement>

          <DivFormElement
            textLabel="Apellidos"
            type="text"
            name={`apellido${user}`}
            id={`apellido${user}`}
            placeholder={`Ingrese los Apellidos del usuario ${user} aqui`}
            onChange={onChangeApellido}
          ></DivFormElement>

          <DivFormElement
            textLabel="Nombre de Usuario (Username)"
            type="text"
            name={`username${user}`}
            id={`username${user}`}
            placeholder={`Ingrese el Nombre de Usuario (user) del usuario ${user} aqui`}
            onChange={onChangeUsername}
          ></DivFormElement>

          <DivFormElement
            textLabel="Correo Electronico"
            type="email"
            name={`email${user}`}
            id={`email${user}`}
            placeholder={`Ingrese el Correo Electronico del usuario ${user} aqui`}
            onChange={onChangeEmail}
          ></DivFormElement>

          <DivFormElement
            textLabel="Contraseña"
            type="password"
            name={`password${user}`}
            id={`password${user}`}
            placeholder={`Ingrese la contraseña del usuario ${user} aqui`}
            onChange={onChangePassword}
          ></DivFormElement>

          <DivFormElement
            textLabel="Repita la Contraseña"
            type="password"
            name={`passwordConfirm${user}`}
            id={`passwordConfirm${user}`}
            placeholder={`Ingrese la Contraseña nuevamente del usuario ${user} aqui`}
            onChange={onChangePasswordConfirm}
          ></DivFormElement>

          <DivFormElement
            textLabel="Cedula de Identidad"
            type="number"
            name={`cedula${user}`}
            id={`cedula${user}`}
            placeholder={`Ingrese el numero de Documento de Identificacion del usuario ${user} aqui`}
            onChange={onChangeCedula}
          ></DivFormElement>

          <DivFormElement
            textLabel="Dirección de Bluetooth (MAC)"
            type="text"
            name={`bluetooth${user}`}
            id={`bluetooth${user}`}
            placeholder={`Ingrese la Direccion Bluetooth (MAC) dispositivo movil del usuario ${user} aqui`}
            onChange={onChangeBluetooth}
          ></DivFormElement>
        </div>
      </div>
    </div>
  );
}

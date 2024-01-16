import { DivFormElement } from "../DivFormElement/DivFormElement";

export function DivFormAdmin({
  onChangeUsername,
  onChangeEmail,
  onChangePassword,
  onChangePasswordConfirm,
  valueUsername = "",
  valueEmail = "",
  valuePassword = "",
  valuePasswordConfirm = "",
  disableUsername = false,
  disableEmail = false,
  disablePassword = false,
  disablePasswordConfirm = false
}) {
  return (
    <div className="space-y-12 mt-10">
      <div className="border-b border-gray-900/10 pb-12">
        <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
          <DivFormElement
            textLabel="Nombre de Usuario (Username)"
            type="text"
            name='usernameAdministrador'
            id='usernameAdministrador'
            placeholder="Ingrese el Nombre de Usuario (username) del usuario Administrador aqui"
            onChange={onChangeUsername}
            value={valueUsername}
            disabled = {disableUsername}
          ></DivFormElement>

          <DivFormElement
            textLabel="Correo Electronico (Email)"
            type="email"
            name="emailAdministrador"
            id="emailAdministrador"
            placeholder="Ingrese el Correo Electronico del usuario Administrador aqui"
            onChange={onChangeEmail}
            value={valueEmail}
            disabled = {disableEmail}
          ></DivFormElement>

          <DivFormElement
            textLabel="Contraseña"
            type="password"
            name="passwordAdministrador"
            id="passwordAdministrador"
            placeholder="Ingrese la contraseña del usuario Administrador aqui"
            onChange={onChangePassword}
            value={valuePassword}
            disabled = {disablePassword}
          ></DivFormElement>

          <DivFormElement
            textLabel="Repita la Contraseña"
            type="password"
            name="passwordConfirmAdministrador"
            id="passwordConfirmAdministrador"
            placeholder="Ingrese la Contraseña nuevamente del usuario Administrador aqui"
            onChange={onChangePasswordConfirm}
            value={valuePasswordConfirm}
            disabled = {disablePasswordConfirm}
          ></DivFormElement>
        </div>
      </div>
    </div>
  );
}

import DivDefinitionListElement from "@/components/Div/DivResponseUser/DivDefinitionListElement/DivDefinitionListElement";

export function ListConsultaUser({ user }) {

  return (
    <div className="border-gray-100">
      <dl className="ml-6 mr-6 divide-y divide-gray-100" key={user._personal_id}>
        <DivDefinitionListElement
          title="Nombres"
          value={user._firstname}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Apellidos"
          value={user._lastname}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Cedula de Identidad"
          value={user._personal_id}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Nombre de Usuario"
          value={user._username}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Contraseña"
          value={user._password}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Correo Electronico"
          value={user._email}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Direccion MAC"
          value={user._mac_address}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Estado"
          value={user._active ? "Activo" : "Inactivo"}
        ></DivDefinitionListElement>
      </dl>
    </div>
  );
}

import DivDefinitionListElement from "@/components/Div/DivResponseUser/DivDefinitionListElement/DivDefinitionListElement";

export function ListConsultaUser({ user }) {

  return (
    <div className="border-gray-100">
      <dl className="ml-6 mr-6 divide-y divide-gray-100" key={user.cedula}>
        <DivDefinitionListElement
          title="Nombres"
          value={user.nombres}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Apellidos"
          value={user.apellidos}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Cedula de Identidad"
          value={user.cedula}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Nombre de Usuario"
          value={user.username}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Contraseña"
          value={user.contraseña}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Correo Electronico"
          value={user.correo}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Direccion MAC"
          value={user.MAC}
        ></DivDefinitionListElement>
      </dl>
    </div>
  );
}

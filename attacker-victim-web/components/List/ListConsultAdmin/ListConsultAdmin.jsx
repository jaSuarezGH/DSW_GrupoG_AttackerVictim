import DivDefinitionListElement from "@/components/Div/DivResponseUser/DivDefinitionListElement/DivDefinitionListElement";

export function ListConsultAdmin({ user }) {
  return (
    <div className="border-gray-100">
      <dl
        className="ml-6 mr-6 divide-y divide-gray-100"
        key={user.id}
      >
        <DivDefinitionListElement
          title="Correo Electronico (Email)"
          value={user._email}
        ></DivDefinitionListElement>
        
        <DivDefinitionListElement
          title="Nombre de Usuario (Username)"
          value={user._username}
        ></DivDefinitionListElement>

        <DivDefinitionListElement
          title="Contraseña"
          value={user._password}
        ></DivDefinitionListElement>

        
      </dl>
    </div>
  );
}

import { TagAdministrador, TagAtacante, TagVictima } from "../../Tag";

function FillTableAllUsers({ users }) {
  return users.map((person) => (
    <tr key={person.cedula} className="bg-gray-100 border-b-2">
      <td class="px-6 py-4">
        {person.tipo === 1 ? (
          <TagAdministrador></TagAdministrador>
        ) : person.tipo === 2 ? (
          <TagVictima></TagVictima>
        ) : (
          <TagAtacante></TagAtacante>
        )}
      </td>
      <th
        scope="row"
        class="px-6 py-4 font-medium text-gray-600 whitespace-nowrap"
      >
        {person.username}
      </th>
      <td class="px-6 py-4">{person.contraseña}</td>
      <td class="px-6 py-4">{person.nombres}</td>
      <td class="px-6 py-4">{person.apellidos}</td>
      <td class="px-6 py-4">{person.cedula}</td>
      <td class="px-6 py-4">{person.correo}</td>
      <td class="px-6 py-4">{person.MAC}</td>
    </tr>
  ));
}

export default FillTableAllUsers;

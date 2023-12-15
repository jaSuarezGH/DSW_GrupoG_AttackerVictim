function FillTableVictimAttacker({ users }) {
  return users.map((person) => {
    return (
      <>
        <tr key={person.id} className="bg-gray-100 border-b-2">
          <th
            scope="row"
            class="px-6 py-4 font-medium text-gray-600 whitespace-nowrap"
          >
            {person._user._username}
          </th>
          <td class="px-6 py-4">{person._user._password}</td>
          <td class="px-6 py-4">{person._user._firstname}</td>
          <td class="px-6 py-4">{person._user._lastname}</td>
          <td class="px-6 py-4">{person._user._personal_id}</td>
          <td class="px-6 py-4">{person._user._email}</td>
          <td class="px-6 py-4">{person._user._mac_address}</td>
          <td class="px-6 py-4">{person._user._active ? "Activo" : "Desactivado"}</td>
        </tr>
      </>
    );
  });
}

export default FillTableVictimAttacker;

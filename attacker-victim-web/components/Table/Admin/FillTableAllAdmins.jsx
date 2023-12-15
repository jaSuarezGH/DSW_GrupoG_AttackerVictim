
function FillTableAllAdmins({ users }) {
  return users.map((person) => (
    <tr key={person._personal_id} className="bg-gray-100 border-b-2">
      <th
        scope="row"
        class="px-6 py-4 font-medium text-gray-600 whitespace-nowrap"
      >
        {person._username}
      </th>
      <td class="px-6 py-4">{person._password}</td>
      <td class="px-6 py-4">{person._email}</td>
      <td class="px-6 py-4">{person.id}</td>
    </tr>
  ));
}

export default FillTableAllAdmins;

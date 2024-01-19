'use client'
import { Routes } from "@/app/models/routes.model";
import { ButtonRedirect } from "@/components/Button/ButtonRedirect";
import { useRouter } from "next/navigation";

export function FillTableAllAdmins({ users }) {
  const router = useRouter();
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
      <td class="px-6 py-4">
        <ButtonRedirect
          styles="px-3 py-1.5 text-sm mb-4"
          text="Modificar"
          onClick={() => {
            router.push(`${Routes.UPDATE_ADMIN_EMAIL}${person._email}`);
          }}
        />
        <ButtonRedirect
          text="Eliminar"
          onClick={() => {
            router.push(`${Routes.DELETE_ADMIN_EMAIL}${person._email}`);
          }}
        />
      </td>
    </tr>
  ));
}


'use client'
import { Routes } from "@/app/models/routes.model";
import { ButtonRedirect } from "@/components/Button/ButtonRedirect";
import { useRouter } from "next/navigation";

export function FillTableVictimAttacker({ users }) {
  const router = useRouter();
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
          <td class="px-6 py-4">
            {person._user._active ? "Activo" : "Inactivo"}
          </td>
          <td class="px-6 py-4">
            <ButtonRedirect
              styles="px-3 py-1.5 text-sm mb-4"
              text="Modificar"
              onClick={() => {
                router.push(`${Routes.UPDATE_USER_EMAIL}${person._user._email}`);
              }}
            />
            <ButtonRedirect
              text="Eliminar"
              onClick={() => {
                router.push(`${Routes.DELETE_USER_EMAIL}${person._user._email}`);
              }}
            />
          </td>
        </tr>
      </>
    );
  });
}

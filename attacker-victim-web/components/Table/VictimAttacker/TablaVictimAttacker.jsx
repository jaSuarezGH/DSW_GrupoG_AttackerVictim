import FillTableVictimAttacker from "./FillTableVictimAttacker";

export function TablaVictimAttacker({ users, tipo }) {
  return (
    <div class="items-center flex relative overflow-x-auto ring-2 ring-slate-300 rounded-md">
          <table class="w-full text-sm text-center text-gray-500">
            <thead class="text-xs text-gray-700 uppercase bg-indigo-100 border-b-2 border-slate-300">
              <tr>
                <th scope="col" class="px-6 py-3">
                  Usuario
                </th>
                <th scope="col" class="px-6 py-3">
                  Contraseña
                </th>
                <th scope="col" class="px-6 py-3">
                  Nombres
                </th>
                <th scope="col" class="px-6 py-3">
                  Apellidos
                </th>
                <th scope="col" class="px-6 py-3">
                  Cedula
                </th>
                <th scope="col" class="px-6 py-3">
                  Correo
                </th>
                <th scope="col" class="px-6 py-3">
                  MAC
                </th>
              </tr>
            </thead>
            <tbody>
              <FillTableVictimAttacker users={users} tipo={tipo}></FillTableVictimAttacker>
            </tbody>
          </table>
        </div>
  );
}


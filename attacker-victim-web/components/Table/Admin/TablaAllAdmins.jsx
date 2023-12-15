import FillTableAllAdmins from "./FillTableAllAdmins";

function TablaAllAdmins({ users }) {
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
              Correo
            </th>
            <th scope="col" class="px-6 py-3">
              ID
            </th>
          </tr>
        </thead>
        <tbody>
          <FillTableAllAdmins users={users}></FillTableAllAdmins>
        </tbody>
      </table>
    </div>
  );
}

export default TablaAllAdmins;

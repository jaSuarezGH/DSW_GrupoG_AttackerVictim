import FillTableAllNotification from "./FillTableAllNotification";

function TablaAllNotifications({ notifications }) {
  
  return (
    <div class="items-center flex relative overflow-x-auto ring-2 ring-slate-300 rounded-md">
      <table class="w-full text-sm text-center text-gray-500">
        <thead class="text-xs text-gray-700 uppercase bg-indigo-100 border-b-2 border-slate-300">
          <tr>
            <th scope="col" class="px-6 py-3">
              Tipo de Notificacion
            </th>
            <th scope="col" class="px-6 py-3">
              Correo del Usuario
            </th>
            <th scope="col" class="px-6 py-3">
              Username
            </th>
            <th scope="col" class="px-6 py-3">
              Cedula
            </th>
            <th scope="col" class="px-6 py-3">
              Fecha
            </th>
          </tr>
        </thead>
        <tbody>
          <FillTableAllNotification notifications={notifications}></FillTableAllNotification>
        </tbody>
      </table>
    </div>
  );
}

export default TablaAllNotifications;

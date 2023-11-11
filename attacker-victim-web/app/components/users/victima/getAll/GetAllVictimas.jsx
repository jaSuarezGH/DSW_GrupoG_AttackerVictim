"use client";


export function GetAllVictimas({ users }) {

  return (
    <div className="bg-white py-2 sm:py-10 ">
      <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-12 px-6 lg:px-8 ">
        <div className="block max-w-full">
        <span className=" items-center rounded-md bg-green-50 px-2 py-1 ml-2 mr-2 font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
            Victima
          </span>
          <h2 className="mt-3 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
            Usuarios Victima en el Sistema
          </h2>
          <p className="mt-6 text-lg leading-8 text-gray-600 block mb-2">
            Usuarios de tipo Victima registrados en el sistema.
          </p>
        </div>
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
              {users.map((person) => {
                if (person.tipo == 2) {
                  return (
                    <tr key={person.cedula} className="bg-gray-100 border-b-2">
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
                  );
                }               
              })}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

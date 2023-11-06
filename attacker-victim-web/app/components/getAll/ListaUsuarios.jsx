import React from "react";


const texto = ["Administrador", "Victima", "Atacante"];


const clase = [
  // Administrador
  "inline-flex py-1 items-center rounded-md bg-blue-50 px-2 text-xs font-medium text-blue-700 ring-1 ring-inset ring-blue-700/10",
  // Victima
  "inline-flex items-center rounded-md bg-green-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-green-700 ring-1 ring-inset ring-green-600/20",
  // Atacante
  "inline-flex items-center rounded-md bg-red-50 px-2 py-1 mb-3 mr-2 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10",
]

// Indica que tipo de usuario es
export const RecorrerTexto = (valor) => {

  for (let i = 0; i < texto.length; i++) {
    if (i == (valor -1)){ 
      return texto[i];
    }
  } 

}

export function ListaUsuarios({ users }) {
  return (
    <div className="bg-white py-2 sm:py-10 ">
      <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-12 px-6 lg:px-8 ">
        <div className="block max-w-full">
          <h2 className="text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
            Usuarios del Sistema
          </h2>
          <p className="mt-6 text-lg leading-8 text-gray-600 block mb-2">
            Usuarios tipo Administrador, Victima o Atacante registrados en el
            sistema.
          </p>
        </div>
        <div class="items-center flex relative overflow-x-auto ring-2 ring-slate-300 rounded-md">
          <table class="w-full text-sm text-center text-gray-500">
            <thead class="text-xs text-gray-700 uppercase bg-indigo-100 border-b-2 border-slate-300">
              <tr>
                <th scope="col" class="px-6 py-3">
                  Tipo
                </th>
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
              {users.map((person) => (
                <tr key={person.cedula} className="bg-gray-100 border-b-2">
                  <td class="px-6 py-4"> 
                    {React.createElement("span", { 
                      children: RecorrerTexto(person.tipo), 
                      className: clase[(person.tipo)-1] // -1 Para que apunte bien en el arreglo creado
                    })}
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
              ))}

            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

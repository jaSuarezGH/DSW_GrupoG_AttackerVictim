"use client";

export function ResponseVictima({user}) {

  const usuario = user;


  return (
    <div className="mb-6 ring-1 ring-opacity-50 ring-zinc-300 rounded-xl shadow-lg shadow-indigo-300 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto max-w-7xl gap-x-8 gap-y-12">
      <div className="block max-w-full mt-3">
        <span className=" items-center rounded-md bg-green-50 px-2 py-1 ml-2 mr-2 font-medium text-green-700 ring-1 ring-inset ring-green-600/20">
          Victima
        </span>
        <h2 className="mt-3 text-3xl font-bold tracking-tight text-gray-900">
          Datos de la Victima
        </h2>
        <p className="mt-4 mb-2 text-sm leading-8 text-gray-600 block">
          Todos los datos del usuario tipo Victima consultado.
        </p>
      </div>

      <div className="border-t border-gray-100">
        {usuario.map((person) => {
          <dl className="divide-y divide-gray-100" key={person.cedula}>
            <div className="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
              <dt className="font-medium leading-6 text-gray-900">Nombres</dt>
              <dd className="mt-1 leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
                {person.nombres}
              </dd>
            </div>
            <div className="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
              <dt className=" font-medium leading-6 text-gray-900">
                Apellidos
              </dt>
              <dd className="mt-1 leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
                {person.apellidos}
              </dd>
            </div>
            <div className="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
              <dt className="font-medium leading-6 text-gray-900">Username</dt>
              <dd className="mt-1 leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
                {person.username}
              </dd>
            </div>
            <div className="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
              <dt className="font-medium leading-6 text-gray-900">
                Contraseña
              </dt>
              <dd className="mt-1 leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
                {person.contraseña}
              </dd>
            </div>
            <div className="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
              <dt className="font-medium leading-6 text-gray-900">
                Correo Electronico
              </dt>
              <dd className="mt-1 leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
                {person.correo}
              </dd>
            </div>
            <div className="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
              <dt className="font-medium leading-6 text-gray-900">Cedula</dt>
              <dd className="mt-1 leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
                {person.cedula}
              </dd>
            </div>
            <div className="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
              <dt className="font-medium leading-6 text-gray-900">
                Direccion MAC
              </dt>
              <dd className="mt-1 leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
                {person.MAC}
              </dd>
            </div>
          </dl>;
        })}
      </div>
    </div> 
  );
}

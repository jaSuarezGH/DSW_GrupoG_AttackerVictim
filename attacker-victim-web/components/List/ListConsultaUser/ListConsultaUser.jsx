export function ListConsultaUser({ user }) {
  return (
    <div className="border-t border-gray-100">
      {user.map((person) => {
        <dl className="divide-y divide-gray-100" key={person.cedula}>
          <div className="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
            <dt className="font-medium leading-6 text-gray-900">Nombres</dt>
            <dd className="mt-1 leading-6 text-gray-700 sm:col-span-2 sm:mt-0">
              {person.nombres}
            </dd>
          </div>
          <div className="px-4 py-6 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
            <dt className=" font-medium leading-6 text-gray-900">Apellidos</dt>
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
            <dt className="font-medium leading-6 text-gray-900">Contraseña</dt>
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
  );
}

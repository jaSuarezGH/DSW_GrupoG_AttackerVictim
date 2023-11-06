export function ErrorConexion() {
    return (
      <>
        <main className="grid min-h-full place-items-center bg-white px-6 py-24 sm:py-16 lg:px-8">
        <div className="sm:mx-auto sm:w-full sm:max-w-sm">
          <img
            className="mx-auto h-44 w-auto"
            src="/logo.png"
            alt="AttackVictim"
          />
          </div>
          <div className="text-center">
            <p className="text-xl font-semibold text-indigo-600">Error 404</p>
            <h1 className="mt-4 text-5xl font-bold tracking-tight text-gray-900 sm:text-6xl">Pagina no encontrada</h1>
            <p className="mt-6 text-base leading-7 text-gray-600">Lo siento, el enlace ingresado no es valido o no se encuentra disponible.</p>
            <div className="mt-10 flex items-center justify-center gap-x-6">
              <a
                href="/"
                className="ml-7 rounded-md bg-indigo-600 px-6 py-3 text-lg font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
              >
                Volver a intentar
              </a>
            </div>
          </div>
        </main>
      </>
    )
  }
  

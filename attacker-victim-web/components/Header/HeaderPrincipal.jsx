export function HeaderPrincipal({texto}) {
  return (
    <header className="border-b-2 bg-white shadow">
      <div className="mx-auto max-w-full px-4 py-6 sm:px-6 lg:px-8">
        <h1 className="ml-4 text-3xl font-bold tracking-tight text-gray-900">
          {texto}
        </h1>
      </div>
    </header>
  );
}

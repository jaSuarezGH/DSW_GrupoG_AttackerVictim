export function DivImageHeader({title, description = ''}) {
  return (
    <div className="sm:mx-auto sm:w-full sm:max-w-md">
      <img
        className="mx-auto h-40 w-auto mt-0 pt-0"
        src="/logo.png"
        alt="Logo"
      />
      <h2 className=" text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
        {title}
      </h2>
      <p className="mt-6 text-sm text-center leading-7 text-gray-600">
        {description}
      </p>
    </div>
  );
}

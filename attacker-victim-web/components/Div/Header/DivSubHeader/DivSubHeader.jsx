export function DivSubHeader({ title, description }) {

  return (
    <div className="border-b border-gray-900/10 pb-3 pt-2">
      <h3 className="text-lg font-semibold leading-7 text-gray-900">
        {title}
      </h3>
      <p className="mt-1 text-sm leading-6 text-gray-600">
        {description}
      </p>
    </div>
  );
}

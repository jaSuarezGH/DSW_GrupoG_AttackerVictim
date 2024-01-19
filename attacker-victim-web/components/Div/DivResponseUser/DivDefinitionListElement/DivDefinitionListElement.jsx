export function DivDefinitionListElement({title, value}) {
  return (
    <div className="px-6 py-8 mb-2 sm:grid sm:grid-cols-3 sm:gap-4 sm:px-0">
            <dt className="font-bold leading-6 text-gray-900 text-lg">{title}</dt>
            <dd className="leading-6 text-gray-700 sm:col-span-2 sm:mt-0 text-lg">
              {value}
            </dd>
    </div>
  )
}

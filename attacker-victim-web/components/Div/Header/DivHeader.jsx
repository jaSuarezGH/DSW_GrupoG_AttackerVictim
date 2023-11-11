import { RecorrerTags } from "@/components/Tag";



export function DivHeader({title, description, tags}) {
    
      const tagsMostradas = RecorrerTags(tags);

  return (
    <div className="block max-w-full pb-3 border-b-2 px-4">
        {tagsMostradas.map((tag) => (<>{ tag }</>))}
          <h2 className="text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
            {title}
          </h2>
          <p className="mt-6 text-lg leading-8 text-gray-600 block mb-2">
            {description}
          </p>
        </div>
  )
}


import Link from "next/link";
import { RecorrerTags } from "../Tag";
import { AggEstilo } from "./AggEstilo";



export function Card({ title, description, link, tags }) {
  
  const tagsMostradas = RecorrerTags(tags);

  
  return (
    <Link
      href={link}
      className = {AggEstilo(tags)}
    >
      {/* Recorre con Map el arreglo de etiquetas que van para esta card */}
      {tagsMostradas.map((tag) => (
        <>{tag}</>
      ))}
      <h3 class=" text-left mb-2 text-lg font-bold leading-tight ">{title}</h3>
      <p class=" text-left text-sm text-gray-600">{description}</p>
    </Link>
  );
}

export default Card;

// Permite recorrer y asignar que etiquetas se van a mostrar en este elemento card.

import { listaTags } from "..";

export const RecorrerTags = (tags) => {
    const etiquetasMostradas = [];
    for (const valor of tags) {
      for (const tag of listaTags) {
        if (tag.valor === valor) {
          etiquetasMostradas.push(tag.etiqueta);
        }
      }
    }
    return etiquetasMostradas;
  };
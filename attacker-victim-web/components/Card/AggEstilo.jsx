import { estiloCard } from "./models/EstiloCard.model";

export const AggEstilo = (tags) => {

  const orderTags = tags.sort();
  if (orderTags[0] === 1) return estiloCard[0];
  else if (orderTags[0] === 2) {
    if (orderTags[1] === 3) return estiloCard[3];
    return estiloCard[1];
  }
  return estiloCard[2];
};

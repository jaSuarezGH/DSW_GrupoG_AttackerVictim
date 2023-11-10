
async function FetchGetAllUsers() {
  // Revalidate significa que comprueba la data cada x segundos, y la actualiza de ser el caso
  return await fetch("https://big-famous-raccoon.ngrok-free.app/testAPI/api/productos", {
    next: { revalidate: 20 },
  }).then((res) => res.json());
}

export async function UsersFetch() {
  return await FetchGetAllUsers();
}

import { ButtonRedirect } from "@/components/Button/ButtonRedirect";
import { DivHeader } from "@/components/Div";
import { ListConsultaUser } from "@/components/List/ListConsultaUser/ListConsultaUser";

export function DivResponseUser({ user, title, description, tags }) {
  return (
    <>
      <div className="max-w-6xl mb-6 ring-1 ring-opacity-50 ring-zinc-300 rounded-xl shadow-lg shadow-indigo-300 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto gap-x-8 gap-y-12">
        <DivHeader
          title={title}
          description={description}
          tags={tags}
        ></DivHeader>

        <ListConsultaUser user={user}></ListConsultaUser>
      </div>
    </>
  );
}

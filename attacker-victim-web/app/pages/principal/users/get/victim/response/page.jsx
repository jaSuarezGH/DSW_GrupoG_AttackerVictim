import { DivHeader } from "@/components/Div";
import { ListConsultaUser } from "@/components/List/ListConsultaUser/ListConsultaUser";
import { Navigation } from "@/components/Navigation";

export default function victimaResponsePage({ user }) {

  return (
    <>
      <Navigation number={1}></Navigation>

      <div className="mb-6 ring-1 ring-opacity-50 ring-zinc-300 rounded-xl shadow-lg shadow-indigo-300 mt-6 flex min-h-full flex-1 flex-col justify-center align-middle px-6 py-6 lg:px-8 mx-auto max-w-7xl gap-x-8 gap-y-12">
        <DivHeader
          title="Victima"
          description="Todos los datos del usuario tipo Victima consultado."
          tags={[2]}
        ></DivHeader>

        <ListConsultaUser user={user}></ListConsultaUser>
        
      </div>
    </>
  );
}

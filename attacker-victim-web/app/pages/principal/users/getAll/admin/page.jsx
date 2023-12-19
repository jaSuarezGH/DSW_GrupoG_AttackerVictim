import { fetchGetDelete } from "../../fetch/fetchGetDelete";
import { Navigation } from "@/components/Navigation";
import { DivHeader } from "@/components/Div";
import { endGetAllAdmins } from "@/app/models/endpoint.model";
import TablaAllAdmins from "@/components/Table/Admin/TablaAllAdmins";

export default async function getAllAdminsPage() {
  const users = await fetchGetDelete(endGetAllAdmins);

  return (
    <>
      <Navigation number={0}></Navigation>

      <div className="bg-white py-2 sm:py-10 ">
        <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-12 px-6 lg:px-8 ">
          <DivHeader
            title="Usuarios Administradores en el Sistema"
            description="Usuarios de tipo Adminstrador registrados en el sistema."
            tags={[1]}
          ></DivHeader>

          <TablaAllAdmins users={users}></TablaAllAdmins>
        </div>
      </div>
    </>
  );
}

import { DivHeader } from "@/components/Div";
import { Navigation } from "@/components/Navigation";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import TablaAllUsers from "@/components/Table/AllUsers/TablaAllUsers";
import { endGetAllUsers } from "@/app/models/endpoint.model";
import { Suspense } from "react";
import Loading from "@/components/Loading/Loading";

export default async function UsersPage() {
  const users = await fetchGetDelete(endGetAllUsers);

  return (
    <>
      <Navigation number={0}></Navigation>

      <div className="bg-white py-2 sm:py-10 ">
        <div className="mx-auto grid max-w-full gap-x-8 gap-y-12 px-6 lg:px-8 ">
          <DivHeader
            title="Usuarios Victima/Atacante del Sistema"
            description="Usuarios de tipo Victima o Atacante registrados en el
            sistema."
            tags={[2, 3]}
          ></DivHeader>
          <Suspense fallback={<Loading />}>
            <TablaAllUsers users={users}></TablaAllUsers>
          </Suspense>
        </div>
      </div>
    </>
  );
}

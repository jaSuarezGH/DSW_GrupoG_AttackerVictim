import { Navigation } from "@/components/Navigation";
import { DivHeader } from "@/components/Div";
import { fetchGetDelete } from "@/app/pages/principal/fetch/fetchGetDelete";
import { endGetAllVictims } from "@/app/models/endpoint.model";
import TablaAllVictimsAttackers from "@/components/Table/VictimAttacker/TablaVictimAttacker";

export default async function getAllVictimasPage() {
  const users = await fetchGetDelete(endGetAllVictims);

  return (
    <>
      <Navigation number={1}></Navigation>

      <div className="bg-white py-2 sm:py-10 ">
        <div className="mx-auto grid max-w-full gap-x-8 gap-y-12 px-6 lg:px-8 ">
          <DivHeader
            title="Usuarios Victima en el Sistema"
            description="Usuarios de tipo Victima registrados en el sistema."
            tags={[2]}
          ></DivHeader>

          <TablaAllVictimsAttackers users={users}></TablaAllVictimsAttackers>
        </div>
      </div>
    </>
  );
}

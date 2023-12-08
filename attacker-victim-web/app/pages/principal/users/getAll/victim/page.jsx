import { Navigation } from "@/components/Navigation";
import { DivHeader } from "@/components/Div";
import { TablaVictimAttacker } from "@/components/Table/VictimAttacker/TablaVictimAttacker";
import { UsersFetch } from "../../fetch/UsersFetch";
import { endGetAllUsers } from "@/app/models/endpoint.model";

export default async function getAllVictimasPage() {
  const users = await UsersFetch(endGetAllUsers);

  return (
    <>
      <Navigation number={1}></Navigation>

      <div className="bg-white py-2 sm:py-10 ">
        <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-12 px-6 lg:px-8 ">
          <DivHeader
            title="Usuarios Victima en el Sistema"
            description="Usuarios de tipo Victima registrados en el sistema."
            tags={[2]}
          ></DivHeader>

          <TablaVictimAttacker users={users} tipo={2}></TablaVictimAttacker>
        </div>
      </div>
    </>
  );
}

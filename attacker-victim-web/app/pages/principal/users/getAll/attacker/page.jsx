
import { UsersFetch } from '../../fetch/UsersFetch';
import { Navigation } from '@/components/Navigation';
import { DivHeader } from '@/components/Div';
import { TablaVictimAttacker } from '@/components/Table/VictimAttacker/TablaVictimAttacker';
import { endGetAllUsers } from '@/app/models/endpoint.model';

export default async function getAllVictimasPage() {

    const users = await UsersFetch(endGetAllUsers);

  return <>
  <Navigation number={2}></Navigation>

  <div className="bg-white py-2 sm:py-10 ">
      <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-12 px-6 lg:px-8 ">
        <DivHeader title='Usuarios Atacante en el Sistema' description='Usuarios de tipo Atacante registrados en el sistema.' tags={[3]}></DivHeader>
        
        <TablaVictimAttacker users={users} tipo={3}></TablaVictimAttacker>
        
      </div>
    </div>
  </>
}

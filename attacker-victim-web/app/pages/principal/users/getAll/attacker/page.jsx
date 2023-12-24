
import { fetchGetDelete } from '@/app/pages/principal/fetch/fetchGetDelete';
import { Navigation } from '@/components/Navigation';
import { DivHeader } from '@/components/Div';
import { endGetAllAttackers } from '@/app/models/endpoint.model';
import TablaAllVictimsAttackers from '@/components/Table/VictimAttacker/TablaVictimAttacker';

export default async function getAllAttackersPage() {

    const users = await fetchGetDelete(endGetAllAttackers);

  return <>
  <Navigation number={2}></Navigation>

  <div className="bg-white py-2 sm:py-10 ">
      <div className="mx-auto grid max-w-7xl gap-x-8 gap-y-12 px-6 lg:px-8 ">
        <DivHeader title='Usuarios Atacante en el Sistema' description='Usuarios de tipo Atacante registrados en el sistema.' tags={[3]}></DivHeader>
        
        <TablaAllVictimsAttackers users={users}></TablaAllVictimsAttackers>
        
      </div>
    </div>
  </>
}

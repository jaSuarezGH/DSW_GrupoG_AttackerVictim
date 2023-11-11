'use client'

import {Navegacion} from '@/app/components/compartido/Navegacion';
import {ResponseVictima} from '@/app/components/users/victima/get/ResponseVictima'


export default function victimaResponse() {

  return <> 
  <Navegacion number={1}></Navegacion>
  <ResponseVictima user={user}></ResponseVictima>
  </>
}

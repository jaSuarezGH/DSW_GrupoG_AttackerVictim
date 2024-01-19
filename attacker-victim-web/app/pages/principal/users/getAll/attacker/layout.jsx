
import { Navigation } from '@/components/Navigation';


export const metadata = {
  title: 'Consultar Todos los Atacantes | AttackVictim',
}

export default function getAllAttackersLayout({ children }) {
  return (
    <html lang="es">
      <body >
      <Navigation number={2}></Navigation>
        {children}
        </body>
    </html>
  );
}

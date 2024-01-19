
import { Navigation } from '@/components/Navigation';


export const metadata = {
  title: 'Attackers | AttackVictim',
}

export default function attackersSectionLayout({ children }) {
  return (
    <html lang="es">
      <body >
      <Navigation number={2}></Navigation>
        {children}
        </body>
    </html>
  );
}

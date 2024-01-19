
import { Navigation } from '@/components/Navigation';


export const metadata = {
  title: 'Consultar Todas Las Victimas | AttackVictim',
}

export default function getAllVictimLayout({ children }) {
  return (
    <html lang="es">
      <body >
      <Navigation number={1}></Navigation>
        {children}
        </body>
    </html>
  );
}

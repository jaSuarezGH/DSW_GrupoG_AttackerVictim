
import { Navigation } from '@/components/Navigation';


export const metadata = {
  title: 'Victims | AttackVictim',
}

export default function victimsSectionLayout({ children }) {
  return (
    <html lang="es">
      <body >
      <Navigation number={1}></Navigation>
        {children}
        </body>
    </html>
  );
}

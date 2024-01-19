import { Navigation } from '@/components/Navigation';


export const metadata = {
  title: 'Inicio | AttackVictim',
}

export default function victimsSectionLayout({ children }) {
  return (
    <html lang="es">
      <body >
      <Navigation></Navigation>
        {children}
        </body>
    </html>
  );
}

import { Navigation } from '@/components/Navigation';


export const metadata = {
  title: 'Usuarios | AttackVictim',
}

export default function getAllLayout({ children }) {
  return (
    <html lang="es">
      <body >
      <Navigation></Navigation>
        {children}
        </body>
    </html>
  );
}

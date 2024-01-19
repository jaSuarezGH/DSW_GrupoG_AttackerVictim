
import { Navigation } from '@/components/Navigation';


export const metadata = {
  title: 'Consultar Todos los Administradores | AttackVictim',
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

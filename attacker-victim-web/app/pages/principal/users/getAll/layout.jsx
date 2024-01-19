import { Navigation } from '@/components/Navigation';


export const metadata = {
  title: 'Obtener Usuarios | AttackVictim',
}

export default function InicioLayout({ children }) {
  return (
    <html lang="es">
      <body>
      <Navigation></Navigation>
        {children}
        </body>
    </html>
  );
}
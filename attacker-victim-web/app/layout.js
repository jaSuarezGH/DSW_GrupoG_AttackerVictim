import './styles/globals.css'
import { Montserrat } from 'next/font/google'

const montserrat = Montserrat({ subsets: ['latin'] })

export const metadata = {
  title: 'AttackVictim',
  description: 'Sistema Web de AttackVictim',
}

// Aplicae en el className para ponerle la fuente: ${montserrat.className} antialiased

export default function RootLayout({ children }) {
  return (
    <html lang="es" className=" bg-white">
      <body className={`h-full`}>
        {children}
        </body>
    </html>
  );
}

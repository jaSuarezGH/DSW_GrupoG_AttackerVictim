import './styles/globals.css'
import { Montserrat } from 'next/font/google'

const montserrat = Montserrat({ subsets: ['latin'] })

export const metadata = {
  title: 'AttackVictim',
  description: 'Sistema Web de AttackVictim',
}

export default function RootLayout({ children }) {
  return (
    <html lang="es" className=" bg-white">
      <body className={`${montserrat.className} antialiased`} class="h-full">
        {children}
        </body>
    </html>
  );
}

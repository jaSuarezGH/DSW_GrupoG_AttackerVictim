import './styles/globals.css'
import { Inter } from 'next/font/google'

const inter = Inter({ subsets: ['latin'] })

export const metadata = {
  title: 'AttackVictim',
  description: 'Sistema Web de AttackVictim',
}

export default function RootLayout({ children }) {
  return (
    <html lang="es" className=" bg-white">
      <body className={inter.className} class="h-full">
        {children}
        </body>
    </html>
  );
}

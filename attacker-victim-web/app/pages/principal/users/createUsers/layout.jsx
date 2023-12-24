import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Crear Victima/Atacante - AttackVictim",
};

export default function CrearUsersLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={0}></Navigation>
        {children}
      </body>
    </html>
  );
}

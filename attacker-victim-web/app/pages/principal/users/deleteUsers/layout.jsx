import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Eliminar Victima/Atacante - AttackVictim",
};

export default function deleteUsersLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={0}></Navigation>
        {children}
      </body>
    </html>
  );
}

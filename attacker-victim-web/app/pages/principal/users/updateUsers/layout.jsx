import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Modificar Victima/Atacante - AttackVictim",
};

export default function UpdateUsersLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={0}></Navigation>
        {children}
      </body>
    </html>
  );
}

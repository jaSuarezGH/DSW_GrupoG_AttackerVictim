import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Modificar Relacion Victima/Atacante - AttackVictim",
};

export default function updateIncidentLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={0}></Navigation>
        {children}
      </body>
    </html>
  );
}

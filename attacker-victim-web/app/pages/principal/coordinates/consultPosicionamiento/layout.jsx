import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Consultar Posicionamiento - AttackVictim",
};

export default function consultPosicionamientoLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={3}></Navigation>
        {children}
      </body>
    </html>
  );
}

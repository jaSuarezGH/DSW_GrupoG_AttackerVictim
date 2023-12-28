import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Crear Zona Segura - AttackVictim",
};

export default function createZSLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={1}></Navigation>
        {children}
      </body>
    </html>
  );
}

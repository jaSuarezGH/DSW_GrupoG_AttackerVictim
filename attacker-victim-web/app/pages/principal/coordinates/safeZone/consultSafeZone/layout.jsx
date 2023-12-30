import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Consultar Zona Segura - AttackVictim",
};

export default function consultZSLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={1}></Navigation>
        {children}
      </body>
    </html>
  );
}

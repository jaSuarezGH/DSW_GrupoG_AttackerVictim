import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Eliminar Zona Segura - AttackVictim",
};

export default function deleteZSLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={1}></Navigation>
        {children}
      </body>
    </html>
  );
}

import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Conexion de Usuarios - AttackVictim",
};

export default function statusLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={0}></Navigation>
        {children}
      </body>
    </html>
  );
}

import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Crear Administrador - AttackVictim",
};

export default function CreateAdminLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={0}></Navigation>
        {children}
      </body>
    </html>
  );
}

import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Modificar Administrador - AttackVictim",
};

export default function UpdateAdminLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={0}></Navigation>
        {children}
      </body>
    </html>
  );
}

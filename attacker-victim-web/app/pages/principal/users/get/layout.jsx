import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Consultar un Usuario - AttackVictim",
};

export default function PrincipalLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={0}></Navigation>
        {children}
      </body>
    </html>
  );
}

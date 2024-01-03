import { Navigation } from "@/components/Navigation";

export const metadata = {
  title: "Historial de Notificaciones - AttackVictim",
};

export default function historialNotificationLayout({ children }) {
  return (
    <html>
      <body>
        <Navigation number={4}></Navigation>
        {children}
      </body>
    </html>
  );
}

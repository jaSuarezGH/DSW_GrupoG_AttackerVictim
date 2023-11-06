import {enlace} from '@/app/components/conexion/Enlace'

export async function ValidarCredenciales() {
    
    const validacion = await fetch(enlace + "/testAPI/api/productos")
                .then((response) => {
                  if (response.ok) {
                    alert("OK");
                    //router.push("pages/login");
                  }
                })
                .catch((error) => {
                  if (error.message === "Failed to fetch")
                    router.push("pages/errorConexion");
                });
}
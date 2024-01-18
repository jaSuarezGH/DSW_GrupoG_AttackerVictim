import * as Location from 'expo-location';
import NetInfo from "@react-native-community/netinfo";
import { setupDatabase } from '../../../Data/local/SQLite/sqlite';
import { GuardarCoordenadasSQL } from '../../../Domain/useCases/GuardarCoordenadas';
import { ObtenerCoordenadasSQL } from '../../../Domain/useCases/ObtenerCoordenadasGuardadas';
import { Alert } from 'react-native';
import { EliminarUsuarioCoordenadas } from '../../../Domain/useCases/EliminarCoordenadasGuardadas';
import { PostUsuarioCoordenadas } from '../../../Domain/useCases/EnviarCoordenadas';
import { Gyroscope } from 'expo-sensors';
import { ObtenerAtacanteZonaSegura } from '../../../Domain/useCases/ObtenerAtacanteZonaSegura';
import { ObtenerIncidenteAtacante } from '../../../Domain/useCases/ObtenerIncidenciaAtacante';
import { PostUsuarioNotificacion } from '../../../Domain/useCases/EnviarNotificacion';
import * as Notifications from 'expo-notifications';
import { obtenerAtacantePorID } from '../../../Domain/useCases/ObtenerAtacanteID';

//Variable global attackerID proveniente de viewLogin

export const principalViewModel = () => {
    let gyroStatus = 'MOBILE';
    let statusInmovil = 0;
    let incidente = null;
    let userStatus = null;

    const manejoNotificaciones = () => {

      Notifications.setNotificationHandler({
        handleNotification: async () => ({
          shouldShowAlert: true,
          shouldPlaySound: true,
          shouldSetBadge: false,
        }),
      });
  
      const registroDeNotificaciones = async () => {
        let token;
          const { status: existingStatus } = await Notifications.getPermissionsAsync();
          let finalStatus = existingStatus;
          if (existingStatus !== 'granted') {
            const { status } = await Notifications.requestPermissionsAsync();
            finalStatus = status;
          }
          if (finalStatus !== 'granted') {
            alert('Failed to get push token for push notification!');
            return;
          }
          token = (await Notifications.getExpoPushTokenAsync({ projectId: 'a7c0421e-bec5-4aab-92c2-a4cadf0110e1' })).data;
        return token;
      };

      const inicializarNotificaciones = async (setNotification,notificationListener,responseListener) => {
        notificationListener.current = Notifications.addNotificationReceivedListener(notification => {
          setNotification(notification);
        });
    
        responseListener.current = Notifications.addNotificationResponseReceivedListener(response => {
          console.log(response);
        });
      };

      const finalizarNotificaciones = async (notificationListener,responseListener) => {
        Notifications.removeNotificationSubscription(notificationListener.current);
        Notifications.removeNotificationSubscription(responseListener.current);
      }; 
  
      async function mandarNotificacion(titulo, cuerpo) {
        await Notifications.scheduleNotificationAsync({
          content: {
            title: titulo,
            body: cuerpo,
          },
          trigger: { seconds: 2 },
        });
      };

      return {registroDeNotificaciones,inicializarNotificaciones,finalizarNotificaciones,mandarNotificacion};
    };

    const obtenerIncidenciaAtacante = async () => {
      if (incidente === null){
        try {
          const incidenteAtacante = await ObtenerIncidenteAtacante(attackerID);
          if (incidenteAtacante.status === 200){
             incidente = incidenteAtacante;
          };
        } catch (error){
          Alert.alert('Error al obtener la incidencia del atacante.',error.message);
        };
      }
    };
    
    
    const funcionDemonio = (mandarNotificacion) => {
      setupDatabase();

      const obtenerLocalizacion = async () => {
        try {
          let { status } = await Location.requestForegroundPermissionsAsync();
          if (status !== 'granted') {
            console.log('Permiso denegado para acceder a la ubicación');
            return;
          }
          localizacionActual = await Location.getCurrentPositionAsync({});
          return localizacionActual;
        } catch (error) {
          console.log('Error al obtener la ubicación:', error);
        };
      };


      const enviarNotificaciones = async(tipoNotificacion) => {
        try{
          const notificacion = {
            "_status": tipoNotificacion,
            "_user": {
              "id": userID
            }
          };
          await PostUsuarioNotificacion(notificacion); 
        }catch(error){
          Alert.alert(error.message);
        }
      };

      const obtenerStatusGiroscopio = async () => {
        const listener = Gyroscope.addListener(({ x, y, z }) => {
          if (Math.abs(x) < 0.009 && Math.abs(y) < 0.009 && Math.abs(z) < 0.009) {
            statusInmovil = statusInmovil + 1;
          } else {
            statusInmovil = 0;
          }
          if (statusInmovil >= 3) {
            gyroStatus = 'INMOBILE';
          } else {
            gyroStatus = 'MOBILE';
          }
          Gyroscope.removeAllListeners();
        });
        if (gyroStatus === 'INMOBILE'){
          await enviarNotificaciones('Atacante Inmovil');
        }
      };

      const verificarAtacanteZonaSegura = async () => {
        try {
          const atacanteZona = await ObtenerAtacanteZonaSegura(incidente.data.response.id);
          if (atacanteZona.status === 200){
            if (atacanteZona.data.response._inside === true){
              mandarNotificacion('INGRESO A ZONA SEGURA','Por favor salga inmediatamente o se le notificara a las autoridades.')
              await enviarNotificaciones('Atacante en una Zona Segura.');
            };
          };
        } catch (error){
          Alert.alert('Error al obtener si el atacante se encuentra en una zona segura: ',error.message);
        };
      };

      const generarCoordenada = (latitud, longitud, status, fecha) =>{
        const coordenadas = { 
          _full_date: fecha, 
          _status: status, 
          _latitude: latitud,
          _longitude: longitud,
          _user: {
            id: userID,
          }
        };  
        return coordenadas;
      };

      const verificarStatusUsuario = async () =>{
        try {
          userStatus = await obtenerAtacantePorID(attackerID);
          if (userStatus !== null){
            if (userStatus.data.response._active === false){
              Alert.alert('Su cuenta ha sido desactivada por un administrador.');
              return false;
            } else{
              console.log('Usuario activo');
              return true;
            }
          };
        } catch (error){ 
          Alert.alert('Error al verificar el status del usuario.',error.message);
        }
      };

      const enviarCoordenadas = async (coordenadas) => {
        try {
          const response = await PostUsuarioCoordenadas(coordenadas);
          if (response.status === 200) {
            console.log('Ubicación enviada con éxito');
          }else if(response.status === 500) {
            Alert.alert('Ocurrió un error al enviar la ubicación');
          }
        } catch (error) {
          Alert.alert('Ocurrior un error inesperado:', error.message);
        }      
      };

      const verificarConexionInternet = async (setConexionInternet) => {
        //Obtenemos la fecha actual en milisegundos
        var fecha = new Date();
        var milisegundos = Date.parse(fecha);

        //Verificamos si hay conexión a internet
        const netInfo = await NetInfo.fetch();
        let online = netInfo.isConnected && netInfo.isInternetReachable;
        
        //En la primera consulta de red devuelve null por eso asigno true si es null
        if (online === null){
          online = true;
        }

        setConexionInternet(online);

        await obtenerStatusGiroscopio();

        let localizacionTelefono = await obtenerLocalizacion();

        if (online) {
          let resultado = await verificarStatusUsuario();
          if (resultado){
            const locationSQL = await ObtenerCoordenadasSQL();
            //Si hay datos en la base de datos procedemos a enviarlos a la api 
            if (locationSQL.length > 0){
              for (let location of locationSQL) {
                await enviarCoordenadas(generarCoordenada(location.latitude,location.longitude,'OFFLINE',location.fecha));
              };
              EliminarUsuarioCoordenadas()
                .then((deleted) => {
                  if (!deleted) {
                    console.log('No se lograron eliminar las ubicaciones.');
                  }
                })
                .catch((error) => {
                  Alert.alert('Ocurrió un error al eliminar las ubicaciones:', error);
                });  
            } else {
              await enviarCoordenadas(generarCoordenada(localizacionTelefono.coords.latitude,localizacionTelefono.coords.longitude,gyroStatus,milisegundos));
              await verificarAtacanteZonaSegura(incidente);
            };
          }else{
            navigation.navigate('VistaLogin');
          }
        } else {
          GuardarCoordenadasSQL(generarCoordenada(localizacionTelefono.coords.latitude,localizacionTelefono.coords.longitude,'OFFLINE',milisegundos))
          .then((wasSuccessful) => {
            if (!wasSuccessful) {
              console.log('No se pudo guardar la ubicación.');
            }
         })
          .catch((error) => {
            Alert.alert('Ocurrió un error al guardar la ubicación:', error);
          });
        };
      };
      return {verificarConexionInternet};
    };

    return {funcionDemonio,obtenerIncidenciaAtacante,manejoNotificaciones};
};


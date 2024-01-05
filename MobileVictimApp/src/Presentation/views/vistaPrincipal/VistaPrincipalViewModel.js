import * as Location from 'expo-location';
import NetInfo from "@react-native-community/netinfo";
import { setupDatabase } from '../../../Data/local/SQLite/sqlite';
import { GuardarCoordenadasSQL } from '../../../Domain/useCases/GuardarCoordenadas';
import { ObtenerCoordenadasSQL } from '../../../Domain/useCases/ObtenerCoordenadasGuardadas';
import { useEffect, useState } from 'react';
import { Alert } from 'react-native';
import { EliminarUsuarioCoordenadas } from '../../../Domain/useCases/EliminarCoordenadasGuardadas';
import { PostUsuarioCoordenadas } from '../../../Domain/useCases/EnviarCoordenadas';
import { Gyroscope } from 'expo-sensors';
import { ObtenerZonasSegurasID } from '../../../Domain/useCases/ObtenerZonasSeguras';
import { ObtenerIncidenteVictima } from '../../../Domain/useCases/ObtenerIncidenciaVictima';
import { obtenerDistanciaVictimaAgresor } from '../../../Domain/useCases/ObtenerDistanciaVictimaAgresor';
import { obtenerAtacanteZonaSegura } from '../../../Domain/useCases/ObtenerAtacanteZonaSegura';
import { PostUsuarioNotificacion } from '../../../Domain/useCases/EnviarNotificacion';
import * as Notifications from 'expo-notifications';
import { Linking } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import { Vibration } from 'react-native';
import { Audio } from 'expo-av';

export const principalViewModel = () => {
    let gyroStatus = 'MOBILE';
    let statusInactive = 0;
    let incidente = null;
    const navigation = useNavigation();



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
          token = (await Notifications.getExpoPushTokenAsync({ projectId: '4c457148-9e65-449e-bb37-c46509153175' })).data;
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

    const gestionarZonasSeguras = async () => {
      let zonasSeguras = [];
      try {
        const zonas = await ObtenerZonasSegurasID(userID);
        if (zonas.status === 200){
          let nombreZona = zonas.data.response[0]._name;
          let coordenadasZonaSegura = [];
          for (let datosApi of zonas.data.response) {
            if (nombreZona === datosApi._name){
              coordenadasZonaSegura.push({latitude: datosApi._coordinate._latitude, longitude: datosApi._coordinate._longitude});
            } else {
              zonasSeguras.push({_name: nombreZona, _coordinates: coordenadasZonaSegura});
              nombreZona = datosApi._name;
              coordenadasZonaSegura = [{latitude: datosApi._coordinate._latitude, longitude: datosApi._coordinate._longitude}];
            };
          };      
          zonasSeguras.push({_name: nombreZona, _coordinates: coordenadasZonaSegura}); // para la última zona
        };
        return zonasSeguras;
      } catch (error){
        Alert.alert('Error al obtener las zonas seguras',error.message);
      }
    };

    const navegarVistaPuntoControl = () =>{
      navigation.navigate('VistaPuntoControl');
    }

    const obtenerIncidenciaVictima = async () => {
      if (incidente === null){
        try {
          const incidenteVictima = await ObtenerIncidenteVictima(victimID);
          if (incidenteVictima.status === 200){
             incidente = incidenteVictima;
          };
        } catch (error){
          Alert.alert('Error al obtener las zonas seguras',error.message);
        };
      }
    };

    async function sonarAlerta() {
      const { sound } = await Audio.Sound.createAsync(
          require('../../../../assets/red-alert.mp3')
      );
      await sound.playAsync();
    };

    const obtenerLocalizacionMapa = () => {
      const [initialLocation, setInitialLocation] = useState(null);
      const [currentLocation, setCurrentLocation] = useState(null);
  
      useEffect(() => {
          (async () => {
              let { status } = await Location.requestForegroundPermissionsAsync();
              if (status !== 'granted') {
                  alert('Permiso de acceso a la ubicación denegado');
                  return;
              }
  
              let locationSubscription = await Location.watchPositionAsync({
                  accuracy: Location.Accuracy.High,
                  timeInterval: 120000,
                  distanceInterval: 8,
              }, (newLocation) => {
                  if (!initialLocation) {
                      setInitialLocation(newLocation);
                  }
                  setCurrentLocation(newLocation);
              });
  
              return () => {
                  if (locationSubscription) {
                      locationSubscription.remove();
                  }
              };
          })();
      }, []);
      return { initialLocation, currentLocation, setInitialLocation };
    };

    const llamadaSOS = () => {
        let numeroTelefono = '911'; 

        // Asegúrate de incluir el prefijo 'tel:' antes del número de teléfono
        let urlTelefono = `tel:${numeroTelefono}`;

        // Comprueba si la aplicación puede manejar la URL del teléfono
        Linking.canOpenURL(urlTelefono)
            .then(supported => {
                if (!supported) {
                    console.log('No se puede llamar a ' + urlTelefono);
                } else {
                    return Linking.openURL(urlTelefono);
                }
            })
            .catch(err => console.error('Ocurrió un error', err));
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
          console.log('Error al obtener la ubicación:', error.message);
        }
      };

      const enviarNotificaciones = async(tipoNotificacion) => {
        try{
          const notificacion = {
            "_status": tipoNotificacion,
            "_user": {
              "id": userID
            }
          };
          const solicitud = await PostUsuarioNotificacion(notificacion); 
        }catch(error){
          Alert.alert(error.message);
        }
      };

      const obtenerStatusGiroscopio = async () => {
        const listener = Gyroscope.addListener(({ x, y, z }) => {
          if (Math.abs(x) < 0.009 && Math.abs(y) < 0.009 && Math.abs(z) < 0.009) {
            statusInactive = statusInactive + 1;
          } else {
            statusInactive = 0;
          }
          if (statusInactive >= 3) {
            gyroStatus = 'INMOBILE';
          } else {
            gyroStatus = 'MOBILE';
          }
          Gyroscope.removeAllListeners();
        });
        if (gyroStatus === 'INMOBILE'){
          await enviarNotificaciones('Victima Inmovil');
        }
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
      }

      const enviarCoordenadas = async (coordenadas) => {
        try {
          const response = await PostUsuarioCoordenadas(coordenadas);
          if (response.status === 200) {
            console.log('Ubicación enviada con éxito');
          }else if(response.status === 500) {
            Alert.alert('Ocurrió un error al enviar la ubicación');
          }
        } catch (error) {
          Alert.alert('Ocurrio un error inesperado:', error.message);
        };      
      };

      const verificarDistancia = async () => {
        try {
          const distancia = await obtenerDistanciaVictimaAgresor(incidente.data.response.id);
          if (distancia.status === 200){
            if (distancia.data.response <= incidente.data.response._separation_distance){
              mandarNotificacion('ATACANTE CERCA DE USTED','Se encuentra a una distancia de '+distancia.data.response+' metros de usted'); 
              await enviarNotificaciones('Atacante a una Distancia Menor a la Permitida.');
              Vibration.vibrate(5000);
              await sonarAlerta();
            };
          };
        } catch (error){
          Alert.alert('Error al obtener la distancia entre la victima y el agresor.',error.message);
        };
      };

      const verificarAtacanteZonaSegura = async () => {
        try {
          const atacanteZona = await obtenerAtacanteZonaSegura(incidente.data.response.id);
          if (atacanteZona.status === 200){
            if (atacanteZona.data.response._inside === true){
              mandarNotificacion('ATACANTE EN ZONA SEGURA','Por favor tenga cuidado al ingresar a una zona segura.'); 
              Vibration.vibrate(4000);
            };
          };
        } catch (error){
          Alert.alert('Error al obtener si el atacante se encuentra en una zona segura',error.message);
        };
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
              await verificarDistancia();
              await verificarAtacanteZonaSegura();
              await enviarCoordenadas(generarCoordenada(localizacionTelefono.coords.latitude,localizacionTelefono.coords.longitude,gyroStatus,milisegundos));
            };
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
    return {funcionDemonio,gestionarZonasSeguras,obtenerLocalizacionMapa,obtenerIncidenciaVictima,manejoNotificaciones,navegarVistaPuntoControl,llamadaSOS};
}
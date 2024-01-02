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
import { ObtenerDistanciaVictimaAgresor } from '../../../Domain/useCases/ObtenerDistanciaVictimaAgresor';
import { ObtenerAtacanteZonaSegura } from '../../../Domain/useCases/ObtenerAtacanteZonaSegura';
import { PostUsuarioNotificacion } from '../../../Domain/useCases/EnviarNotificacion';

export const principalViewModel = () => {
    global.gyroStatus = 'MOBILE';

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

    const obtenerIncidenciaVictima = async (incidente,setIncidente) => {
      if (incidente === null){
        try {
          const incidenteVictima = await ObtenerIncidenteVictima(victimID);
          if (incidenteVictima.status === 200){
             setIncidente(incidenteVictima);
          };
        } catch (error){
          Alert.alert('Error al obtener las zonas seguras',error.message);
        };
      }
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

    const funcionDemonio = () => {
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

      const obtenerStatusGiroscopio = async (setInactive,inactive) => {
        const listener = Gyroscope.addListener(({ x, y, z }) => {
          if (Math.abs(x) < 0.009 && Math.abs(y) < 0.009 && Math.abs(z) < 0.009) {
            setInactive(inactive + 1);
          } else {
            setInactive(0);
          }
          if (inactive >= 3) {
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
          Alert.alert('Ocurrior un error inesperado:', error.message);
        };      
      };

      const verificarDistancia = async (incidente) => {
        try {
          const distancia = await ObtenerDistanciaVictimaAgresor(incidente.data.response.id);
          if (distancia.status === 200){
            if (distancia.data.response <= incidente.data.response._separation_distance){
              //Apartado de alertas es necesario acomodar/////////////////////////////////////////////////////////////////////////////////////////////////
              //Enviar notificación
              Alert.alert('El agresor se encuentra a menos de '+incidente.data.response._separation_distance+' metros de distancia'); 
              await enviarNotificaciones('Atacante a una Distancia Menor a la Permitida.');
            };
          };
        } catch (error){
          Alert.alert('Error al obtener la distancia entre la victima y el agresor.',error.message);
        };
      };

      const verificarAtacanteZonaSegura = async (incidente) => {
        try {
          const atacanteZona = await ObtenerAtacanteZonaSegura(incidente.data.response.id);
          if (atacanteZona.status === 200){
            if (atacanteZona.data.response._inside === true){
              //Apartado de alertas es necesario acomodar/////////////////////////////////////////////////////////////////////////////////////////////////
              //Enviar notificación
              Alert.alert('El agresor se encuentra dentro de una zona segura.Por favor tenga cuidado.');
            };
          };
        } catch (error){
          Alert.alert('Error al obtener si el atacante se encuentra en una zona segura',error.message);
        };
      };

      const verificarConexionInternet = async (setConexionInternet,setInactive,inactive,incidencia) => {
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

        await obtenerStatusGiroscopio(setInactive,inactive);

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
              await enviarCoordenadas(generarCoordenada(localizacionTelefono.coords.latitude,localizacionTelefono.coords.longitude,gyroStatus,milisegundos));
              await verificarDistancia(incidencia);
              await verificarAtacanteZonaSegura(incidencia);
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
    return {funcionDemonio,gestionarZonasSeguras,obtenerLocalizacionMapa,obtenerIncidenciaVictima};
}
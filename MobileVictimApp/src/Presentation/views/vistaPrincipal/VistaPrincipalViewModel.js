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
import {ObtenerZonasSegurasID} from '../../../Domain/useCases/ObtenerZonasSeguras';

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
            }
          }      
          zonasSeguras.push({_name: nombreZona, _coordinates: coordenadasZonaSegura}); // para la última zona
        };
        return zonasSeguras;
      } catch (error){
        Alert.alert('Error al obtener las zonas seguras',JSON.stringify(error));
      }
    };

    const funcionDemonio = () => {
      const [conexionInternet, setConexionInternet] = useState(true);
      const [inactive, setInactive] = useState(0);
      setupDatabase();

      useEffect(() => {
        const intervalId = setInterval(verificarConexionInternet, 40000);
    
        return () => {
          clearInterval(intervalId);
        };
      }, [conexionInternet,inactive]);

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
        }
      };

      const obtenerStatusGiroscopio = () => {
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
          Alert.alert('Ocurrior un error inesperado:', error);
        }      
      };


      const verificarConexionInternet = async () => {
        const netInfo = await NetInfo.fetch();
        const online = netInfo.isConnected && netInfo.isInternetReachable;

        setConexionInternet(online);

        obtenerStatusGiroscopio();

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
      return conexionInternet;
    };

  return {funcionDemonio, gestionarZonasSeguras};
}
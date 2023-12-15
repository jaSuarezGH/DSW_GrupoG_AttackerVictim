import * as Location from 'expo-location';
import NetInfo from "@react-native-community/netinfo";
import { setupDatabase } from '../../../Data/local/SQLite/sqlite';
import { GuardarCoordenadasSQL } from '../../../Domain/useCases/GuardarCoordenadas';
import { ObtenerCoordenadasSQL } from '../../../Domain/useCases/ObtenerCoordenadasGuardadas';
import { useEffect, useState } from 'react';
import { Alert } from 'react-native';
import { EliminarUsuarioCoordenadas } from '../../../Domain/useCases/EliminarCoordenadasGuardadas';
import { PostUsuarioCoordenadas } from '../../../Domain/useCases/EnviarCoordenadas';
import { Gyroscope } from 'expo-sensors';//////

export const principalViewModel = () => {
    global.gyroStatus = 'MOBILE';

    const enviarCoordenadas = async (coordenadas) => {
      try {
        const response = await PostUsuarioCoordenadas(coordenadas);
        if (response.status === 200) {
          console.log('Ubicación enviada con éxito');
        }else if(response.status === 401) {
          Alert.alert('Ocurrió un error al enviar la ubicación');
        }
      } catch (error) {
        Alert.alert('Ocurrior un error inesperado:', error);
      }      
    };

    const generarCoordenada = (location, status) =>{
      var fecha = new Date();
      var milisegundos = Date.parse(fecha);

      const coordenadas = { 
        _full_date: milisegundos, 
        _status: status, 
        _latitude: location.coords.latitude,
        _longitude: location.coords.longitude,
        _user: {
          id: userID,
        }
      };  
      return coordenadas;
    }

    const useLocationSync = () => {
        const [isConnected, setIsConnected] = useState(false);
        const [inactive, setInactive] = useState(0);

            useEffect(() => {
              setupDatabase();
              const interval = setInterval(async () => {
                let { status } = await Location.requestForegroundPermissionsAsync();
                
                if (status !== 'granted') {
                  console.error('Permiso para acceder a la ubicación denegado');
                  return;
                }
          
                let locationTelefono = await Location.getCurrentPositionAsync({});

                const statusGiroscopio = Gyroscope.addListener(({ x, y, z }) => {
                  if (Math.abs(x) < 0.009 && Math.abs(y) < 0.009 && Math.abs(z) < 0.009) {
                    setInactive(inactive + 1);
                  } else {
                    setInactive(0);
                  }
                  if (inactive >= 4) {
                    global.gyroStatus = 'INMOBILE';
                  } else{
                    global.gyroStatus = 'MOBILE'; 
                  }
                  Gyroscope.removeAllListeners();
                });

                if (isConnected) {

                  const locationSQL = await ObtenerCoordenadasSQL();
                  //Si hay datos en la base de datos procedemos a enviarlos a la api 
                  if (locationSQL.length > 0){
                    for (let location of locationSQL) {
                      const coordenadas = { 
                        _full_date: location.fecha, 
                        _status: 'OFFLINE', 
                        _latitude: location.latitude,
                        _longitude: location.longitude,
                        _user: {
                          id: userID,
                        } 
                      };
                      try {
                        console.log(`Ubicación: Latitud - ${location.latitude}, Longitud - ${location.longitude}, Fecha - ${location.fecha}`);/////////////
                        enviarCoordenadas(coordenadas);
                      } catch (error) {
                        Alert.alert('Error al enviar las ubicaciones:', error);
                      }
                    };

                    EliminarUsuarioCoordenadas()
                      .then((deleted) => {
                        if (!deleted) {
                          Alert.alert('No se lograron eliminar las ubicaciones.');
                        }
                      })
                      .catch((error) => {
                        Alert.alert('Ocurrió un error al eliminar la ubicación:', error);
                      });
                  };
                  
                  try{
                    enviarCoordenadas(generarCoordenada(locationTelefono,global.gyroStatus));
                  }catch(error){
                    console.error(error);
                  }

                } else {
                  GuardarCoordenadasSQL(generarCoordenada(locationTelefono,'OFFLINE'))
                  .then((wasSuccessful) => {
                    if (!wasSuccessful) {
                      Alert.alert('No se pudo guardar la ubicación.');
                    }
                  })
                  .catch((error) => {
                    Alert.alert('Ocurrió un error al guardar la ubicación:', error);
                  });
                }
              }, 30000);
              return () => {
                clearInterval(interval);
              };
            }, [inactive,isConnected]);
        
        useEffect(() => {
            const unsubscribe = NetInfo.addEventListener(state => {
              setIsConnected(state.isConnected);
            });
            return () => {
              unsubscribe();
            };
        }, []);
      
      return isConnected;
    };

    return {useLocationSync};
};

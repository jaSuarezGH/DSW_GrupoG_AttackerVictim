import * as Location from 'expo-location';
import NetInfo from "@react-native-community/netinfo";
import { setupDatabase } from '../../../Data/local/SQLite/sqlite';
import { postCoordenadas } from '../../../Data/local/repositories/AutenticationRepo';
import { GuardarCoordenadasSQL } from '../../../Domain/useCases/GuardarCoordenadas';
import {ObtenerCoordenadasSQL} from '../../../Domain/useCases/ObtenerCoordenadasGuardadas';
import { useEffect, useState } from 'react';
import { Alert } from 'react-native';
import { EliminarUsuarioCoordenadas } from '../../../Domain/useCases/EliminarCoordenadasGuardadas';


export const principalViewModel = () => {
    
    const enviarCoordenadas = async (coordenadas) => {
      try {
        const response = await postCoordenadas(coordenadas);
        if (response.status === 200) {
          console.log('Ubicación enviada con éxito');
        }else if(response.status === 401) {
          Alert.alert('Ocurrió un error al enviar la ubicación');
        }
      } catch (error) {
        Alert.alert('Ocurrior un error inesperado:', error);
      }      
    };

    const useLocationSync = () => {
        const [isConnected, setIsConnected] = useState(false);

            useEffect(() => {
              setupDatabase();
              const interval = setInterval(async () => {
                let { status } = await Location.requestForegroundPermissionsAsync();
                
                if (status !== 'granted') {
                  console.error('Permiso para acceder a la ubicación denegado');
                  return;
                }
          
                let location = await Location.getCurrentPositionAsync({});

                const coordenadas = { 
                  latitude: location.coords.latitude, 
                  longitude: location.coords.longitude, 
                  idUser: 1 
                };
          
                if (isConnected) {

                  enviarCoordenadas(coordenadas);

                  const locationSQL = await ObtenerCoordenadasSQL();
                  if (locationSQL.length > 0){
                    for (let location of locationSQL) {
                      const coordenadas = { 
                        latitude: location.latitude, 
                        longitude: location.longitude, 
                        idUser: location.idUser 
                      };
                      try {
                      // console.log(`Ubicación: Latitud - ${location.latitude}, Longitud - ${location.longitude}, ID de usuario - ${location.idUser}`);/////////////
                        enviarCoordenadas(coordenadas);
                      } catch (error) {
                        Alert.alert('Error al enviar las ubicaciones:', error);
                      }
                    }

                    EliminarUsuarioCoordenadas()
                      .then((deleted ) => {
                        if (!deleted) {
                          Alert.alert('No se lograron eliminar las ubicaciones.');
                        }
                      })
                      .catch((error) => {
                        Alert.alert('Ocurrió un error al eliminar la ubicación:', error);
                      });
                  }
                } else {
                  GuardarCoordenadasSQL(coordenadas)
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
            }, [isConnected]);
        
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

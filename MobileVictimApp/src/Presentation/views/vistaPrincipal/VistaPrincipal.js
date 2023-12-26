
import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, Image,Button } from 'react-native';
import { principalViewModel } from '../../../../src/Presentation/views/vistaPrincipal/VistaPrincipalViewModel';
import MapView, {Polygon} from 'react-native-maps';
import * as Location from 'expo-location';

export const VistaPrincipalScreen = () => {
    const [initialLocation, setInitialLocation] = useState(null);
    const [currentLocation, setCurrentLocation] = useState(null);
    const [zonasSeguras,setZonasSeguras] = useState([]);

    const {gestionarZonasSeguras} = principalViewModel();

    useEffect(() => {
        (async () => {
          const zonas = await gestionarZonasSeguras();
          setZonasSeguras(zonas);
          console.log('----------------------------------')
          console.log(Array.isArray(zonas));
        })();
      }, []);
      
      useEffect(() => {
        (async () => {
          let { status } = await Location.requestForegroundPermissionsAsync();
          if (status !== 'granted') {
            alert('Permiso de acceso a la ubicación denegado');
            return;
          }
      
          let locationSubscription = await Location.watchPositionAsync({
            accuracy: Location.Accuracy.High,
            timeInterval: 1000,
            distanceInterval: 1,
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

    const centerMapOnUser = () => {
        setInitialLocation(currentLocation);
    };

    return(
        <View style = {styles.container}>
            <View style={styles.logoContainer}>
              <Image 
                source={require('../../../../assets/LogoAVapp.png')} 
                style={styles.imageLogoLogin} />

              <Text style={styles.logoText}>Victim App</Text>
              
            </View>
            
            <MapView 
                style={styles.map} 
                provider={MapView.PROVIDER_GOOGLE} 
                showsUserLocation={true} 
                region={{ 
                    latitude: 10.48752/*initialLocation ? initialLocation.coords.latitude : 0*/,
                    longitude: -66.93866/*initialLocation ? initialLocation.coords.longitude : 0*/,
                    latitudeDelta: 0.001472, 
                    longitudeDelta: 0.000768, 
                }}
                locationUpdateInterval={3000}
                >
                {zonasSeguras.map((zona, index) => (
                    <Polygon
                    key={index}
                    coordinates={zona._coordinates}
                    strokeColor="#000" // borde
                    fillColor="rgba(255,0,0,0.5)" // relleno
                    strokeWidth={1}
                    />  
                ))}
            </MapView>

        </View>
    );
}
const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#25334A',
      alignItems: 'center',
      justifyContent: 'center',
      flexDirection:'row',
    },
    textForm:{
        fontWeight:'bold',
        fontSize:24,
        color:'white',
    },
    logoContainer:{
        position:'absolute',
        alignItems:'center',
        top:'8%',
        flexDirection:'row',
        left:'4%',
        height:'10%',
    },
    imageLogoLogin:{
        width:54,
        height:47,
    },
    logoText:{
        color:'white',
        textAlign:'center',
        fontSize:15,
        marginLeft:8,
        fontWeight:'bold',
    },
    map:{
        height: '40%',
        width: '100%',
    },
    botonContainer:{
        position:'absolute',
        alignSelf:'center',
        height:'30%',
      },
});
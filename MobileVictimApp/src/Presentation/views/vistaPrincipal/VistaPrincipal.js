
import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, Image } from 'react-native';
import { principalViewModel } from '../../../../src/Presentation/views/vistaPrincipal/VistaPrincipalViewModel';
import MapView from 'react-native-maps';
import * as Location from 'expo-location';

export const VistaPrincipalScreen = () => {

    const [location, setLocation] = useState(null);

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
            setLocation(newLocation);
          });
    
          return () => {
            if (locationSubscription) {
              locationSubscription.remove();
            }
          };
        })();
      }, []);

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
                //key = 'AIzaSyDzncrVcssunh1W8avgQlixEYOSVqM6V4A'
                showsUserLocation={true} 
                region={{ 
                    latitude: location ? location.coords.latitude : 0,
                    longitude: location ? location.coords.longitude : 0,
                    latitudeDelta: 0.001472, 
                    longitudeDelta: 0.000768, 
                }}
                locationUpdateInterval={1000}
            />   
        </View>
    );
}
//<Text style={styles.textForm}>{isConnected ? 'Online' : 'Offline'}</Text>
//<Text style ={styles.textForm}>Status: </Text>

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
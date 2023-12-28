
import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, Image,Button } from 'react-native';
import { principalViewModel } from '../../../../src/Presentation/views/vistaPrincipal/VistaPrincipalViewModel';
import MapView, {Polygon} from 'react-native-maps';

export const VistaPrincipalScreen = () => {
    const [zonasSeguras,setZonasSeguras] = useState([]);

    const {gestionarZonasSeguras,obtenerLocalizacionMapa} = principalViewModel();

    let {initialLocation} = obtenerLocalizacionMapa();

    useEffect(() => {
        (async () => {
          console.log('Se renderizo.');
          const zonas = await gestionarZonasSeguras();
          setZonasSeguras(zonas);
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
                showsUserLocation={true} 
                region={{ 
                    latitude: initialLocation ? initialLocation.coords.latitude : 0,
                    longitude: initialLocation ? initialLocation.coords.longitude : 0,
                    latitudeDelta: 0.01472, 
                    longitudeDelta: 0.00768, 
                }}
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
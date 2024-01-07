
import React, { useState, useEffect, useRef } from 'react';
import { View, Text, StyleSheet, Image,Button } from 'react-native';
import { principalViewModel } from '../../../../src/Presentation/views/vistaPrincipal/VistaPrincipalViewModel';
import MapView, {Polygon} from 'react-native-maps';
import { RoundedButtonLogin } from '../../components/RoundedButtonLogin';

export const VistaPrincipalScreen = () => {
    const [zonasSeguras,setZonasSeguras] = useState([]);
    const { funcionDemonio,gestionarZonasSeguras,obtenerLocalizacionMapa,obtenerIncidenciaVictima,manejoNotificaciones,navegarVistaPuntoControl,llamadaSOS } = principalViewModel();
    const { registroDeNotificaciones,inicializarNotificaciones,finalizarNotificaciones,mandarNotificacion} = manejoNotificaciones();
    const { verificarConexionInternet } = funcionDemonio(mandarNotificacion);

    const [conexionInternet, setConexionInternet] = useState(true);

    let {initialLocation} = obtenerLocalizacionMapa();

    const [expoPushToken, setExpoPushToken] = useState('');
    const [notification, setNotification] = useState(false);
    const notificationListener = useRef();
    const responseListener = useRef();


    useEffect(() => {
        registroDeNotificaciones().then(token => setExpoPushToken(token));
        inicializarNotificaciones(setNotification,notificationListener,responseListener);
        
        return () => {
        finalizarNotificaciones(notificationListener,responseListener);
        };
    }, []);


    useEffect(() => {
        let intervalId;
        (async () => {
            await obtenerIncidenciaVictima();
            intervalId = setInterval(() => verificarConexionInternet(setConexionInternet)
            ,45000);
        })();
        return () => {
            clearInterval(intervalId);
        };
    }, []);

    useEffect(() => {
        (async () => {
          if (zonasSeguras.length === 0){
            try {
                const zonas = await gestionarZonasSeguras();
                setZonasSeguras(zonas);
            } catch (error) {
                console.error('Hubo un error al obtener las zonas seguras:', error);
            }
          };
        })();
    },[]);
      
    return(
        <View style = {styles.container}>
            <View style={styles.logoContainer}>
              <Image 
                source={require('../../../../assets/LogoAVapp.png')} 
                style={styles.imageLogoLogin} />

              <Text style={styles.logoText}>Victim App / Home</Text>
              
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

            <View style={styles.opcionContainer}>
                
                <View style={styles.buttonContainer}>
                    <RoundedButtonLogin 
                        text = ' Punto de control ' 
                        onPress={navegarVistaPuntoControl} 
                    /> 
                </View>

                <View style={styles.buttonContainer}>
                    <RoundedButtonLogin 
                        text = 'SOS' 
                        onPress={llamadaSOS} 
                    />
                </View>

                <View style={styles.buttonContainer}>
                    <RoundedButtonLogin 
                        text = 'Mensajes' 
                        //onPress={} 
                    />
                </View>

            </View>
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
        height: '50%',
        width: '100%',
    },
    opcionContainer:{
        position:'absolute',
        alignSelf:'center',
        height:'20%',
        bottom:'0%',
        right:'23%',
        flexDirection:'row',
        justifyContent:'space-between',
    },
    buttonContainer: {
        width: '38%',
        margin: 5,
    },
});
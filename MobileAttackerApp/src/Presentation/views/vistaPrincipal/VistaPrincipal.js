import React from 'react';
import { View,Text,StyleSheet,Image } from 'react-native';
import { principalViewModel } from '../../../../src/Presentation/views/vistaPrincipal/VistaPrincipalViewModel';
import { useEffect, useState, useRef } from 'react';

export const VistaPrincipalScreen = () => {

    const { funcionDemonio,obtenerIncidenciaAtacante,manejoNotificaciones } = principalViewModel();
    const { registroDeNotificaciones,inicializarNotificaciones,finalizarNotificaciones,mandarNotificacion} = manejoNotificaciones();
    const { verificarConexionInternet } = funcionDemonio(mandarNotificacion);

    const [conexionInternet, setConexionInternet] = useState(true);
    
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
             await obtenerIncidenciaAtacante();
             intervalId = setInterval(() => verificarConexionInternet(setConexionInternet)
             ,45000);
          })();

        return () => {
            clearInterval(intervalId);
        };
    }, []);

    return(
        
        <View style = {styles.container}>
            <View style={styles.logoContainer}>
              <Image 
                source={require('../../../../assets/LogoAVapp.png')} 
                style={styles.imageLogoLogin} />
              <Text style={styles.logoText}>Attacker App / Home</Text>
            </View>
            

            <Text style ={styles.textForm}>Status: </Text>
            <Text style={styles.textForm}>{conexionInternet ? 'Online' : 'Offline'}</Text>
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
        top:'10%',
        flexDirection:'row',
        left:'4%',
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
});
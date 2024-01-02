import React from 'react';
import { View,Text,StyleSheet,Image } from 'react-native';
import { principalViewModel } from '../../../../src/Presentation/views/vistaPrincipal/VistaPrincipalViewModel';
import { useEffect, useState } from 'react';

export const VistaPrincipalScreen = () => {

    const { funcionDemonio,obtenerIncidenciaAtacante } = principalViewModel();
    const { verificarConexionInternet } = funcionDemonio();
    const [conexionInternet, setConexionInternet] = useState(true);
    const [inactive, setInactive] = useState(0);
    const [IdIncidencia, setIdIncidencia] = useState(null);

    useEffect(() => {
        let intervalId;
        (async () => {
             await obtenerIncidenciaAtacante(IdIncidencia,setIdIncidencia);
             intervalId = setInterval(() => verificarConexionInternet(setConexionInternet,setInactive,inactive,IdIncidencia)
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
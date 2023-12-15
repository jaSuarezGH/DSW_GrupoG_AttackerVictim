import React from 'react';
import { View,Text,StyleSheet,Image } from 'react-native';
import { principalViewModel } from '../../../../src/Presentation/views/vistaPrincipal/VistaPrincipalViewModel';
import MapView from 'react-native-maps'

export const VistaPrincipalScreen = () => {

    //const { useLocationSync } = principalViewModel();
    //const isConnected = useLocationSync();

    const { useLocation } = principalViewModel();
    const location = useLocation();

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
                initialRegion={{ 
                    latitude: location.coords.latitude , 
                    longitude: location.coords.longitude , 
                    latitudeDelta: 0.0922, 
                    longitudeDelta: 0.0421, 
                }} 
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
import React, {useState, useEffect} from 'react';
import { View,Text,StyleSheet,Image, Alert, TextInput } from 'react-native';
import { puntosControlViewModel } from './VistaPuntoControlViewModel';
import { RoundedButtonLogin } from '../../components/RoundedButtonLogin';
import { Dimensions } from 'react-native';

const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

export const VistaPuntoControlScreen = () => {

  const [hours, setHours] = useState(0);
  const [minutes, setMinutes] = useState(0);
  const [seconds, setSeconds] = useState(0);
  const [isActive, setIsActive] = useState(false);
  const [time, setTime] = useState(0);

  const toggle = () => {
    setIsActive(!isActive);
    if (!isActive) {
      const totalSeconds = Number(hours) * 3600 + Number(minutes) * 60 + Number(seconds);
      setTime(totalSeconds);
    }
  };

  const reset = () => {
    setTime(0);
    setIsActive(false);
  };

  const formatTime = (time) => {
    const hours = Math.floor(time / 3600);
    const minutes = Math.floor((time % 3600) / 60);
    const seconds = time % 60;
    return `${hours}:${minutes < 10 ? `0${minutes}` : minutes}:${seconds < 10 ? `0${seconds}` : seconds}`;
  };

  useEffect(() => {
    let interval = null;
    if (isActive && time > 0) {
      interval = setInterval(() => {
        setTime(time => time - 1);
      }, 1000);
    } else if (!isActive && time !== 0) {
      clearInterval(interval);
    }else if (time === 0 && isActive) {
      reset();
      Alert.alert('Tiempo agotado');
    }
    return () => clearInterval(interval);
  }, [isActive, time]);


    return(
        
        <View style = {styles.container}>
            <View style={styles.logoContainer}>
              <Image 
                source={require('../../../../assets/LogoAVapp.png')} 
                style={styles.imageLogoLogin} />
              <Text style={styles.logoText}>Victim App / Ingreso a zona privada</Text>
            </View>
            
            <View style ={styles.textContainer}>
              <Text style={styles.titleForm}>Temporizador</Text>
              <View style={{ flexDirection: 'row',paddingLeft:10}}>
                <TextInput
                  style={styles.textInputForm}
                  onChangeText={text => setHours(text)}
                  value={String(hours)}
                  keyboardType='number-pad'
                />
                <Text>   </Text>
                <TextInput
                  style={styles.textInputForm}
                  onChangeText={text => setMinutes(text)}
                  value={String(minutes)}
                  keyboardType='number-pad'
                />
                <Text>   </Text>
                <TextInput
                  style={styles.textInputForm}
                  onChangeText={text => setSeconds(text)}
                  value={String(seconds)}
                  keyboardType='number-pad'
                />
              </View>
                
              <Text style={styles.textForm}>{formatTime(time)} min</Text>
            </View>
            <View style={styles.botonContainer}>
              <RoundedButtonLogin 
                  text={isActive ? 'Detener' : 'Iniciar'} 
                  onPress={toggle} 
              />
              <RoundedButtonLogin 
                  text='Reiniciar' 
                onPress={reset} 
              />

              <Text style={styles.textAdvise}> Aviso: Si no se detiene el contador , se le notificara a las autoridades que se encuentra en peligro. Por favor sea conciente al momento de iniciar la cuenta atras y detenerla en caso de que salga de una zona privada.</Text>

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
    fontSize: windowWidth * 0.15, // 15% del ancho de la ventana
    color:'white',
  },
  textInputForm:{
    flex:1,
    backgroundColor:'white',
    fontSize: windowWidth * 0.04, // 4% del ancho de la ventana
    borderRadius:8,
    padding:5,
    marginBottom:10,
    bottom: windowHeight * 0.03, // 15% del alto de la ventana
    left: windowWidth * 0, // 4% del ancho de la ventana
    right: windowWidth * 0, // 4% del ancho de la ventana
  },
  titleForm:{
    fontWeight:'bold',
    fontSize: windowWidth * 0.07, // 7% del ancho de la ventana
    bottom: windowHeight * 0.1, // 50% del alto de la ventana
    color:'white',
  },
  logoContainer:{
    position:'absolute',
    alignItems:'center',
    top: windowHeight * 0.1, // 10% del alto de la ventana
    flexDirection:'row',
    left: windowWidth * 0.04, // 4% del ancho de la ventana
  },
  textContainer:{
    position:'absolute',
    alignItems:'center',
    top: windowHeight * 0.33, // 33% del alto de la ventana
  },
  textAdvise:{
    fontSize: windowWidth * 0.03, // 3% del ancho de la ventana
    color:'white',
    textAlign:'center',
    top: windowHeight * 0.06, // 50% del alto de la ventana
  },
  botonContainer:{
    position:'absolute',
    alignSelf:'center',
    top: windowHeight * 0.62, // 55% del alto de la ventana
    width: windowWidth * 0.8, // 80% del ancho de la ventana
  },
  imageLogoLogin:{
    width: windowWidth * 0.13, // 13% del ancho de la ventana
    height: windowHeight * 0.07, // 7% del alto de la ventana
  },
  logoText:{
    color:'white',
    textAlign:'center',
    fontSize: windowWidth * 0.037, // 3.7% del ancho de la ventana
    marginLeft: windowWidth * 0.02, // 2% del ancho de la ventana
    fontWeight:'bold',
  },
});
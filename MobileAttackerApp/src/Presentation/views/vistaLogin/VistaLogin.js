import React from 'react';
import { View,Text,StyleSheet,TextInput, TouchableOpacity,Image } from 'react-native';
import { RoundedButtonLogin } from '../../components/RoundedButtonLogin';
import { loginViewModel } from './VistaLoginViewModel';
import { Dimensions } from 'react-native';

const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

export const VistaLoginScreen = () => {
    
  const { user, handleInputChange,verificarDatos,navegarVistaRecuperacionDatos} = loginViewModel();


  return(
        <View style = {styles.container}>
            
            <View style={styles.logoContainer}>
              <Image 
                source={require('../../../../assets/LogoAVapp.png')} 
                style={styles.imageLogoLogin} />
              <Text style={styles.logoText}>Attacker App</Text>
            </View>
            
            <View style={styles.form}>
            <Text style={styles.textForm}>Login</Text>
              <View style={styles.inputForm}>
                <Image 
                  source={require('../../../../assets/iconoLogin.png')} 
                  style={styles.imageLogo} />
                
                <TextInput 
                  style={styles.textInputForm} 
                  keyboardType='default'
                  placeholder='Ingrese su usuario'
                  onChangeText={text => handleInputChange('email', text)}
                  value={user.email}
                  />
              </View>

              <View style={styles.inputForm}>
                <Image 
                  source={require('../../../../assets/iconoContraseña.png')} 
                  style={styles.imageLogo} 
                />
                <TextInput 
                  style={styles.textInputForm} 
                  placeholder='Ingrese su contraseña'
                  keyboardType='default'
                  secureTextEntry={true}
                  onChangeText={text => handleInputChange('password', text)}
                  value={user.password}
                />
              </View>

              <View style = {{marginTop:30}}>
                <RoundedButtonLogin 
                 text = 'Ingresar' 
                 onPress={() => verificarDatos(user.email,user.password)} 
                />
              </View>

              <View style = {styles.formRegister}>
                <Text>No te acuerdas de tus datos? </Text>
                
                <TouchableOpacity
                  onPress={navegarVistaRecuperacionDatos}
                  >
                  <Text style={styles.formRequestText}>Solicitar</Text>
                </TouchableOpacity>
                
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
  },
  form:{
      width: windowWidth * 0.8,
      height: windowHeight * 0.5,
      position:'absolute',
      backgroundColor:'white',
      bottom: windowHeight * 0.15,
      borderTopRightRadius:25,
      borderTopLeftRadius:25,
      borderBottomLeftRadius:25,
      borderBottomRightRadius:25,
      padding: 30,
  },
  textForm:{
      fontWeight:'bold',
      fontSize: 20 * (windowWidth / 390),
  },
  inputForm:{
      flexDirection:'row',
      marginTop:35 * (windowHeight / 835),
  },
  textInputForm:{
      flex:1,
      borderBottomWidth:1,
      borderBottomColor:'#EBEBEB',
      fontSize:16 * (windowWidth / 390),
  },
  formRegister:{
      flexDirection:'row',
      marginTop: 24 * (windowHeight / 835),
      justifyContent:'center'
  },
  formRequestText:{
      fontStyle:'italic',
      color:'#3A84FF',
      fontSize: 15 * (windowHeight / 835),
      borderBottomWidth: 2,
      borderBottomColor:'#3A84FF',
      fontWeight:'bold',
  },
  imageLogo:{
      width:30 * (windowWidth / 390),
      height:30 * (windowHeight / 835),
      marginRight:7,
  },
  imageLogoLogin:{
      width:130 * (windowWidth / 390),
      height:125 * (windowHeight / 799),
  },
  logoContainer:{
      position:'absolute',
      alignItems:'center',
      top: windowHeight * 0.11,
  },
  logoText:{
      color:'white',
      textAlign:'center',
      fontSize:20 * (windowWidth / 390),
      marginTop:20 * (windowHeight / 835),
      fontWeight:'bold',
  },
  textDatos:{
    fontSize: 17 * (windowHeight / 835),
  },
});





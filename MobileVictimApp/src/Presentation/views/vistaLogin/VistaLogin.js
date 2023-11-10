import React from 'react';
import { View,Text,StyleSheet,TextInput, TouchableOpacity,Image } from 'react-native';
import { RoundedButtonLogin } from '../../components/RoundedButtonLogin';

export const VistaLoginScreen = () => {
    return(
        <View style = {styles.container}>
            
            <View style={styles.logoContainer}>
              <Image 
                source={require('../../../../assets/logoLogin.png')} 
                style={styles.imageLogoLogin} />
              <Text style={styles.logoText}>Inicio de sesion</Text>
            </View>
            
            <View style={styles.form}>
            <Text style={styles.textForm}>Login</Text>
              <View style={styles.inputForm}>
                <Image 
                  source={require('../../../../assets/iconoLogin.png')} 
                  style={styles.imageLogo} />
                
                <TextInput 
                  style={styles.textInputForm} 
                  keyboardType='email-address'
                  placeholder='Ingrese su correo electronico'
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
                />
              </View>

              <View style = {{marginTop:30}}>
                <RoundedButtonLogin text = 'Ingresar'   //Enviar un props a una constante 
                />
              </View>

              <View style = {styles.formRegister}>
                <Text>No te acuerdas de tus datos? </Text>
                
                <TouchableOpacity>
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
      backgroundColor: '#F74F51',
      alignItems: 'center',
      justifyContent: 'center',
    },
    form:{
        width:'80%',
        height:'40%',
        position:'absolute',
        backgroundColor:'white',
        bottom:'25%',
        borderTopRightRadius:25,
        borderTopLeftRadius:25,
        borderBottomLeftRadius:25,
        borderBottomRightRadius:25,
        padding: 30,
      },
      textForm:{
        fontWeight:'bold',
        fontSize:16,
      },
      inputForm:{
        flexDirection:'row',
        marginTop:35,
      },
      textInputForm:{
        flex:1,
        borderBottomWidth:1,
        borderBottomColor:'#EBEBEB',
        fontSize:16,
      },
      formRegister:{
        flexDirection:'row',
        marginTop: 50,
        justifyContent:'center'
      },
      formRequestText:{
        fontStyle:'italic',
        color:'orange',
        borderBottomWidth: 2,
        borderBottomColor:'orange',
        fontWeight:'bold',
      },
      imageLogo:{
        width:30,
        height:30,
        marginRight:7,
      },
      imageLogoLogin:{
        width:134,
        height:127,
      },
      logoContainer:{
        position:'absolute',
        alignSelf:'center',
        top:'11%',
      },
      logoText:{
        color:'white',
        textAlign:'center',
        fontSize:20,
        marginTop:20,
        fontWeight:'bold',
      },
});





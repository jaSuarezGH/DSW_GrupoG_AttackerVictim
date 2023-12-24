import React from 'react';
import { View,Text,StyleSheet,TextInput,Image } from 'react-native';
import { RoundedButtonLogin } from '../../components/RoundedButtonLogin';
import {recuperarViewModel} from './VistaRecuperacionViewModel';
import { Dimensions } from 'react-native';

const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

export const VistaRecuperacionScreen = () => {

    const{ regresarLogin, handleInputChange,user,recuperarDatoUsuario } = recuperarViewModel()

    return(
        <View style = {styles.container}>
            <View style={styles.form}>
            <Text style={styles.textForm}>Recuperar Datos</Text>
                <View style={styles.inputForm}>
                    <Image 
                     source={require('../../../../assets/iconoLogin.png')} 
                     style={styles.imageLogo} 
                    />
                    
                    <TextInput 
                     style={styles.textInputForm} 
                     keyboardType='email-address'
                     placeholder='Ingrese su correo electronico'
                     onChangeText={text => handleInputChange('email', text)}
                     value={user.email}
                    />
                </View>

              <View style = {{marginTop:30}}>
                <RoundedButtonLogin 
                 text = 'Solicitar' 
                 onPress={() => recuperarDatoUsuario(user.email)} 
                />
                <RoundedButtonLogin 
                 text = 'Regresar' 
                 onPress={regresarLogin} 
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
    fontSize:14 * (windowWidth / 390),
},
    imageLogo:{
      width:30,
      height:30,
      marginRight:7,
    },
});





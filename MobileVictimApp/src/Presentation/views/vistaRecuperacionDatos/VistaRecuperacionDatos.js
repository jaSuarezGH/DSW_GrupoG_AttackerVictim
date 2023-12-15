import React from 'react';
import { View,Text,StyleSheet,TextInput, TouchableOpacity,Image } from 'react-native';
import { RoundedButtonLogin } from '../../components/RoundedButtonLogin';
import {recuperarViewModel} from './VistaRecuperacionViewModel';


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
        width:'80%',
        height:'35%',
        position:'absolute',
        backgroundColor:'white',
        bottom:'35%',
        borderTopRightRadius:25,
        borderTopLeftRadius:25,
        borderBottomLeftRadius:25,
        borderBottomRightRadius:25,
        padding: 30,
      },
      textForm:{
        fontWeight:'bold',
        fontSize:16,
        marginBottom: 20,
      },
      textInputForm:{
        flex:1,
        borderBottomWidth:1,
        borderBottomColor:'#EBEBEB',
        fontSize:16,
      },
      inputForm:{
        flexDirection:'row',
        marginTop:5,
      },
      imageLogo:{
        width:30,
        height:30,
        marginRight:7,
      },
});





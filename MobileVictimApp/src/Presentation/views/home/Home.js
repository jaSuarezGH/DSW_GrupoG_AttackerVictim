import React, {useState} from 'react'
import { StyleSheet, Text, View,Image,TextInput,Button } from 'react-native';
import { RoundedButton } from '../../components/RoundedButton';
import {useHomeViewModel} from './HomeViewModel';



export const HomeScreen = () => {

    const {url,setUrl} = useHomeViewModel();

      return (
        <View style={styles.container}>
          <View style={styles.logoContainer}>
            <Image 
              source={require('../../../../assets/LogoAVapp.png')} 
              style={styles.imageLogo} />
            <Text style={styles.logoText}>Victim App</Text>
          </View>
          <View style={styles.form}>
              <Text style={styles.textForm}>Establezca conexion con la api</Text>
              <View style={styles.inputForm}>
                <TextInput 
                  style={styles.textInputForm} 
                  placeholder='Ingrese la url de la api'
                  value = {url}
                  onChangeText= {setUrl}/>
              </View>
    
              <View style = {{marginTop:30}}>
                <RoundedButton text = 'Conectar' urlApi={url}   //Enviar un props a una constante 
                />
              </View>
          </View>
        </View>
      );
    }
    
    const styles = StyleSheet.create({
      container: {
        flex: 1,
        backgroundColor: '#4A78EC',
        alignItems: 'center',
        justifyContent: 'center',
      },
      imageLogo:{
        width:134,
        height:127,
      },
      form:{
        width:'80%',
        height:'32%',
        position:'absolute',
        backgroundColor:'white',
        bottom:'30%',
        borderTopRightRadius:25,
        borderTopLeftRadius:25,
        borderBottomLeftRadius:25,
        borderBottomRightRadius:25,
        padding: 30,
      },
      logoContainer:{
        position:'absolute',
        alignSelf:'center',
        top:'13%',
      },
      logoText:{
        color:'white',
        textAlign:'center',
        fontSize:20,
        marginTop:20,
        fontWeight:'bold',
      },
      textForm:{
        fontWeight:'bold',
        fontSize:16,
      },
      inputForm:{
        flexDirection:'row',
        marginTop:40,
      },
      textInputForm:{
        flex:1,
        borderBottomWidth:1,
        borderBottomColor:'#EBEBEB',
        fontSize:16,
      },
    
    });
    


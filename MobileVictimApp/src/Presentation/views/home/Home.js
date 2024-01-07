import React, {useState} from 'react'
import { StyleSheet, Text, View,Image,TextInput,Button } from 'react-native';
import { RoundedButton } from '../../components/RoundedButton';
import {homeViewModel} from './HomeViewModel';

export const HomeScreen = () => {

    const { continuarNavigation,exitApp } = homeViewModel();

      return (
        <View style={styles.container}>
          <View style={styles.logoContainer}>
            <Image 
              source={require('../../../../assets/LogoAVapp.png')} 
              style={styles.imageLogo} />
            <Text style={styles.logoText}>Victim App</Text>
          </View>
          <View style={styles.botonContainer}>   
            <RoundedButton text = 'Iniciar' onPress={continuarNavigation}/>
            <RoundedButton text = 'Salir' onPress={exitApp}/>
          </View>
        </View>
      );
}
    
    const styles = StyleSheet.create({
      container: {
        flex: 1,
        backgroundColor: '#202938',
        alignItems: 'center',
        justifyContent: 'center',
      },
      imageLogo:{
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
      botonContainer:{
        position:'absolute',
        alignSelf:'center',
        top:'40%',
        width:'80%',
      },
    });
    


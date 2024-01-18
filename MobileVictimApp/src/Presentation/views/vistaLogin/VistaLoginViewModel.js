import React, { useState } from 'react';
import { Alert } from 'react-native';
import {UserModel} from '../../../Domain/entities/User';
import { useNavigation } from '@react-navigation/native';
import { obtenerDatosVictima } from '../../../Domain/useCases/RecuperarDatosVictima';
import { verficarCredencialesUsuario } from '../../../Domain/useCases/VerificarUsuario';

export const loginViewModel = () => {
    const [user, setUser] = useState(UserModel);
    const navigation = useNavigation();
  
    const handleInputChange = (name, text) => {
      setUser({ ...user, [name]: text });
    };
  
    const clearInputs = () => {
        setUser(UserModel);
    };

    const verificarDatos = async (usuarioLogin, passwordUser) => {
      if (usuarioLogin.trim() && passwordUser.trim()) {
        try {
            const userCredential = {
              "_username": usuarioLogin,
              "_password": passwordUser
            };
            const verificacion = await verficarCredencialesUsuario(userCredential);
            if (verificacion.data.response === true){
              const datosVictimas = await obtenerDatosVictima();
              let victima = datosVictimas.data.response.find(item => item._user._username === usuarioLogin && item._user._password === passwordUser);
              if (victima !== undefined) {
                if (victima._user._active === true){
                  //Declaracion de variables globales
                  global.userID = victima._user.id;
                  global.victimID = victima.id;
                  navigation.navigate('VistaPrincipal');
                } else {
                  clearInputs();
                  Alert.alert('La cuenta del usuario se encuentra inactiva.');
                }
              } else {
                clearInputs();
                Alert.alert('Nombre de usuario o contraseña incorrecta, por favor intentelo nuevamente.');
              }  
            }else{
              clearInputs();
              Alert.alert('El usuario ingresado no se encuentra registrado en el sistema.');
            }
        } catch (error) {
          clearInputs();
          Alert.alert('Error al verificar los datos usuario.Por favor ,intentelo nuevamente.', error.message);
        }
      } else {
        Alert.alert('Por favor ingresa un nombre de usuario y una contraseña');
      }
    };

   
    const navegarVistaRecuperacionDatos = () =>{
      navigation.navigate('VistaRecuperacionDatos');
    }

    return { user, handleInputChange, verificarDatos,navegarVistaRecuperacionDatos};
};

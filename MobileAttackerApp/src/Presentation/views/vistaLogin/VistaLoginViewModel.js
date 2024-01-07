import React, { useState } from 'react';
import { Alert } from 'react-native';
import {UserModel} from '../../../Domain/entities/User';
import { obtenerDatosPorNombreUsuario } from '../../../Domain/useCases/RecuperarDatosPorUsuario';
import { useNavigation } from '@react-navigation/native';
import { obtenerDatosPorIdAtacante } from '../../../Domain/useCases/RecuperarDatosAtacante';

export const loginViewModel = () => {
    const [user, setUser] = useState(UserModel);
    const navigation = useNavigation();
  
    const handleInputChange = (name, text) => {
      setUser({ ...user, [name]: text });
    };
  
    const clearInputs = () => {
        setUser(UserModel);
    };

    const verificarDatos = async (usuarioLogin, passwordUser) => { /////////////////////////// Acomodar
        if (usuarioLogin.trim() || passwordUser.trim()) {
          try {
            const datosUsuario = await obtenerDatosPorNombreUsuario(usuarioLogin);
            // Verificar si la respuesta de la API es exitosa
              if (datosUsuario.data.response !== null) {
                const datosAtacante = await obtenerDatosPorIdAtacante(datosUsuario.data.response.id);
                  if (datosUsuario.data.response._username === usuarioLogin && datosUsuario.data.response._password === passwordUser ) {
                      if (datosUsuario.data.response._active === true){
                        global.userID = datosUsuario.data.response.id;
                        global.attackerID = datosAtacante.data.response.id;
                        navigation.navigate('VistaPrincipal');
                      }else{
                        clearInputs();
                        Alert.alert('La cuenta del usuario se encuentra inactiva.');
                      }
                    }else{
                      clearInputs();
                      Alert.alert('Nombre de usuario o contraseña incorrecta,por favor intentelo nuevamente.');
                    }  
              }else{
                  clearInputs();
              }
          } catch (error) {
            // Mostrar un mensaje de error al usuario
            clearInputs();
            Alert.alert('El usuario ingresado no se encuentra registrado en el sistema.',error.message);
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

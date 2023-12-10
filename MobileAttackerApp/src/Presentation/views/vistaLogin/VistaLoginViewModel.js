import React, { useState } from 'react';
import { Alert } from 'react-native';
import {UserModel} from '../../../Domain/entities/User';
import { PostUserData } from "../../../Domain/useCases/VerificarUsuario";
import { getDataUsuario } from '../../../Data/local/repositories/AutenticationRepo';
import { useNavigation } from '@react-navigation/native';

export const loginViewModel = () => {
    const [user, setUser] = useState(UserModel);
    const navigation = useNavigation();
  
    const handleInputChange = (name, text) => {
      setUser({ ...user, [name]: text });
    };
  
    const clearInputs = () => {
        setUser(UserModel);
    };

    const verificarDatos = async (email, passwordUser) => {
        const usuarioLogin = {
          usuarioDatos: email,
          password: passwordUser,
        };
        try {
          const statusLogin = await PostUserData(usuarioLogin);
          // Verificar si la respuesta de la API es exitosa
            if (statusLogin.status === 202) {
                // Mostrar un mensaje de éxito al usuario
                navigation.navigate('VistaPrincipal');
                return true;
            }else if(statusLogin.status === 401) {
                Alert.alert(' El nombre de usuario o la contraseña es invalida.');
                clearInputs();
                return false;
            }
        } catch (error) {
          // Mostrar un mensaje de error al usuario
          clearInputs();
          Alert.alert('Ocurrió un error al iniciar sesión. Por favor inténtalo nuevamente');
          return false;
        }
    };

    const obtenerDatoUsuario = async() =>{
        try {
            const dataUser = await getDataUsuario();
            // Verificar si la respuesta de la API es exitosa
              if (dataUser.status === 200) {
                Alert.alert(
                    'Los datos de la cuenta son:',
                    'Email: ' + JSON.stringify(dataUser.data.email) + '\n' +
                    'Password: ' + JSON.stringify(dataUser.data.password)
                  );
              }else if(dataUser.status === 400) {
                  Alert.alert('Error al solicitar los datos de la cuenta');
                  clearInputs();
              }
          } catch (error) {
            Alert.alert('Ocurrió un error inesperado. Por favor inténtalo nuevamente', error);
          }
    };

    return { user, handleInputChange, verificarDatos,obtenerDatoUsuario};
};

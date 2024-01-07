import React, { useState } from 'react';
import { Alert } from 'react-native';
import {UserModel} from '../../../Domain/entities/User';
import { getUserDataGmail } from '../../../Domain/useCases/RecuperarDatosUsuarioGmail';
import { useNavigation } from '@react-navigation/native';

export const recuperarViewModel = () => {
    const [user, setUser] = useState(UserModel);
    const navigation = useNavigation();
  
    const handleInputChange = (name, text) => {
      setUser({ ...user, [name]: text });
    };
  
    const clearInputs = () => {
        setUser(UserModel);
    };

    const recuperarDatoUsuario = async(email) =>{
        if(email.trim()){   
            try {
            const dataUser = await getUserDataGmail(email);
            // Verificar si la respuesta de la API es exitosa
                if (dataUser.data.response !== null) {
                    Alert.alert(
                    'Los datos de tu cuenta son:',
                    'Email: ' + JSON.stringify(dataUser.data.response._username) + '\n' +
                    'Contraseña: ' + JSON.stringify(dataUser.data.response._password)
                    );
                    navigation.navigate('VistaLogin');
                }else{
                    clearInputs();
                }
            } catch (error) {
            Alert.alert('Error al solicitar los datos de la cuenta',error.message);
            }
        }else{
            Alert.alert('Por favor ingresa un correo electrónico');
        }
  };

  const regresarLogin = () =>{
    navigation.navigate('VistaLogin');
  };


    return { user, handleInputChange,recuperarDatoUsuario,regresarLogin};
};

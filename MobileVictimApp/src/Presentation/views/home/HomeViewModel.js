import React, { useState } from 'react';
import { Alert } from 'react-native';
//import { GetStatusConnection } from '../../../Domain/useCases/ConectionApi';

export const useHomeViewModel = () => {
    const [url, setUrl] = useState('');
    return {
        url,
        setUrl,
    };
};

export const homeViewModelConnection = async (urlApi) => { 
    const conexionRealizada = await GetStatusConnection(urlApi);
    if (conexionRealizada){
        Alert.alert('Conexión establecida con éxito');
        return true;
    }else{
        Alert.alert('Error al establecer la conexión');
        return false;
    }
};

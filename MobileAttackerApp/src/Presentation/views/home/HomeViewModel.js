
import { useNavigation } from '@react-navigation/native';
import { BackHandler,Alert } from 'react-native';

export const homeViewModel = () => { 
    const navigation = useNavigation();

    const continuarNavigation = () => {
        navigation.navigate('VistaLogin');
    };

    const exitApp = () => { ///Solo funciona en android
        if (Platform.OS === 'ios') {
            Alert.alert('Cerrar la aplicación', 'Por favor, cierra la aplicación manualmente', [{ text: 'OK' }]);
        } else if (Platform.OS === 'android') {
            BackHandler.exitApp();
        }
    };

    return{continuarNavigation,exitApp}
};

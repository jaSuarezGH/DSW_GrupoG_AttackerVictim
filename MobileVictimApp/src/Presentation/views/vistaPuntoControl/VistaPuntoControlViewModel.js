
import { PostUsuarioNotificacion } from '../../../Domain/useCases/EnviarNotificacion';
import { Alert } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import { Vibration } from 'react-native';

export const puntosControlViewModel = ()  => {

  const navigation = useNavigation();

    const enviarNotificacionContador = async(tipoNotification, TemporizadorAgotado) => {
      try{
        const notificacion = {
          "_status": tipoNotification,
          "_user": {
            "id": userID
          }
        };
        const solicitud = await PostUsuarioNotificacion(notificacion);
        if (TemporizadorAgotado){
          Alert.alert('Se ha notificado a las autoridades su situacion actual.');
          Vibration.vibrate();
          volverlVistaPrincipal(); 
        };
      }catch(error){
        Alert.alert(error);
      }
    };

    const volverlVistaPrincipal = () => {
      navigation.navigate('VistaPrincipal');
    };

 return {enviarNotificacionContador,volverlVistaPrincipal};
}


import { useState, useEffect } from 'react';

export const puntosControlViewModel = ()  => {

    const contadorPuntoControl = (initialSeconds = 0) => {
      const [time, setTime] = useState(initialSeconds);

      useEffect(() => {
        let interval = null;
        if (time > 0) {
          interval = setInterval(() => {
            setTime(time => time - 1);
          }, 1000);
        } else {
          Alert.alert('Se ha notificado a las autoridades de su situacion');
          clearInterval(interval);
        }
        return () => clearInterval(interval);
      }, [time]);
    
      return time;
    };


 return contadorPuntoControl;
}


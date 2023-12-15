import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { HomeScreen } from './src/Presentation/views/home/Home';
import { VistaLoginScreen } from './src/Presentation/views/vistaLogin/VistaLogin';
import { VistaPrincipalScreen } from './src/Presentation/views/vistaPrincipal/VistaPrincipal';
import { VistaRecuperacionScreen } from './src/Presentation/views/vistaRecuperacionDatos/VistaRecuperacionDatos';

const Stack = createNativeStackNavigator();

const App = () => {
  return(
      <NavigationContainer>
        <Stack.Navigator screenOptions={{
          headerShown: false
          }}>

            <Stack.Screen
              name ="Home"
              component={HomeScreen}
            />

            <Stack.Screen
              name ="VistaPrincipal"
              component={VistaPrincipalScreen}
            />

            <Stack.Screen
              name ="VistaLogin"
              component={VistaLoginScreen}
            />

            <Stack.Screen
              name ="VistaRecuperacionDatos"
              component={VistaRecuperacionScreen}
            />

        </Stack.Navigator>
      </NavigationContainer>
  );
};

export default App;
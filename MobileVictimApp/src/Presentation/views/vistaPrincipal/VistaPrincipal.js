import React from 'react';
import { View,Text,StyleSheet,TextInput } from 'react-native';


export const VistaPrincipalScreen = () => {
    return(
        <View style = {styles.container}>
            <Text style ={styles.textForm}>Status: </Text>
            <Text style ={styles.textForm}>Online</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#F74F51',
      alignItems: 'center',
      justifyContent: 'center',
      flexDirection:'row',
    },
    textForm:{
        fontWeight:'bold',
        fontSize:24,
        color:'white',

      },
});
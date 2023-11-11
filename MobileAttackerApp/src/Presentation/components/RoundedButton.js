import React from "react";
import { TouchableOpacity,Text,StyleSheet } from "react-native";
import { useNavigation } from '@react-navigation/native';
import { homeViewModelConnection } from "../views/home/HomeViewModel";


export const RoundedButton = ({text,onPress}) =>{
    const navigation = useNavigation();
    /*
    const handlePress = async () => {
        const isConnected = await homeViewModelConnection(urlApi);
        console.log(isConnected);
        if (isConnected) {
          navigation.navigate('VistaLogin');
        }
    };*/
    
    return(
        <TouchableOpacity
            style={styles.roundeButton}
            onPress = {onPress}
         >
            <Text
                style={styles.textButton}>{text}</Text>
        </TouchableOpacity> 
    )
}

const styles= StyleSheet.create({
    roundeButton:{
        with:'100%',
        height: 50,
        backgroundColor: '#1253C0',
        alignItems:'center',
        justifyContent:'center',
        borderRadius: 15,
        marginTop: 30,
    },
    textButton:{
        color:'white',
        fontWeight:'bold'
    }

})
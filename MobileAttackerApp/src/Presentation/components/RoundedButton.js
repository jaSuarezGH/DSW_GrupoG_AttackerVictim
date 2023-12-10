import React from "react";
import { TouchableOpacity,Text,StyleSheet } from "react-native";
import { useNavigation } from '@react-navigation/native';


export const RoundedButton = ({text,onPress}) =>{
    
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
        with:1000,
        height: 60,
        backgroundColor: '#1253C0',
        alignItems:'center',
        justifyContent:'center',
        borderRadius: 15,
        marginTop: 35,
    },
    textButton:{
        color:'white',
        fontWeight:'bold',
        fontSize:18,
    }

})
import React from "react";
import { TouchableOpacity,Text,StyleSheet } from "react-native";


export const RoundedButtonLogin = ({text,onPress}) =>{
    
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
        backgroundColor: '#3A84FF',
        alignItems:'center',
        justifyContent:'center',
        borderRadius: 15,
        marginTop: 15,
    },
    textButton:{
        color:'white',
        fontWeight:'bold'
    }

})
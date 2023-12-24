import React from "react";
import { TouchableOpacity,Text,StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

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
        with: windowWidth * 1.0,
        height: windowHeight * 0.07,
        backgroundColor: '#3A84FF',
        alignItems:'center',
        justifyContent:'center',
        borderRadius: 15,
        marginTop: 17 * (windowHeight / 820),
    },
    textButton:{
        color:'white',
        fontWeight:'bold',
        fontSize: 18 * (windowWidth / 390)
    }

})
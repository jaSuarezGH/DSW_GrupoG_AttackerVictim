import React from "react";
import { TouchableOpacity,Text,StyleSheet } from "react-native";
import { useNavigation } from '@react-navigation/native';
import { Dimensions } from 'react-native';

const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

export const RoundedButton = ({text,onPress}) =>{
    
    return(
        <TouchableOpacity
            style={styles.roundeButton}
            onPress = {onPress}
         >
            <Text
                style={styles.textButton}>{text}
            </Text>
        </TouchableOpacity> 
    )
}

const styles= StyleSheet.create({
    roundeButton:{
        with: windowWidth * 1.0,
        height: windowHeight * 0.09,
        backgroundColor: '#1253C0',
        alignItems:'center',
        justifyContent:'center',
        borderRadius: 15,
        marginTop: 50 * (windowHeight / 830),
    },
    textButton:{
        color:'white',
        fontWeight:'bold',
        fontSize:18,
    }

})
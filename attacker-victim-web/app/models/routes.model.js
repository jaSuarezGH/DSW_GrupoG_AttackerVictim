export const Routes = {
    
    HOME: '/',

    //SECCIONES
    PRINCIPAL: '/pages/principal',
    PRINCIPAL_VICTIM: '/pages/principal/seccionVictim',
    PRINCIPAL_ATTACKER: '/pages/principal/seccionAttacker',

    //Funcionalidades:
    GETALL_USERS: '/pages/principal/users/getAll',
    GET_NOTIFICATIONS: '',
    GETALL_ADMINS: '/pages/principal/users/getAll/admin',
    GETALL_VICTIMS: '/pages/principal/users/getAll/victim',
    GETALL_ATTACKERS: '/pages/principal/users/getAll/attacker',
    GET_USER: '/pages/principal/users/get',
    GET_USER_CEDULA: '/pages/principal/users/get/cedula/',
    GET_USER_EMAIL: '/pages/principal/users/get/email/',
    GET_USER_USERNAME: '/pages/principal/users/get/username/',
    GET_USER_MAC: '/pages/principal/users/get/mac/',
    UPDATE_ZS: '',
    UPDATE_RELATION: '',
    GET_LOCATION: '',
    CREATE_USER: '/pages/principal/users/createUsers',
    
    UPDATE_USER: '/pages/principal/users/updateUsers',
    UPDATE_USER_CEDULA: '/pages/principal/users/updateUsers/cedula/',
    UPDATE_USER_EMAIL: '/pages/principal/users/updateUsers/email/',
    UPDATE_USER_USERNAME: '/pages/principal/users/updateUsers/username/',
    UPDATE_USER_MAC: '/pages/principal/users/updateUsers/mac/',
    
    DELETE_USER: '',

    //Login
    SIGN_OFF: '/pages/login',
    FORGOT_PASS: '/pages/login/recuperarClave',

    //Inofmation:
    INF_REGISTER: '/pages/informacion/exitoRegistro'

}
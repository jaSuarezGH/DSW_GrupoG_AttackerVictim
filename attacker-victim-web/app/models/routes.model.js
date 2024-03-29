export const Routes = {
    
    HOME: '/',

    //SECCIONES
    PRINCIPAL: '/pages/principal',
    PRINCIPAL_VICTIM: '/pages/principal/seccionVictim',
    PRINCIPAL_ATTACKER: '/pages/principal/seccionAttacker',

    //FETCH
    FETCH_ERROR: '/pages/principal/fetch/fetchError',

    //Funcionalidades:
    GETALL_USERS: '/pages/principal/users/getAll',
    GETALL_ADMINS: '/pages/principal/users/getAll/admin',
    GETALL_VICTIMS: '/pages/principal/users/getAll/victim',
    GETALL_ATTACKERS: '/pages/principal/users/getAll/attacker',
    GET_USER: '/pages/principal/users/get',
    GET_USER_CEDULA: '/pages/principal/users/get/cedula/',
    GET_USER_EMAIL: '/pages/principal/users/get/email/',
    GET_USER_USERNAME: '/pages/principal/users/get/username/',
    GET_USER_MAC: '/pages/principal/users/get/mac/',


    GET_LOCATION_HOME: '/pages/principal/coordinates/consultPosicionamiento',
    GET_LOCATION_USER: '/pages/principal/coordinates/consultPosicionamiento/position/',
    
    CREATE_USER: '/pages/principal/users/createUsers',
    CREATE_ADMIN: '/pages/principal/users/admin/createAdmin',
    
    UPDATE_USER: '/pages/principal/users/updateUsers',
    UPDATE_USER_CEDULA: '/pages/principal/users/updateUsers/cedula/',
    UPDATE_USER_EMAIL: '/pages/principal/users/updateUsers/email/',
    UPDATE_USER_USERNAME: '/pages/principal/users/updateUsers/username/',
    UPDATE_USER_MAC: '/pages/principal/users/updateUsers/mac/',

    
    UPDATE_ADMIN: '/pages/principal/users/admin/updateAdmin',
    UPDATE_ADMIN_EMAIL: '/pages/principal/users/admin/updateAdmin/email/',
    UPDATE_ADMIN_USERNAME: '/pages/principal/users/admin/updateAdmin/username/',
    
    DELETE_USER: '/pages/principal/users/deleteUsers',
    DELETE_USER_CEDULA: '/pages/principal/users/deleteUsers/cedula/',
    DELETE_USER_EMAIL: '/pages/principal/users/deleteUsers/email/',
    DELETE_USER_USERNAME: '/pages/principal/users/deleteUsers/username/',
    DELETE_USER_MAC: '/pages/principal/users/deleteUsers/mac/',

    
    DELETE_ADMIN: '/pages/principal/users/admin/deleteAdmin',
    DELETE_ADMIN_EMAIL: '/pages/principal/users/admin/deleteAdmin/email/',
    DELETE_ADMIN_USERNAME: '/pages/principal/users/admin/deleteAdmin/username/',

    GET_RELATION: '/pages/principal/incident/get/',
    GET_RELATION_VICTIM: '/pages/principal/incident/get/victim/',
    GET_RELATION_ATTACKER: '/pages/principal/incident/get/attacker/',

    UPDATE_RELATION: '/pages/principal/incident/updateIncident/',
    UPDATE_RELATION_VICTIM: '/pages/principal/incident/updateIncident/victim/',
    UPDATE_RELATION_ATTACKER: '/pages/principal/incident/updateIncident/attacker/',

    CONSULT_ZS: '/pages/principal/coordinates/safeZone/consultSafeZone',
    CONSULT_ZS_EMAIL: '/pages/principal/coordinates/safeZone/consultSafeZone/email/',
    CREATE_ZS: '/pages/principal/coordinates/safeZone/createSafeZone/',
    CREATE_ZS_EMAIL: '/pages/principal/coordinates/safeZone/createSafeZone/email/',
    CREATE_ZS_RESPONSE: '/pages/principal/coordinates/safeZone/createSafeZone/response',
    DELETE_ZS: '/pages/principal/coordinates/safeZone/deleteSafeZone/',
    DELETE_ZS_EMAIL: '/pages/principal/coordinates/safeZone/deleteSafeZone/email/',
    DELETE_ZS_RESPONSE: '/pages/principal/coordinates/safeZone/deleteSafeZone/response',

    GET_ALL_STATUS: '/pages/principal/users/statusOnOff',
    GET_ALL_NOTIFICATIONS: '/pages/principal/notification',


    //Login
    SIGN_IN: '/pages/login',
    SIGN_OFF: '/pages/login',
    FORGOT_PASS: '/pages/login/recuperarClave',

    //Inofmation:
    INF_REGISTER: '/pages/informacion/exitoRegistro'

}
package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.user.atomic.*;
import com.ucab.cmcapp.logic.commands.user.composite.*;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetAllVictimListCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.GetAllVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CommandFactory {

    // ------------------( getAllUsers )-------------------------
    public static GetAllUserCommand createGetAllUserCommand(){
        return new GetAllUserCommand();
    }

    public static GetAllUserListCommand createGetAllUserListCommand(DBHandler handler){
        return new GetAllUserListCommand(handler);
    }

    // ------------------( getUserById )-------------------------
    public static GetUserCommand createGetUserCommand(User user) {
        return new GetUserCommand(user);
    }

    public static GetUserByIdCommand createGetUserByIdCommand(DBHandler handler, long userId) {
        return new GetUserByIdCommand(handler, userId);
    }

    // ------------------( getUserByEmail )----------------------
    public static GetUserByEmailCommand createGetUserByEmailCommand(User user) {
        return new GetUserByEmailCommand(user);
    }

    // ------------------( getUserByUsername )-------------------
    public static GetUserByUsernameCommand createGetUserByUsernameCommand(User user){
        return new GetUserByUsernameCommand(user);
    }

    // ------------------( getUserByPersonalId )-----------------
    public static GetUserByPersonalIdCommand createGetUserByPersonalIdCommand(User user){
        return new GetUserByPersonalIdCommand(user);
    }

    // ------------------( getUserByMacAddress )-----------------
    public static GetUserByMacAddressCommand createGetUserByMacAddressCommand(User user){
        return new GetUserByMacAddressCommand(user);
    }

    // ------------------( addUser )-----------------------------
    public static CreateUserCommand createCreateUserCommand(User user) {
        return new CreateUserCommand(user);
    }

    public static AddUserCommand createAddUserCommand(User user, DBHandler handler) {
        return new AddUserCommand(user, handler);
    }

    // ------------------( deleteUser )--------------------------
    public static DeleteUserCommand createDeleteUserCommand(User user) {
        return new DeleteUserCommand(user);
    }

    public static EraseUserCommand createEraseUserCommand(User user, DBHandler handler) {
        return new EraseUserCommand(user, handler);
    }

    // ------------------( updateUser )--------------------------
    public static UpdateUserCommand createUpdateUserCommand(User user){
        return new UpdateUserCommand(user);
    }

    public static ModifyUserCommand createModifyUserCommand(User user, DBHandler handler){
        return new ModifyUserCommand(user, handler);
    }

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static GetAllVictimCommand createGetAllVictimCommand(){
        return new GetAllVictimCommand();
    }

    public static GetAllVictimListCommand createGetAllVictimListCommand(DBHandler handler){
        return new GetAllVictimListCommand(handler);
    }

}

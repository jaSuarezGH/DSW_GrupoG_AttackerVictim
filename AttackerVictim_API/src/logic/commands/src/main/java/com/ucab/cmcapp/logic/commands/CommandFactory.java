package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.commands.user.atomic.*;
import com.ucab.cmcapp.logic.commands.user.composite.*;
import com.ucab.cmcapp.persistence.DBHandler;

public class CommandFactory {

    public static GetUserCommand createGetUserCommand(User user) {
        return new GetUserCommand(user);
    }

    public static GetUserByEmailCommand createGetUserByEmailCommand(User user) {
        return new GetUserByEmailCommand(user);
    }

    public static GetUserByUsernameCommand createGetUserByUsernameCommand(User user){
        return new GetUserByUsernameCommand(user);
    }

    public static GetUserByPersonalIdCommand createGetUserByPersonalIdCommand(User user){
        return new GetUserByPersonalIdCommand(user);
    }

    public static GetUserByMacAddressCommand createGetUserByMacAddressCommand(User user){
        return new GetUserByMacAddressCommand(user);
    }

    /*public static GetUserByEmailCommand createGetUserByEmailCommand(User user, DBHandler handler) {
        return new GetUserByEmailCommand(user, handler);
    }*/

    public static GetUserByIdCommand createGetUserByIdCommand(DBHandler handler, long userId) {
        return new GetUserByIdCommand(handler, userId);
    }

    public static AddUserCommand createAddUserCommand(User user, DBHandler handler) {
        return new AddUserCommand(user, handler);
    }

    /*public static AddUserCommand createAddUserCommand(User user) {
        return new AddUserCommand(user);
    }*/

    public static CreateUserCommand createCreateUserCommand(User user) {
        return new CreateUserCommand(user);
    }

    public static DeleteUserCommand createDeleteUserCommand(User user) {
        return new DeleteUserCommand(user);
    }

    public static EraseUserCommand createEraseUserCommand(User user, DBHandler handler) {
        return new EraseUserCommand(user, handler);
    }

    public static UpdateUserCommand createUpdateUserCommand(User user){
        return new UpdateUserCommand(user);
    }

    public static ModifyUserCommand createModifyUserCommand(User user, DBHandler handler){
        return new ModifyUserCommand(user, handler);
    }

    public static GetAllUserCommand createGetAllUserCommand(){
        return new GetAllUserCommand();
    }

    public static GetAllUserListCommand createGetAllUserListCommand(DBHandler handler){
        return new GetAllUserListCommand(handler);
    }

}

package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Incident.atomic.*;
import com.ucab.cmcapp.logic.commands.Incident.composite.CreateIncidentCommand;
import com.ucab.cmcapp.logic.commands.Incident.composite.DeleteIncidentCommand;
import com.ucab.cmcapp.logic.commands.Incident.composite.GetAllIncidentCommand;
import com.ucab.cmcapp.logic.commands.attacker.atomic.AddAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.atomic.EraseAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.atomic.GetAllAttackerListCommand;
import com.ucab.cmcapp.logic.commands.attacker.atomic.GetAttackerByUserIdCommand;
import com.ucab.cmcapp.logic.commands.attacker.composite.CreateAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.composite.DeleteAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.composite.GetAllAttackerCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.AddHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.EraseHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.GetAllHistoryByUserIdCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.GetAllHistoryListCommand;
import com.ucab.cmcapp.logic.commands.history.composite.CreateHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.DeleteHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.GetAllHistoryCommand;
import com.ucab.cmcapp.logic.commands.user.atomic.*;
import com.ucab.cmcapp.logic.commands.user.composite.*;
import com.ucab.cmcapp.logic.commands.victim.atomic.AddVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.EraseVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetAllVictimListCommand;
import com.ucab.cmcapp.logic.commands.victim.atomic.GetVictimByUserIdCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.CreateVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.DeleteVictimCommand;
import com.ucab.cmcapp.logic.commands.victim.composite.GetAllVictimCommand;
import com.ucab.cmcapp.persistence.DBHandler;

public class CommandFactory {

    // ------------------( getAllUsers )-------------------------
    public static GetAllUserCommand createGetAllUserCommand() {
        return new GetAllUserCommand();
    }

    public static GetAllUserListCommand createGetAllUserListCommand(DBHandler handler) {
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
    public static GetUserByUsernameCommand createGetUserByUsernameCommand(User user) {
        return new GetUserByUsernameCommand(user);
    }

    // ------------------( getUserByPersonalId )-----------------
    public static GetUserByPersonalIdCommand createGetUserByPersonalIdCommand(User user) {
        return new GetUserByPersonalIdCommand(user);
    }

    // ------------------( getUserByMacAddress )-----------------
    public static GetUserByMacAddressCommand createGetUserByMacAddressCommand(User user) {
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
    public static UpdateUserCommand createUpdateUserCommand(User user) {
        return new UpdateUserCommand(user);
    }

    public static ModifyUserCommand createModifyUserCommand(User user, DBHandler handler) {
        return new ModifyUserCommand(user, handler);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------( getAllVictims )-----------------------
    public static GetAllVictimCommand createGetAllVictimCommand() {
        return new GetAllVictimCommand();
    }

    public static GetAllVictimListCommand createGetAllVictimListCommand(DBHandler handler) {
        return new GetAllVictimListCommand(handler);
    }

    // ------------------( getVictimByUserId )-------------------
    public static GetVictimByUserIdCommand createGetVictimByUserIdCommand(Victim victim) {
        return new GetVictimByUserIdCommand(victim);
    }

    // ------------------( addVictim )---------------------------
    public static CreateVictimCommand createCreateVictimCommand(Victim victim) {
        return new CreateVictimCommand(victim);
    }

    public static AddVictimCommand createAddVictimCommand(Victim victim, DBHandler handler) {
        return new AddVictimCommand(victim, handler);
    }

    // ------------------( deleteVictim )------------------------
    public static DeleteVictimCommand createDeleteVictimCommand(Victim victim) {
        return new DeleteVictimCommand(victim);
    }

    public static EraseVictimCommand createEraseVictimCommand(Victim victim, DBHandler handler) {
        return new EraseVictimCommand(victim, handler);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------( getAllAttackers )---------------------
    public static GetAllAttackerCommand createGetAllAttackerCommand() {
        return new GetAllAttackerCommand();
    }

    public static GetAllAttackerListCommand createGetAllAttackerListCommand(DBHandler handler) {
        return new GetAllAttackerListCommand(handler);
    }

    // ------------------( getAttackerByUserId )-----------------
    public static GetAttackerByUserIdCommand createGetAttackerByUserIdCommand(Attacker attacker) {
        return new GetAttackerByUserIdCommand(attacker);
    }

    // ------------------( addAttacker )-------------------------
    public static CreateAttackerCommand createCreateAttackerCommand(Attacker attacker) {
        return new CreateAttackerCommand(attacker);
    }

    public static AddAttackerCommand createAddAttackerCommand(Attacker attacker, DBHandler handler) {
        return new AddAttackerCommand(attacker, handler);
    }

    // ------------------( deleteAttacker )----------------------
    public static DeleteAttackerCommand createDeleteAttackerCommand(Attacker attacker) {
        return new DeleteAttackerCommand(attacker);
    }

    public static EraseAttackerCommand createEraseAttackerCommand(Attacker attacker, DBHandler handler) {
        return new EraseAttackerCommand(attacker, handler);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------( getAllIncidents )---------------------
    public static GetAllIncidentCommand createGetAllIncidentCommand() {
        return new GetAllIncidentCommand();
    }

    public static GetAllIncidentListCommand createGetAllIncidentListCommand(DBHandler handler) {
        return new GetAllIncidentListCommand(handler);
    }

    // ------------------( getIncidentByVictimId )---------------
    public static GetIncidentByVictimIdCommand createGetIncidentByVictimIdCommand(Incident incident) {
        return new GetIncidentByVictimIdCommand(incident);
    }

    // ------------------( getIncidentByAttackerId )-------------
    public static GetIncidentByAttackerIdCommand createGetIncidentByAttackerIdCommand(Incident incident) {
        return new GetIncidentByAttackerIdCommand(incident);
    }

    // ------------------( addIncident )-------------------------
    public static CreateIncidentCommand createCreateIncidentCommand(Incident incident) {
        return new CreateIncidentCommand(incident);
    }

    public static AddIncidentCommand createAddIncidentCommand(Incident incident, DBHandler handler) {
        return new AddIncidentCommand(incident, handler);
    }

    // ------------------( deleteIncident )----------------------
    public static DeleteIncidentCommand createDeleteIncidentCommand(Incident incident) {
        return new DeleteIncidentCommand(incident);
    }

    public static EraseIncidentCommand createEraseIncidentCommand(Incident incident, DBHandler handler) {
        return new EraseIncidentCommand(incident, handler);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------( getAllHistories )---------------------
    public static GetAllHistoryCommand createGetAllHistoryCommand() {
        return new GetAllHistoryCommand();
    }

    public static GetAllHistoryListCommand createGetAllHistoryListCommand(DBHandler handler) {
        return new GetAllHistoryListCommand(handler);
    }

    // ------------------( getAllHistoryByUserId )---------------
    public static GetAllHistoryByUserIdCommand createGetAllHistoryByUserIdCommand(History history) {
        return new GetAllHistoryByUserIdCommand(history);
    }

    // ------------------( addHistory )--------------------------
    public static CreateHistoryCommand createCreateHistoryCommand(History history) {
        return new CreateHistoryCommand(history);
    }

    public static AddHistoryCommand createAddHistoryCommand(History history, DBHandler handler) {
        return new AddHistoryCommand(history, handler);
    }

    // ------------------( deleteHistory )-----------------------
    public static DeleteHistoryCommand createDeleteHistoryCommand(History history) {
        return new DeleteHistoryCommand(history);
    }

    public static EraseHistoryCommand createEraseHistoryCommand(History history, DBHandler handler) {
        return new EraseHistoryCommand(history, handler);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}

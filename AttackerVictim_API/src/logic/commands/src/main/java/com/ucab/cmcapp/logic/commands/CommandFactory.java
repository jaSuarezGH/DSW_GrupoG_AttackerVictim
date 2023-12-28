package com.ucab.cmcapp.logic.commands;

import com.ucab.cmcapp.common.entities.*;
import com.ucab.cmcapp.logic.commands.Incident.atomic.*;
import com.ucab.cmcapp.logic.commands.Incident.composite.*;
import com.ucab.cmcapp.logic.commands.administrator.atomic.*;
import com.ucab.cmcapp.logic.commands.administrator.composite.CreateAdministratorCommand;
import com.ucab.cmcapp.logic.commands.administrator.composite.DeleteAdministratorCommand;
import com.ucab.cmcapp.logic.commands.administrator.composite.GetAllAdministratorCommand;
import com.ucab.cmcapp.logic.commands.administrator.composite.UpdateAdministratorCommand;
import com.ucab.cmcapp.logic.commands.attacker.atomic.AddAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.atomic.EraseAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.atomic.GetAllAttackerListCommand;
import com.ucab.cmcapp.logic.commands.attacker.atomic.GetAttackerByUserIdCommand;
import com.ucab.cmcapp.logic.commands.attacker.composite.CreateAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.composite.DeleteAttackerCommand;
import com.ucab.cmcapp.logic.commands.attacker.composite.GetAllAttackerCommand;
import com.ucab.cmcapp.logic.commands.coordinate.atomic.AddCoordinateCommand;
import com.ucab.cmcapp.logic.commands.coordinate.atomic.GetAllCoordinateListCommand;
import com.ucab.cmcapp.logic.commands.coordinate.atomic.GetCoordinateByIdCommand;
import com.ucab.cmcapp.logic.commands.coordinate.composite.CreateCoordinateCommand;
import com.ucab.cmcapp.logic.commands.coordinate.composite.GetAllCoordinateCommand;
import com.ucab.cmcapp.logic.commands.coordinate.composite.GetCoordinateCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.AddHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.EraseHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.GetAllHistoryByUserIdCommand;
import com.ucab.cmcapp.logic.commands.history.atomic.GetAllHistoryListCommand;
import com.ucab.cmcapp.logic.commands.history.composite.CreateHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.DeleteHistoryCommand;
import com.ucab.cmcapp.logic.commands.history.composite.GetAllHistoryCommand;
import com.ucab.cmcapp.logic.commands.notification.atomic.AddNotificationCommand;
import com.ucab.cmcapp.logic.commands.notification.atomic.GetAllNotificationListCommand;
import com.ucab.cmcapp.logic.commands.notification.composite.CreateNotificationCommand;
import com.ucab.cmcapp.logic.commands.notification.composite.GetAllNotificationCommand;
import com.ucab.cmcapp.logic.commands.operation.atomic.GetAttackerLastPositionByIncidentIdCommand;
import com.ucab.cmcapp.logic.commands.operation.atomic.GetLastPositionsByIncidentIdCommand;
import com.ucab.cmcapp.logic.commands.operation.atomic.GetVictimLastPositionByIncidentIdCommand;
import com.ucab.cmcapp.logic.commands.safeZone.atomic.*;
import com.ucab.cmcapp.logic.commands.safeZone.composite.CreateSafeZoneCommand;
import com.ucab.cmcapp.logic.commands.safeZone.composite.DeleteSafeZoneCommand;
import com.ucab.cmcapp.logic.commands.safeZone.composite.GetAllSafeZoneCommand;
import com.ucab.cmcapp.logic.commands.safeZone.composite.UpdateSafeZoneCommand;
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

    // ------------------( getIncidentById )---------------------
    public static GetIncidentCommand createGetIncidentCommand(Incident incident) {
        return new GetIncidentCommand(incident);
    }

    public static GetIncidentByIdCommand createGetIncidentByIdCommand(DBHandler handler, long incidentId) {
        return new GetIncidentByIdCommand(handler, incidentId);
    }

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

    // ------------------( updateIncident )----------------------
    public static UpdateIncidentCommand createUpdateIncidentCommand(Incident incident) {
        return new UpdateIncidentCommand(incident);
    }

    public static ModifyIncidentCommand createModifyIncidentCommand(Incident incident, DBHandler handler) {
        return new ModifyIncidentCommand(incident, handler);
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

    // ------------------( getAllSafeZones )---------------------
    public static GetAllSafeZoneCommand createGetAllSafeZoneCommand() {
        return new GetAllSafeZoneCommand();
    }

    public static GetAllSafeZoneListCommand createGetAllSafeZoneListCommand(DBHandler handler) {
        return new GetAllSafeZoneListCommand(handler);
    }

    // ------------------( getAllSafeZoneByUserId )--------------
    public static GetAllSafeZoneByUserIdCommand createGetAllSafeZoneByUserIdCommand(SafeZone safeZone) {
        return new GetAllSafeZoneByUserIdCommand(safeZone);
    }

    // ------------------( addSafeZone )-------------------------
    public static CreateSafeZoneCommand createCreateSafeZoneCommand(SafeZone safeZone) {
        return new CreateSafeZoneCommand(safeZone);
    }

    public static AddSafeZoneCommand createAddSafeZoneCommand(SafeZone safeZone, DBHandler handler) {
        return new AddSafeZoneCommand(safeZone, handler);
    }

    // ------------------( deleteSafeZone )----------------------
    public static DeleteSafeZoneCommand createDeleteSafeZoneCommand(SafeZone safeZone) {
        return new DeleteSafeZoneCommand(safeZone);
    }

    public static EraseSafeZoneCommand createEraseSafeZoneCommand(SafeZone safeZone, DBHandler handler) {
        return new EraseSafeZoneCommand(safeZone, handler);
    }

    // ------------------( updateSafeZone )----------------------
    public static UpdateSafeZoneCommand createUpdateSafeZoneCommand(SafeZone safeZone) {
        return new UpdateSafeZoneCommand(safeZone);
    }

    public static ModifySafeZoneCommand createModifySafeZoneCommand(SafeZone safeZone, DBHandler handler) {
        return new ModifySafeZoneCommand(safeZone, handler);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------( getAllCoordinates )-------------------
    public static GetAllCoordinateCommand createGetAllCoordinateCommand() {
        return new GetAllCoordinateCommand();
    }

    public static GetAllCoordinateListCommand createGetAllCoordinateListCommand(DBHandler handler) {
        return new GetAllCoordinateListCommand(handler);
    }

    // ------------------( getCoordinateById )-------------------
    public static GetCoordinateCommand createGetCoordinateCommand(Coordinate coordinate) {
        return new GetCoordinateCommand(coordinate);
    }

    public static GetCoordinateByIdCommand createGetCoordinateByIdCommand(DBHandler handler, long coordinateId) {
        return new GetCoordinateByIdCommand(handler, coordinateId);
    }

    // ------------------( addCoordinate )-----------------------
    public static CreateCoordinateCommand createCreateCoordinateCommand(Coordinate coordinate) {
        return new CreateCoordinateCommand(coordinate);
    }

    public static AddCoordinateCommand createAddCoordinateCommand(Coordinate coordinate, DBHandler handler) {
        return new AddCoordinateCommand(coordinate, handler);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------( getAllAdministrators )----------------
    public static GetAllAdministratorCommand createGetAllAdministratorCommand() {
        return new GetAllAdministratorCommand();
    }

    public static GetAllAdministratorListCommand createGetAllAdministratorListCommand(DBHandler handler) {
        return new GetAllAdministratorListCommand(handler);
    }

    // ------------------( getAdministratorByEmail )-------------
    public static GetAdministratorByEmailCommand createGetAdministratorByEmailCommand(Administrator administrator) {
        return new GetAdministratorByEmailCommand(administrator);
    }

    // ------------------( getAdministratorByUsername )----------
    public static GetAdministratorByUsernameCommand createGetAdministratorByUsernameCommand(Administrator administrator) {
        return new GetAdministratorByUsernameCommand(administrator);
    }

    // ------------------( addAdministrator )--------------------
    public static CreateAdministratorCommand createCreateAdministratorCommand(Administrator administrator) {
        return new CreateAdministratorCommand(administrator);
    }

    public static AddAdministratorCommand createAddAdministratorCommand(Administrator administrator, DBHandler handler) {
        return new AddAdministratorCommand(administrator, handler);
    }

    // ------------------( deleteAdministrator )-----------------
    public static DeleteAdministratorCommand createDeleteAdministratorCommand(Administrator administrator) {
        return new DeleteAdministratorCommand(administrator);
    }

    public static EraseAdministratorCommand createEraseAdministratorCommand(Administrator administrator, DBHandler handler) {
        return new EraseAdministratorCommand(administrator, handler);
    }

    // ------------------( updateAdministrator )-----------------
    public static UpdateAdministratorCommand createUpdateAdministratorCommand(Administrator administrator) {
        return new UpdateAdministratorCommand(administrator);
    }

    public static ModifyAdministratorCommand createModifyAdministratorCommand(Administrator administrator, DBHandler handler) {
        return new ModifyAdministratorCommand(administrator, handler);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------( getSeparationDistanceByIncidentId )---------------
    // ------------------( getAttackerVictimLastPositionsByIncidentId )------
    public static GetLastPositionsByIncidentIdCommand createGetLastPositionsByIncidentIdCommand(Incident incident) {
        return new GetLastPositionsByIncidentIdCommand(incident);
    }

    // ------------------( getAttackerLastPositionsByIncidentId )------------
    public static GetAttackerLastPositionByIncidentIdCommand createGetAttackerLastPositionsByIncidentIdCommand(Incident incident) {
        return new GetAttackerLastPositionByIncidentIdCommand(incident);
    }

    // ------------------( getVictimLastPositionsByIncidentId )--------------
    public static GetVictimLastPositionByIncidentIdCommand createGetVictimLastPositionByIncidentIdCommand(Incident incident) {
        return new GetVictimLastPositionByIncidentIdCommand(incident);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------( getAllNotifications )-----------------
    public static GetAllNotificationCommand createGetAllNotificationCommand() {
        return new GetAllNotificationCommand();
    }

    public static GetAllNotificationListCommand createGetAllNotificationListCommand(DBHandler handler) {
        return new GetAllNotificationListCommand(handler);
    }

    // ------------------( addNotification )---------------------
    public static CreateNotificationCommand createCreateNotificationCommand(Notification notification) {
        return new CreateNotificationCommand(notification);
    }

    public static AddNotificationCommand createAddNotificationCommand(Notification notification, DBHandler handler) {
        return new AddNotificationCommand(notification, handler);
    }

}

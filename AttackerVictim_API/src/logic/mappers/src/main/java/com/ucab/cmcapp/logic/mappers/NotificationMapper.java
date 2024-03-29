package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.Notification;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.NotificationDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class NotificationMapper extends BaseMapper {

    /**
     * Este metodo mapea NotificationDto a Notification
     *
     * @param dto NotificationDto
     * @return Notification
     */
    public static Notification mapDtoToEntity(NotificationDto dto) {
        Notification entity = EntityFactory.createNotification();

        entity.set_id(dto.getId());
        entity.set_full_date(dto.get_full_date());
        entity.set_status(dto.get_status());
        entity.set_user(UserMapper.mapDtoToEntity(dto.get_user()));

        return entity;
    }

    /**
     * Este metodo mapea Notification a NotificationDto
     *
     * @param entity Notification
     * @return NotificationDto
     */
    public static NotificationDto mapEntityToDto(Notification entity) {
        final NotificationDto dto = new NotificationDto();

        dto.setId(entity.get_id());
        dto.set_full_date(entity.get_full_date());
        dto.set_status(entity.get_status());
        if (entity.get_user() != null)
            dto.set_user(UserMapper.mapEntityToDto(entity.get_user()));

        return dto;
    }

    /**
     * Este metodo mapea Notification a partir de un id
     *
     * @param id id asociado
     * @return Notification
     */
    public static Notification mapDtoToEntity(long id) {
        Notification entity = EntityFactory.createNotification(id);
        entity.set_id(id);
        return entity;
    }

    /**
     * Este metodo mapea una lista de Notification a una lista de NotificationDto
     *
     * @param entityList lista de Notification
     * @return lista de NotificationDto
     */
    public static List<NotificationDto> mapEntityListToDtoList(List<Notification> entityList) {
        List<NotificationDto> dtoList = new ArrayList<>();
        NotificationDto notificationDto;

        for (Notification notification : entityList) {
            notificationDto = new NotificationDto();
            notificationDto.setId(notification.get_id());
            notificationDto.set_full_date(notification.get_full_date());
            notificationDto.set_status(notification.get_status());
            notificationDto.set_user(UserMapper.mapEntityToDto(notification.get_user()));
            dtoList.add(notificationDto);
        }

        return dtoList;
    }

    /**
     * Este metodo mapea Notification a partir de un User
     *
     * @param userId id del User de Notification
     * @return Notification
     */
    public static Notification mapDtoToEntityUserId(long userId) {
        UserDto userDto = new UserDto(userId);
        Notification entity = EntityFactory.createNotification();
        entity.set_user(UserMapper.mapDtoToEntity(userDto));
        return entity;
    }

}

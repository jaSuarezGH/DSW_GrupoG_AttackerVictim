package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.History;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.HistoryDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class HistoryMapper extends BaseMapper {

    private static Logger _logger = LoggerFactory.getLogger(HistoryMapper.class);

    public static History mapDtoToEntity(HistoryDto dto) {
        History entity = EntityFactory.createHistory();

        entity.set_id(dto.getId());
        entity.set_full_date(dto.get_full_date());
        entity.set_status(dto.get_status());
        entity.set_latitude(dto.get_latitude());
        entity.set_longitude(dto.get_longitude());
        entity.set_user(UserMapper.mapDtoToEntity(dto.get_user()));

        return entity;
    }

    public static HistoryDto mapEntityToDto(History entity) {
        final HistoryDto dto = new HistoryDto();

        dto.setId(entity.get_id());
        dto.set_full_date(entity.get_full_date());
        dto.set_status(entity.get_status());
        dto.set_latitude(entity.get_latitude());
        dto.set_longitude(entity.get_longitude());
        if (entity.get_user() != null)
            dto.set_user(UserMapper.mapEntityToDto(entity.get_user()));

        return dto;
    }

    public static History mapDtoToEntity(long id) {
        History entity = EntityFactory.createHistory(id);
        entity.set_id(id);
        return entity;
    }

    public static List<HistoryDto> mapEntityListToDtoList(List<History> entityList) {
        List<HistoryDto> dtoList = new ArrayList<>();
        HistoryDto historyDto;

        for (History history : entityList) {
            historyDto = new HistoryDto();
            historyDto.setId(history.get_id());
            historyDto.set_full_date(history.get_full_date());
            historyDto.set_status(history.get_status());
            historyDto.set_latitude(history.get_latitude());
            historyDto.set_longitude(history.get_longitude());
            historyDto.set_user(UserMapper.mapEntityToDto(history.get_user()));
            dtoList.add(historyDto);
        }

        return dtoList;
    }

    public static History mapDtoToEntityUserId(long userId) {
        UserDto userDto = new UserDto(userId);
        History entity = EntityFactory.createHistory();
        entity.set_user(UserMapper.mapDtoToEntity(userDto));
        return entity;
    }

}

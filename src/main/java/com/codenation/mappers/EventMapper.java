package com.codenation.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.codenation.dto.EventDTO;
import com.codenation.entities.Event;

@Mapper(componentModel = "spring")
public interface EventMapper {
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "errorLevel", target = "errorLevel"),
		@Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
		@Mapping(source = "origin", target = "origin"),
		@Mapping(source = "description", target = "description")
	})
	
	EventDTO map(Event event);

    List<EventDTO> map(List<Event> events);


}

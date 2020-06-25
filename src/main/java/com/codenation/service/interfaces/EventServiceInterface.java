package com.codenation.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.codenation.entities.Event;

public interface EventServiceInterface {
	
	Event save(Event event);

	List<Event> findAll(Pageable pageable);
	
	List<Event> findAll(String level, String description, String log, String origin, Pageable pageable);

	Optional<Event> findById(Long id);

}

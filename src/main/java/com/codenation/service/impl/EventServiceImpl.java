package com.codenation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codenation.entities.ErrorLevel;
import com.codenation.entities.Event;
import com.codenation.repository.EventRepository;
import com.codenation.service.interfaces.EventServiceInterface;

@Service
public class EventServiceImpl implements EventServiceInterface{
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public Event save(Event event) {
		return this.eventRepository.save(event);
	}

	@Override
	public List<Event> findAll(Pageable pageable) {
		return this.eventRepository.findAll(pageable).getContent();
	}

	@Override
	public Optional<Event> findById(Long id) {
		return this.eventRepository.findById(id);
	}

	@Override
	public List<Event> findAll(String level, String description, String log, String origin, Pageable pageable) {
		level = ErrorLevel.get(level).getDescription();
		description = description.toUpperCase();
		log = log.toUpperCase();
		origin = origin.toUpperCase();
		return this.eventRepository.search(level, description, log, origin, pageable).getContent();
	}
}

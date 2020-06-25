package com.codenation.endpoints;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codenation.dto.EventDTO;
import com.codenation.endpoints.advice.ResourceNotFoundException;
import com.codenation.entities.ErrorLevel;
import com.codenation.entities.Event;
import com.codenation.mappers.EventMapper;
import com.codenation.service.interfaces.EventServiceInterface;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("event")
@AllArgsConstructor
public class EventController {

	private EventServiceInterface eventService;
	private EventMapper mapper;

	@PostMapping
	public ResponseEntity<Event> create(@Valid @RequestBody Event event, HttpServletRequest request) {
		String origin = URI.create(request.getRequestURL().toString()).toString();
		event.setId(null);
		event.setOrigin(origin);
		return new ResponseEntity<>(this.eventService.save(event), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Event not found"), @ApiResponse(code = 200, message = "Found")})
    public ResponseEntity<Event> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.eventService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event")), HttpStatus.OK);
    }
	
	@GetMapping
	@ApiOperation("Show all events")
	public ResponseEntity<Iterable<EventDTO>> findAll(Pageable pageable) {
		return new ResponseEntity<>(mapper.map(this.eventService.findAll(pageable)), HttpStatus.OK);
	}
	
	@GetMapping("/search")
	@ApiOperation("Search events using filters")
	public ResponseEntity<Iterable<EventDTO>> search(
			@RequestParam(value = "level", defaultValue = "") String level,
			@RequestParam(value = "description", defaultValue = "") String description,
			@RequestParam(value = "log", defaultValue = "") String log,
			@RequestParam(value = "origin", defaultValue = "") String origin,
			Pageable pageable) {
		return new ResponseEntity<>(mapper.map(this.eventService.findAll(level, description, log, origin, pageable)), HttpStatus.OK);
	}

}

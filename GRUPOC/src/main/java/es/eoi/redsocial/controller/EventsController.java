package es.eoi.redsocial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.service.EventService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/events")
public class EventsController {

	@Autowired
	private EventService eventService;
	
	@GetMapping
	public List<Event> findAll(){
		return eventService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Event> findById(@PathVariable Integer id) {
		return eventService.findById(id);
	}
	
	@PostMapping
	public String createEvent(@RequestBody Event event) {
		eventService.save(event);
		return event.getName();
	}
}

package es.eoi.redsocial.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.entity.Assistance;
import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.service.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventsController {

	@Autowired
	private EventService eventService;
	
	@GetMapping
	public List<Event> findAll(){
		return eventService.findAll();
	}
	
	@GetMapping("events/{id}")
	public Optional<Event> findById(@PathVariable Integer id) {
		return eventService.findById(id);
	}
	
	@PostMapping
	public String createEvent(@RequestBody Event event) {
		eventService.save(event);
		return event.getName();
	}
	
	@PostMapping("/{id}/yesAssistance")
	public String confirmAssistance(@PathVariable Integer id,
			@RequestBody User user) {
		
		Optional<Event> event= eventService.findById(id);
		Event e= new Event();
		e.setAssistances(event.get().getAssistances());
		e.setDescription(event.get().getDescription());
		e.setEventDate(event.get().getEventDate());
		e.setId(event.get().getId());
		e.setName(event.get().getName());
		e.setUser(user);
		Assistance assistance= new Assistance(true,user,e);
		e.getAssistances().add(assistance);
		eventService.save(e);
		
		return MessageFormat.format("{1}", assistance.isState());
	}
	
	@PostMapping("/{id}/notAssistance")
	public String deniedAssistance(@PathVariable Integer id,
			@RequestBody User user) {
		Optional<Event> event= eventService.findById(id);
		Event e= new Event();
		e.setAssistances(event.get().getAssistances());
		e.setDescription(event.get().getDescription());
		e.setEventDate(event.get().getEventDate());
		e.setId(event.get().getId());
		e.setName(event.get().getName());
		e.setUser(user);
		Assistance assistance= new Assistance(false,user,e);
		e.getAssistances().add(assistance);
		eventService.save(e); 
		return MessageFormat.format("{1}", assistance.isState());
	}
	
	
	
	@GetMapping("/{id}/users/yesAssistance")
	public List<User> confirmAssistanceList(@PathVariable Integer id) {
		Optional<Event> event= eventService.findById(id);
		List<User> users_confirmed= new ArrayList<User>();
		
		for (Assistance assistances : event.get().getAssistances()) {
			if(assistances.isState()) {
				users_confirmed.add(event.get().getUser());
			}
		}
		return users_confirmed;
	}
	
	@GetMapping("/{id}/users/notAssistance")
	public List<User> deniedAssistanceList(@PathVariable Integer id) {
		Optional<Event> event= eventService.findById(id);
		List<User> users_denied= new ArrayList<User>();
		
		for (Assistance assistances : event.get().getAssistances()) {
			if(!assistances.isState()) {
				users_denied.add(event.get().getUser());
			}
		}
		return users_denied;
	}
	
	
	@GetMapping("/user/{id}/yesAssistance")
	public List<Event> eventsUserAssistance(@PathVariable(value="id") Integer id_user){
	
		return eventService.findAssistanceByIdUser(id_user);
	}
	
	@GetMapping("/user/{id}/notAssistance")
	public List<Event> eventsUserNotAssistance(@PathVariable(value="id") Integer id_user){
		
		return eventService.findNotAssistanceByIdUser(id_user);
	}
}

package es.eoi.redsocial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import es.eoi.redsocial.entity.Assistance;
import es.eoi.redsocial.entity.Event;

public interface EventService {
	
	public List<Event> findAll();
	
	public Optional<Event> findById(Integer id);
	
	public void save(Event event);
	
	public List<Event> findAssistanceByIdUser(Integer id_user);
	
	public List<Event> findNotAssistanceByIdUser(Integer id_user);
}

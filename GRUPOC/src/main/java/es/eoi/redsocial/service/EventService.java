package es.eoi.redsocial.service;

import java.util.List;
import java.util.Optional;

import es.eoi.redsocial.entity.Event;

public interface EventService {
	
	public List<Event> findAll();
	
	public Optional<Event> findById(Integer id);
	
	public void save(Event event);
}

package es.eoi.redsocial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService{
	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public Optional<Event> findById(Integer id) {
		
		return eventRepository.findById(id);
	}

	@Override
	public void save(Event event) {
		eventRepository.save(event);
		
	}
	
}

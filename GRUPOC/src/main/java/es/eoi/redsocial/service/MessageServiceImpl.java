package es.eoi.redsocial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.repository.MessagesRepository;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessagesRepository messagesRepository;

	@Override
	public Optional<Message> findById(Integer id) {
		return messagesRepository.findById(id);
	}

	@Override
	public List<Message> findMessageByUserId(Integer id_user) {
		return messagesRepository.findMessageByIdUser(id_user);
	}

	@Override
	public Message createPost(Message message) {
		return messagesRepository.save(message);
	}

	@Override
	public void deleteMessage(Integer id) {
		messagesRepository.deleteById(id);
		
	}

	@Override
	public List<Relationship> findRelationshipByIdUser(Integer id_user) {
		return messagesRepository.findRelationshipByIdUser(id_user);
	}

	
	
	
	
}

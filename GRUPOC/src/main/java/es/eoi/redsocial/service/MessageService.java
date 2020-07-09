package es.eoi.redsocial.service;

import java.util.List;
import java.util.Optional;

import es.eoi.redsocial.entity.Message;

public interface MessageService {

	public Optional<Message> findById(Integer id);
	
	public List<Message> findMessageByUserId(Integer id_user);
	
	public Message createPost(Message message);
	
	public void deleteMessage(Integer id);
}

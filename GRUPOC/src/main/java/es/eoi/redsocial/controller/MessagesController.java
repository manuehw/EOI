package es.eoi.redsocial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Reaction;
import es.eoi.redsocial.service.MessageService;

@RestController
@RequestMapping(value = "/messages")
public class MessagesController {

	@Autowired
	private MessageService messageService;
	
	
	@GetMapping("/{id}")
	public Optional<Message> findById(@PathVariable Integer id) {
		
		return messageService.findById(id);
	}
	
	@GetMapping("/user/{id}")
	public List<Message> findMessageByUserId(@PathVariable("id") Integer id_user){
		
		return messageService.findMessageByUserId(id_user);
	}
	
	@PostMapping("/messages")
	public String createPost(@RequestBody Message message) {
		messageService.createPost(message);
		return message.getContent();
	}
	
	@GetMapping("/{id}/reactions")
	public List<Reaction> reactionList(@PathVariable Integer id){
		Optional<Message> message= messageService.findById(id);
		
		return message.get().getReactions();
	}
	
	@PostMapping("/{id}/reactions")
	public void userReactions(@PathVariable Integer id,
			@RequestBody String reaction, Integer id_user) {
		Optional<Message> message= messageService.findById(id);
		
		List<Reaction> message_reactions= message.get().getReactions();
		Reaction react = null;
		message_reactions.add(react);
		
	}
	
	@GetMapping("/user/{id}/friendPost")
	public void friendPost(@PathVariable Integer id) {
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteMessage(@PathVariable Integer id) {
		messageService.deleteMessage(id);
	}
}

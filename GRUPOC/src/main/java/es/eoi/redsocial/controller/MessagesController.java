package es.eoi.redsocial.controller;

import java.util.ArrayList;
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

import es.eoi.redsocial.dto.RelationshipDto;
import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Reaction;
import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.entity.User;
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
			@RequestBody String reaction, User user) {
		Optional<Message> message= messageService.findById(id);
		Message m= new Message();
		m.setContent(message.get().getContent());
		m.setId(message.get().getId());
		m.setPublishDate(message.get().getPublishDate());
		m.setReactions(message.get().getReactions());
		m.setUser(message.get().getUser());
		
		Reaction react = new Reaction(user,m,reaction);
		m.getReactions().add(react);
	
		messageService.createPost(m);
	}
	
	@GetMapping("/user/{id}/friendPost")
	public List<Message> friendPost(@PathVariable Integer id) {
		List<Relationship> relationships= messageService.findRelationshipByIdUser(id);
		List<Message> messages=new ArrayList<Message>();
		System.out.println(relationships);
		for (Relationship relationship : relationships) {
			if((relationship.getUser().getId()==id && relationship.getUser2().getId()!=id)) {
				messages=messageService.findMessageByUserId(relationship.getUser2().getId());
				
			}else if((relationship.getUser().getId()!=id && relationship.getUser2().getId()==id)) {
				messages=messageService.findMessageByUserId(relationship.getUser().getId());
			}
		}
		return messages;
	}
	
	@DeleteMapping("/{id}")
	public void deleteMessage(@PathVariable Integer id) {
		messageService.deleteMessage(id);
	}
	
	
	
}

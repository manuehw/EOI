package es.eoi.redsocial.dto;

import java.util.List;

import es.eoi.redsocial.entity.Assistance;
import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Reaction;
import es.eoi.redsocial.entity.Relationship;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class FulluserDto {

	private String name;

	private String surname;

	private String birthDate;

	private String user;

	private List<Event> events;

	private List<Message> messages;

	private List<Reaction> reactions;

	private List<Assistance> assistances;

	private List<Relationship> relationships;

}

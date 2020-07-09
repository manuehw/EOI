package es.eoi.redsocial.entity;



import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String birthDate;
	@Column
	private LocalDate startDate;
	@Column
	private String user;
	@Column
	private String pass;
	
	@OneToMany(mappedBy ="user")
	
	private List<Event> events;
	
	@OneToMany
	
	private List<Message> messages;
	
	@OneToMany
	
	private List<Reaction> reactions;
	
	@OneToMany
	
	private List<Assistance> assistances;
	
	@OneToMany
	
	private List<Relationship> relationships;
	
	
}

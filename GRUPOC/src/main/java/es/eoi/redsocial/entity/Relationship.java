package es.eoi.redsocial.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.eoi.redsocial.enums.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Relationship {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private State state;
	
	@ManyToOne
	@JoinColumn(name="user_1")
	User user;
	
	@ManyToOne
	@JoinColumn(name="user_2")
	User user2;
}

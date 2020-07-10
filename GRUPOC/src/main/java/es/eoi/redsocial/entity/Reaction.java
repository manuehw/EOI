package es.eoi.redsocial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="reaction")
public class Reaction {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_user")
	@JsonBackReference
	User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_message")
	@JsonBackReference
	Message message;
	
	@Column
	private String reactionType;

	public Reaction() {
		
	}
	
	public Reaction(User user, Message message, String reactionType) {
		
		this.user = user;
		this.message = message;
		this.reactionType = reactionType;
	}
	
	
	
	
}

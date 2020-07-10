package es.eoi.redsocial.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="relationship")
public class Relationship implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String state;
	
	@ManyToOne
	@JoinColumn(name="user_1")
	User user;
	
	@ManyToOne
	@JoinColumn(name="user_2")
	User user2;
	
	public Relationship() {
		
	}
	

	public Relationship(Integer id, String state, User user, User user2) {
		super();
		this.id = id;
		this.state = state;
		this.user = user;
		this.user2 = user2;
	}


	public Relationship(User user, User user2) {
		super();
		this.user = user;
		this.user2 = user2;
	}
	
	
}

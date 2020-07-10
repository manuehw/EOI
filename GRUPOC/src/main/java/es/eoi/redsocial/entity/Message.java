package es.eoi.redsocial.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="message")
public class Message {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String content;
	@Column
	private String publishDate;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	@JsonBackReference(value="user")
	User user;
	
	@OneToMany(mappedBy = "message",fetch = FetchType.LAZY)
	@JsonManagedReference(value="reactions")
	List<Reaction> reactions;

	
	public Message() {
		
	}
	
	public Message(String content, String publishDate, User user, List<Reaction> reactions) {
		super();
		this.content = content;
		this.publishDate = publishDate;
		this.user = user;
		this.reactions = reactions;
	}
	
	

	
	
	
}

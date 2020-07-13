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
	User user;
	
	@OneToMany(mappedBy = "message",fetch = FetchType.LAZY)
	List<Reaction> reactions;
	
	

	
	
	
}

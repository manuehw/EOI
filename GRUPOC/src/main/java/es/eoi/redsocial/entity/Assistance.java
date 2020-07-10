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
@Table(name="assistance")
public class Assistance {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column
	private boolean state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_user")
	User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_event")
	@JsonBackReference(value="event")
	Event event;
	
	public Assistance() {
		
	}
	
	public Assistance(boolean state, User user, Event event) {
		super();
		this.state = state;
		this.user = user;
		this.event = event;
	}
	
	
	
	
	
	
	
}

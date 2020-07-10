package es.eoi.redsocial.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private Date eventDate;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	@JsonBackReference(value="user")
	User user;
	
	@OneToMany(mappedBy = "event")
	@JsonManagedReference(value="assistances")
	List<Assistance> assistances;
	
	

	
}

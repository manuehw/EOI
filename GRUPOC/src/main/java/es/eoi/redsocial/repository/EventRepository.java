package es.eoi.redsocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.eoi.redsocial.entity.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
	
	@Query(value = "select id,description,event_date,name,id_user from event where id in(select id_event from assistance where id_user= :user_known and state=true)",
			nativeQuery=true)
	public List<Event> findAssistanceByIdUser(@Param("user_known") Integer id_user);
	
	@Query(value = "select id,description,event_date,name,id_user from event where id in(select id_event from assistance where id_user= :user_known and state=false)",
			nativeQuery=true)
	public List<Event> findNotAssistanceByIdUser(@Param("user_known") Integer id_user);
}

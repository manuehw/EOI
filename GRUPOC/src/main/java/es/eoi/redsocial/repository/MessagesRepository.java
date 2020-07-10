package es.eoi.redsocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.eoi.redsocial.dto.RelationshipDto;
import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Relationship;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Integer>{
	
	@Query(value = "SELECT id,content,publish_date,id_user FROM message WHERE id_user in(SELECT id FROM user WHERE id= :user_unknow)",
			nativeQuery=true)
	public List<Message> findMessageByIdUser(@Param("user_unknow") Integer id_user);
	
	
	@Query(value = "SELECT user_1,user_2 from relationship  where user_1=(select id from user where id= :user_unknow) and user_2!=(select id from user where id= :user_unknow) or "
			+ "user_1!=(select id from user where id= :user_unknow) and user_2=(select id from user where id= :user_unknow)",
			nativeQuery=true)
	public List<Relationship> findRelationshipByIdUser(@Param("user_unknow") Integer id_user);
}

package es.eoi.redsocial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.repository.RelationshipRepository;


@Service
public class RelationshipServiceImpl implements RelationshipService{

	
	
	
	RelationshipRepository relationshipRepository;
	
	
	@Override
	public List<Relationship> findAllFriends() {
		return relationshipRepository.findAll();
		
	}

}

package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Relationship;

public interface RelationshipService {
	
	
	public List<Relationship> findAllFriends();

}

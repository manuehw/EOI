package es.eoi.redsocial.service;

import java.util.List;
import java.util.Optional;

import es.eoi.redsocial.entity.User;

public interface UserService {

	
	public List<User> findAllUsers();
	
	
	public Optional<User> findOneUser(Integer id);
	
	public Optional<User> findOneFullUser(Integer id);
	
	
	public void createUser(User user);
}

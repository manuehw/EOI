package es.eoi.redsocial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	
	@Override
	public List<User> findAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findOneUser(Integer id) {
		
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> findOneFullUser(Integer id) {
		
		return userRepository.findById(id);
	}

	@Override
	public void createUser(User user) {
		userRepository.save(user);
		
	}

}

package es.eoi.redsocial.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.dto.FulluserDto;
import es.eoi.redsocial.dto.UserDto;
import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.service.RelationshipService;
import es.eoi.redsocial.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RelationshipService relationshipService;

	@Autowired
	private ModelMapper modelmapper;

	@GetMapping("/users")
	public List<UserDto> findAllUsers() {
		return userService.findAllUsers().stream().map(user -> modelmapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	@GetMapping("users/{id}")
	public UserDto findOneUser(@PathVariable Integer id) {
		return modelmapper.map(userService.findOneUser(id), UserDto.class);
	}

	@GetMapping("users/fullUser/{id}")
	public FulluserDto findOneFullUser(@PathVariable Integer id) {
		return modelmapper.map(userService.findOneUser(id), FulluserDto.class);
	}

	@PostMapping("users")
	public void createUser(@RequestBody User user) {
		userService.createUser(new User());
	}

	@PutMapping("users/{id}")
	public void updateUser(@PathVariable Integer id, @RequestBody String surname) {
		Optional<User> user = userService.findOneUser(id);
		user.get().setSurname(surname);

	}

	@GetMapping("users/{id}/friendsRelationship")
	public List<Relationship> findAllfriends(@PathVariable Integer id) {
		Optional<User> user = userService.findOneUser(id);

		return user.get().getRelationships().stream().filter(relation -> "FRIEND".equals(relation.getState()))
				.collect(Collectors.toList());

	}

	@GetMapping("/users/{id}/pendingRelationship")
	public List<Relationship> findAllpending(@PathVariable Integer id) {
		Optional<User> user = userService.findOneUser(id);

		return user.get().getRelationships().stream().filter(relation -> "PENDING".equals(relation.getState()))
				.collect(Collectors.toList());

	}

}

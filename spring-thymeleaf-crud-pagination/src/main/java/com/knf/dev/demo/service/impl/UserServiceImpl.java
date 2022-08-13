package com.knf.dev.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.knf.dev.demo.domain.User;
import com.knf.dev.demo.exception.RecordNotFoundException;
import com.knf.dev.demo.repository.UserRepository;
import com.knf.dev.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Page<User> findAllPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public void deleteUserById(Long id) throws RecordNotFoundException {

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No user record exist for given id");
		}
	}

	@Override
	public User createOrUpdateUser(User entity) {
		if (entity.getId() == null) {
			entity = userRepository.save(entity);

			return entity;
		} else {
			Optional<User> user = userRepository.findById(entity.getId());

			if (user.isPresent()) {
				User newEntity = user.get();
				newEntity.setEmail(entity.getEmail());
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());

				newEntity = userRepository.save(newEntity);

				return newEntity;
			} else {
				entity = userRepository.save(entity);

				return entity;
			}
		}
	}

	@Override
	public User getUserById(Long id) throws RecordNotFoundException {

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			return user.get();
		} else {
			throw new RecordNotFoundException("No user record exist for given id");
		}
	}

	@Override
	public List<User> getAllusers() {

		List<User> result = userRepository.findAll();
		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<User>();
		}
	}
}

package com.milesaway.service.impl;

import com.milesaway.exception.UserNotFoundException;
import com.milesaway.model.dto.UserDTO;
import com.milesaway.model.entity.User;
import com.milesaway.repository.UserRepository;
import com.milesaway.service.UserService;
import com.milesaway.util.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findUserById(Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("I can't find user with id: " + id));
        return UserConverter.toDTO(foundUser);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return UserConverter.toDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserConverter.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserConverter.toDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(userDTO.getName());
            existingUser.setEmail(userDTO.getEmail());
            User updatedUser = userRepository.save(existingUser);
            return UserConverter.toDTO(updatedUser);
        }).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

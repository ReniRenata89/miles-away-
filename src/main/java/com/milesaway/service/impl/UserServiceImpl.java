package com.milesaway.service.impl;

import com.milesaway.exception.UserNotFoundException;
import com.milesaway.model.dto.UserDTO;
import com.milesaway.model.entity.User;
import com.milesaway.repository.UserRepository;
import com.milesaway.service.UserService;
import com.milesaway.util.ModelConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
        return ModelConverter.convertToDTO(user);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream()
                .map(ModelConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = ModelConverter.convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return ModelConverter.convertToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("There is no user with this ID: " + id));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        User updatedUser = userRepository.save(user);
        return ModelConverter.convertToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("There is no user with this ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
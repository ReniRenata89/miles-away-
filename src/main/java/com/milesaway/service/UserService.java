package com.milesaway.service;

import com.milesaway.model.dto.UserDTO;
import java.util.List;

public interface UserService {

    UserDTO findUserById(Long id);

    List<UserDTO> findAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}

package com.milesaway.util;

import com.milesaway.model.dto.UserDTO;
import com.milesaway.model.entity.User;

public class ModelConverter {

    public static UserDTO convertToDTO(User user) {
        return new UserDTO(user.getName(), user.getEmail());
    }

    public static User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
package com.milesaway.util;

import com.milesaway.model.dto.UserDTO;
import com.milesaway.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getEmail(), null);
    }

    public static List<UserDTO> toDTOList(List<User> users) {
        return users.stream()
                .map(UserConverter::toDTO)
                .collect(Collectors.toList());
    }
}
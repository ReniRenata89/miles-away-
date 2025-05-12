package com.milesaway.controller;

import com.milesaway.model.dto.UserDTO;
import com.milesaway.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Manager", description = "API for managing users")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @Operation(summary = "Find a user by ID", description = "Find a user by their ID and return the found user")
    @GetMapping("{id}")
    public UserDTO findUser(@PathVariable long id) {

        return userService.findUserById(id);
    }

    @Operation(summary = "Get all users", description = "Retrieve all users in the database and return them in a list")
    @GetMapping
    public List<UserDTO> findAllUsers() {

        return userService.findAllUsers();
    }

    @Operation(summary = "Create a new user", description = "Create a new user with their name, email, and other details")
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {

        return userService.createUser(userDTO);
    }

    @Operation(summary = "Update an existing user", description = "Update an existing user by their ID and return the updated user")
    @PutMapping("{id}")
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @Operation(summary = "Delete a user", description = "Delete a user by their ID. A 200 OK response is returned if the user was deleted successfully")
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable long id) {

        userService.deleteUser(id);
    }
}
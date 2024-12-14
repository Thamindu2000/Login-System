package com.example.login.Controller;

import java.util.List;
import java.util.Optional;
import com.example.login.entity.User;
import com.example.login.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.login.dto.LoginDTO;
import com.example.login.dto.UserDTO;
import com.example.login.service.UserService;

@RestController
@RequestMapping(value = "api/v/user")
@CrossOrigin
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getuser")
    public List<UserDTO> getUser(){
        return userService.getAllUser();
    }

    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }

    @PostMapping("/saveuser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteuser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getuserbyemail/{email}")
    public UserDTO getUserByEmail(@PathVariable String email) {
        Optional<User> user = userRepo.findByEmail(email); // Use the repository
        return user.map(u -> modelMapper.map(u, UserDTO.class))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/getuser/{userId}")
    public UserDTO getUserById(@PathVariable int userId) {return userService.getUserById(userId);
    }








}
//post-login,saveuser
//put- updateuser
//delete- deleteuser
//get- getusers
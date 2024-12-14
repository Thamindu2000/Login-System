package com.example.login.service;

import com.example.login.dto.UserDTO;
import com.example.login.dto.LoginDTO;
import com.example.login.entity.User;
import com.example.login.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class UserService {

    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public List<UserDTO> getAllUser(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO getUserById(int userId) {
        Optional<User> userOpt = userRepo.findById(userId);
        return userOpt.map(user -> modelMapper.map(user, UserDTO.class)).orElse(null);
    }
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    public UserDTO loginUser(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepo.findByEmail(loginDTO.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(loginDTO.getPassword())) {

                return modelMapper.map(user, UserDTO.class);
            }
        }
        throw new RuntimeException("invalicdt email or password");
    }



}



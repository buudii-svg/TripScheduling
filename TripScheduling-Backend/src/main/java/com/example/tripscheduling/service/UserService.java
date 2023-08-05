package com.example.tripscheduling.service;

import com.example.tripscheduling.dto.StationDTO;
import com.example.tripscheduling.dto.UserDTO;
import com.example.tripscheduling.model.User;
import com.example.tripscheduling.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void signup(UserDTO user){
        userRepository.save(modelMapper.map(user, User.class));
    }

    //login method
//    public void login(String username, String password){
//        User user = userRepository.findByUsername(username);
//        if(user.getPassword().equals(password)){
//            System.out.println("Login successful");
//        }
//        else{
//            System.out.println("Login failed");
//        }
//    }

    public boolean login(UserDTO u){
        try{
            if(userRepository.findByUsername(modelMapper.map(u,User.class).getUsername()).getPassword().equals(u.getPassword())){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }


    public UserDTO getById(Long id){
        return modelMapper.map(userRepository.findById(id).orElse(null), UserDTO.class);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public List<UserDTO> getAllUsers(){
        return modelMapper.map(userRepository.findAll(), List.class);
    }

}
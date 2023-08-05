package com.example.tripscheduling.controller;

import com.example.tripscheduling.dto.StationDTO;
import com.example.tripscheduling.dto.UserDTO;
import com.example.tripscheduling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("")
@CrossOrigin( allowedHeaders="*",origins="*")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@RequestBody UserDTO user){
        userService.signup(user);
        return ResponseEntity.status(CREATED).body(null);
    }

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody UserDTO user){
        if(userService.login(user)){
            return ResponseEntity.ok().body(null);
        }   else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<HttpStatus> deleteAllUsers(){
        userService.deleteAllUsers();
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

}

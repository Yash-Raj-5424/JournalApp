package com.company.journalApp.controllers;

import com.company.journalApp.entities.JournalEntry;
import com.company.journalApp.entities.User;
import com.company.journalApp.services.JournalEntryService;
import com.company.journalApp.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userName){
        User dbUser = userService.findByUserName(userName);
        if(dbUser != null){
            dbUser.setUserName(user.getUserName());
            dbUser.setPassword(user.getPassword());
            userService.saveEntry(dbUser);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

package com.ekino.trombihack.service;

import com.ekino.trombihack.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public User getUserByUsername(String username) {
        User user = new User();
        user.setFirstName("Nicolas");
        user.setLastName("Gunther");
        user.setPhoneNumber("0699419169");
        user.setPic("https://image.noelshack.com/fichiers/2018/10/2/1520328766-familyguy-4.png");

        return user;
    }

    public List<User>  getUserByLocationAndCurrentProject(String location, String project) {
        return new ArrayList<>();
    }

    public List<User> getUserByCurrentProject(String project) {
        return new ArrayList<>();
    }

    public List<User> getUserByTitle(String title) {
        return new ArrayList<>();
    }

    public List<User> getUserByTitleAndLocation(String title, String location) {
        return new ArrayList<>();
    }

    public List<User> getUserBySchool(String school) {
        return new ArrayList<>();
    }

    public List<User> getUserBySchoolAndLocation(String school, String location) {
        return new ArrayList<>();
    }

    public List<User> getUserByLanguage(String language) {
        return new ArrayList<>();
    }

    public List<User> getUserByLanguageAndLocation(String language, String location) {
        return new ArrayList<>();
    }

    public List<User> getUserByHobby(String hobby) {
        return new ArrayList<>();
    }

    public List<User> getUserByHobbyAndLocation(String hobby, String location){
        return new ArrayList<>();
    }
}

package com.ekino.trombihack.service;

import com.ekino.trombihack.data.DataRepository;
import com.ekino.trombihack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private DataRepository dataRepository;

    public User getUserByName(String name) {
        return dataRepository.searchByName(name).get(0);
    }

    public List<User> getUserByLocationAndCurrentProject(String location, String project) {
        return dataRepository.searchByLocationAndProject(location,project);
    }

    public List<User> getUserByCurrentProject(String project) {
        return dataRepository.searchByCurrentProject(project);
    }

    public List<User> getUserByTitle(String title) {
        return dataRepository.searchByTitle(title);
    }

    public List<User> getUserByTitleAndLocation(String title, String location) {
        return dataRepository.searchByTitleAndLocation(title,location);
    }

    public List<User> getUserBySchool(String school) {
        return dataRepository.searchBySchool(school);
    }

    public List<User> getUserBySchoolAndLocation(String school, String location) {
        return dataRepository.searchBySchoolAndLocation(school,location);
    }

    public List<User> getUserByLanguage(String language) {
        return dataRepository.searchByLanguage(language);
    }

    public List<User> getUserByLanguageAndLocation(String language, String location) {
        return dataRepository.searchByLanguageAndLocation(language,location);
    }

    public List<User> getUserByHobby(String hobby) {
        return dataRepository.searchByHobby(hobby);
    }

    public List<User> getUserByHobbyAndLocation(String hobby, String location){
        return dataRepository.searchByHobbyAndLocation(hobby,location);
    }
}

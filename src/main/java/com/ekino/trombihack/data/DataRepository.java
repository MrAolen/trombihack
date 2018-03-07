package com.ekino.trombihack.data;

import com.ekino.trombihack.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataRepository {

    @Value("${data.file.json}")
    private String jsonFile;
    @Autowired
    private ResourceLoader resourceLoader;

    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/data/users.json");

        try (InputStream io = resource.getInputStream()) {
            load(io);
        }
    }

    public void load(InputStream io) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
        try {
            this.users = mapper.readValue(io,typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> searchByName(String name) {
        return  users.stream().filter(e -> e.getFirstName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public List<User> searchByLastName(String lastName) {
        return  users.stream().filter(e -> e.getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toList());
    }

    public List<User> searchByTitle(String title) {
        return users.stream().filter(e -> e.getTitle().equalsIgnoreCase(title) || e.getTitle().contains(title)).collect(Collectors.toList());
    }

    public List<User> searchByHiredAt(String hiredAt) {
        return users.stream().filter(e -> e.getHiredAt().equalsIgnoreCase(hiredAt)).collect(Collectors.toList());
    }

    public List<User> searchByLocation(String location) {
        return users.stream().filter(e -> e.getLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
    }

    public List<User> searchByCurrentProject(String project) {
        return users.stream().filter(e -> e.getProject().equalsIgnoreCase(project)).collect(Collectors.toList());
    }

    public List<User> searchByPastProject(String project) {
        return users.stream().filter(e -> e.getPastProjects().stream().anyMatch(i -> i.equalsIgnoreCase(project))).collect(Collectors.toList());
    }

    public List<User> searchBySlack(String slack) {
        return users.stream().filter(e -> e.getSlack().equalsIgnoreCase(slack)).collect(Collectors.toList());
    }

    public List<User> searchByEmail(String email) {
        return users.stream().filter(e -> e.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
    }

    public List<User> searchByPhoneNumber(String phoneNumber) {
        return users.stream().filter(e -> e.getPhoneNumber().equalsIgnoreCase(phoneNumber)).collect(Collectors.toList());
    }

    public List<User> searchBySchool(String school) {
        return users.stream().filter(e -> e.getSchool().equalsIgnoreCase(school)).collect(Collectors.toList());
    }

    public List<User> searchById(String id) {
        return users.stream().filter(e -> e.getId() == Integer.parseInt(id)).collect(Collectors.toList());
    }

    public List<User> searchByLanguage(String language) {
        return users.stream().filter(e -> e.getLanguages().stream().anyMatch(i -> i.getName().equalsIgnoreCase(language))).collect(Collectors.toList());
    }

    public List<User> searchByHobby(String hobby) {
        return users.stream().filter(e -> e.getHobbies().stream().anyMatch(i -> i.getHobbyName().equalsIgnoreCase(hobby))).collect(Collectors.toList());
    }

    public List<User> searchByLocationAndProject(String location, String project) {
        return searchByCurrentProject(project).stream().filter(e -> e.getLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
    }

    public List<User> searchByTitleAndLocation(String title, String location) {
        return searchByTitle(title).stream().filter(e -> e.getLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
    }

    public List<User> searchBySchoolAndLocation(String school, String location) {
        return searchBySchool(school).stream().filter(e -> e.getLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
    }

    public List<User> searchByLanguageAndLocation(String language, String location) {
        return searchByLanguage(language).stream().filter(e -> e.getLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
    }

    public List<User> searchByHobbyAndLocation(String hobby, String location) {
        return searchByHobby(hobby).stream().filter(e -> e.getLocation().equalsIgnoreCase(location)).collect(Collectors.toList());
    }
}

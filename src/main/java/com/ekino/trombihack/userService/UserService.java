package com.ekino.trombihack.userService;

import com.ekino.trombihack.user.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static User[] allUser;
    public static void run() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            User[] obj = mapper.readValue(new File("/Users/ruben.desert/Documents/workspace/trombihack/src/main/resources/data.json"), User[].class);
            setAllUser(obj);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> searchByUsername(String name) {
        User[] users = getAllUser();
        String lowerCaseName = name.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getFirstName().equals(lowerCaseName)).collect(Collectors.toList());
    }

    public static List<User> searchByLastName(String lastName) {
        User[] users = getAllUser();
        String lowerCaseLastName = lastName.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getLastName().equals(lowerCaseLastName)).collect(Collectors.toList());
    }

    public static List<User> searchByTitle(String title) {
        User[] users = getAllUser();
        String lowerCaseTitle = title.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getTitle().equals(lowerCaseTitle)).collect(Collectors.toList());
    }

    public static List<User> searchByHiredAt(String hiredAt) {
        User[] users = getAllUser();
        String lowerCaseElem = hiredAt.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getHiredAt().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByLocation(String location) {
        User[] users = getAllUser();
        String lowerCaseElem = location.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getLocation().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByProject(String project) {
        User[] users = getAllUser();
        String lowerCaseElem = project.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getProject().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByPastProject(String project) {
        User[] users = getAllUser();
        String lowerCaseElem = project.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getPastProjects().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchBySlack(String slack) {
        User[] users = getAllUser();
        String lowerCaseElem = slack.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getSlack().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByEmail(String email) {
        User[] users = getAllUser();
        String lowerCaseElem = email.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getEmail().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByPhoneNumber(String phoneNumber) {
        User[] users = getAllUser();
        String lowerCaseElem = phoneNumber.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getPhoneNumber().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchBySchool(String school) {
        User[] users = getAllUser();
        String lowerCaseElem = school.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getSchool().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchById(String id) {
        User[] users = getAllUser();
        String lowerCaseElem = id.toLowerCase();
        return  Arrays.asList(users).stream().filter(e -> e.getId().equals(lowerCaseElem)).collect(Collectors.toList());
    }



    private static void setAllUser(User[] Users) {
        allUser = Users;
    }

    private static User[] getAllUser()  {
        return allUser;
    }
}

package com.ekino.trombihack.userService;

import com.ekino.trombihack.user.Hobbies;
import com.ekino.trombihack.user.Languages;
import com.ekino.trombihack.user.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static List<User> allUser;
    public static void run() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<User> obj = mapper.readValue(new File("/Users/ruben.desert/Documents/workspace/trombihack/src/main/resources/data.json"), new TypeReference<List<User>>(){});
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
        List<User> users = getAllUser();
        String lowerCaseName = name.toLowerCase();
        return  users.stream().filter(e -> e.getFirstName().toLowerCase().equals(lowerCaseName)).collect(Collectors.toList());
    }

    public static List<User> searchByLastName(String lastName) {
        List<User> users = getAllUser();
        String lowerCaseLastName = lastName.toLowerCase();
        return users.stream().filter(e -> e.getLastName().toLowerCase().equals(lowerCaseLastName)).collect(Collectors.toList());
    }

    public static List<User> searchByTitle(String title) {
        List<User> users = getAllUser();
        String lowerCaseTitle = title.toLowerCase();
        return users.stream().filter(e -> e.getTitle().toLowerCase().equals(lowerCaseTitle)).collect(Collectors.toList());
    }

    public static List<User> searchByHiredAt(String hiredAt) {
        List<User> users = getAllUser();
        String lowerCaseElem = hiredAt.toLowerCase();
        return users.stream().filter(e -> e.getHiredAt().toLowerCase().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByLocation(String location) {
        List<User> users = getAllUser();
        String lowerCaseElem = location.toLowerCase();
        return users.stream().filter(e -> e.getLocation().toLowerCase().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByLocation(String location, List<User> data) {
        String lowerCaseElem = location.toLowerCase();
        return data.stream().filter(e -> e.getLocation().toLowerCase().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByProject(String project) {
        List<User> users = getAllUser();
        String lowerCaseElem = project.toLowerCase();
        return users.stream().filter(e -> e.getProject().toLowerCase().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByPastProject(String project) {
        List<User> users = getAllUser();
        List<User> tempUser = new ArrayList<>();
        String lowerCaseElem = project.toLowerCase();
        for(User user: users) {
            ArrayList<String> pastProjects = user.getPastProjects();
            for(String pastProject: pastProjects) {
                if(pastProject.toLowerCase().equals(lowerCaseElem)) {
                    tempUser.add(user);
                }
            }
        }
        return tempUser;
    }

    public static List<User> searchBySlack(String slack) {
        List<User> users = getAllUser();
        String lowerCaseElem = slack.toLowerCase();
        return users
                .stream()
                .filter(e -> e.getSlack().toLowerCase().equals(lowerCaseElem))
                .collect(Collectors.toList());
    }

    public static List<User> searchByEmail(String email) {
        List<User> users = getAllUser();
        String lowerCaseElem = email.toLowerCase();
        return users.stream().filter(e -> e.getEmail().toLowerCase().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchByPhoneNumber(String phoneNumber) {
        List<User> users = getAllUser();
        String lowerCaseElem = phoneNumber.toLowerCase();
        return users.stream().filter(e -> e.getPhoneNumber().toLowerCase().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchBySchool(String school) {
        List<User> users = getAllUser();
        String lowerCaseElem = school.toLowerCase();
        return users.stream().filter(e -> e.getSchool().toLowerCase().equals(lowerCaseElem)).collect(Collectors.toList());
    }

    public static List<User> searchById(Integer id) {
        List<User> users = getAllUser();
        return  users.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());
    }

    public static List<User> searchByLanguage(String language) {
        List<User> users = getAllUser();
        List<User> tempUser = new ArrayList<>();
        for(User user: users) {
            Languages[] langs = user.getLanguages();
            for(Languages lang: langs) {
                if(lang.getLanguageName().toLowerCase().equals(language)) {
                    tempUser.add(user);
                }
            }
        }
        return tempUser;
    }

    public static List<User> searchByHobbies(String hobby) {
        List<User> users = getAllUser();
        List<User> tempUser = new ArrayList<>();
        for(User user: users) {
            Hobbies[] hobbies = user.getHobbies();
            for(Hobbies singleHobby: hobbies) {
                if(singleHobby.getHobbyName().toLowerCase().equals(hobby.toLowerCase())) {
                    tempUser.add(user);
                }
            }
        }
        return tempUser;
    }

    public static List<User> searchByHobbyLocation(String hobby, String location) {
        List<User> tempUser = searchByHobbies(hobby);

        return searchByLocation(location, tempUser);
    }

    public static List<User> searchByTitleLocation(String title, String location) {
        List<User> tempUser = searchByTitle(title);

        return searchByLocation(location, tempUser);
    }

    public static List<User> searchBySchoolLocation(String school, String location) {
        List<User> tempUser = searchBySchool(school);

        return searchByLocation(location, tempUser);
    }

    public static List<User> searchByLanguageLocation(String language, String location) {
        List<User> tempUser = searchByLanguage(language);

        return searchByLocation(location, tempUser);
    }


    private static void setAllUser(List<User> Users) {
        System.out.println();
        allUser = Users;
    }

    private static List<User> getAllUser()  {
        return allUser;
    }
}

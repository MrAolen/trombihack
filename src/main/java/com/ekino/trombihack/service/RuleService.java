package com.ekino.trombihack.service;

import com.ekino.trombihack.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class RuleService {
    @Value("${pattern.title.user}")
    private String patternTitleUser;
    @Value("${pattern.location.user}")
    private String patternLocationUser;
    @Value("${pattern.project.user}")
    private String patternProjectUser;
    @Value("$(pattern.past.projects.user}")
    private String patternPastProjectsUser;
    @Value("${pattern.profile.user}")
    private String patternProfileUser;
    @Value("${pattern.picture.user}")
    private String patternPictureUser;
    @Value("${pattern.citation.user}")
    private String patternCitationUser;
    @Value("${pattern.xp.user}")
    private String patternXpUser;
    @Value("${pattern.location.project}")
    private String patternLocationProject;
    @Value("${pattern.people.project}")
    private String patternPeopleProject;
    @Value("${pattern.title}")
    private String patternTitle;
    @Value("${pattern.title.location}")
    private String patternTitleLocation;
    @Value("${pattern.school}")
    private String patternSchool;
    @Value("${pattern.school.location}")
    private String patternSchoolLocation;
    @Value("${pattern.language}")
    private String patternLanguage;
    @Value("${pattern.language.location}")
    private String patternLanguageLocation;
    @Value("${pattern.hobby}")
    private String patternHobby;
    @Value("${pattern.hobby.location}")
    private String patternHobbyLocation;
    @Value("${pattern.user}")
    private String patternUser;

    @Autowired
    private UserService userService;

    public List<User> proceedCommand(String command) {
        System.out.println("Receive command from user : " + command);
        String[] query = command.split(" ");

        if (Pattern.compile(patternUser).matcher(command).matches()) {
            System.out.println("Find By name");
            return Arrays.asList(userService.getUserByName(query[1]));
        } else if (Pattern.compile(patternLocationProject).matcher(command).matches()) {
            System.out.println("Find By location and current Project");
            return userService.getUserByLocationAndCurrentProject(query[1],concatFromIndexToLast(3,query));
        } else if (Pattern.compile(patternPeopleProject).matcher(command).matches()) {
            System.out.println("Find By current Project");
            return userService.getUserByCurrentProject(query[1]);
        } else if (Pattern.compile(patternTitle).matcher(command).matches()) {
            System.out.println("Find By title");
            return userService.getUserByTitle(query[1]);
        } else if (Pattern.compile(patternTitleLocation).matcher(command).matches()) {
            System.out.println("Find By title and location");
            return userService.getUserByTitleAndLocation(query[1],concatFromIndexToLast(3,query));
        } else if (Pattern.compile(patternSchool).matcher(command).matches()) {
            System.out.println("Find By school");
            return userService.getUserBySchool(query[1]);
        } else if (Pattern.compile(patternSchoolLocation).matcher(command).matches()) {
            System.out.println("Find By school and location");
            return userService.getUserBySchoolAndLocation(query[1],concatFromIndexToLast(3,query));
        } else if (Pattern.compile(patternLanguage).matcher(command).matches()) {
            System.out.println("Find By language spoken");
            return userService.getUserByLanguage(query[1]);
        } else if (Pattern.compile(patternLanguageLocation).matcher(command).matches()) {
            System.out.println("Find By language and location");
            return userService.getUserByLanguageAndLocation(query[1],concatFromIndexToLast(3,query));
        } else if (Pattern.compile(patternHobby).matcher(command).matches()) {
            System.out.println("Find By hobby");
            return userService.getUserByHobby(query[1]);
        } else if (Pattern.compile(patternHobbyLocation).matcher(command).matches()) {
            System.out.println("Find By hobby and location");
            return userService.getUserByHobbyAndLocation(query[1],concatFromIndexToLast(3,query));
        }
        System.out.println("No match found");
        return new ArrayList<>();
    }

    private String concatFromIndexToLast(int index, String[] arrayOfString) {
        String result = "";
        for (int i = index; i < arrayOfString.length; i++) {
            result += arrayOfString[i];
        }
        return result;
    }


}

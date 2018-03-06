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
    private static final Logger logger = LoggerFactory.getLogger(RuleService.class);

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

    @Autowired
    private UserService userService;

    public List<User> proceedCommand(String command) {
        System.out.println("Receive command from user : " + command);
        logger.info("Receive command from user : " + command);

        if (Pattern.compile(patternTitleUser).matcher(command).matches()) {
            return Arrays.asList(userService.getUserByName(""));
        } else if (Pattern.compile(patternLocationUser).matcher(command).matches()) {
            return Arrays.asList(userService.getUserByName(""));
        } else if (Pattern.compile(patternProjectUser).matcher(command).matches()) {
            return Arrays.asList(userService.getUserByName(""));
        } else if (Pattern.compile(patternPastProjectsUser).matcher(command).matches()) {
            return Arrays.asList(userService.getUserByName(""));
        } else if (Pattern.compile(patternProfileUser).matcher(command).matches()) {
            return Arrays.asList(userService.getUserByName(""));
        } else if (Pattern.compile(patternPictureUser).matcher(command).matches()) {
            return Arrays.asList(userService.getUserByName(""));
        } else if (Pattern.compile(patternCitationUser).matcher(command).matches()) {
            return Arrays.asList(userService.getUserByName(""));
        } else if (Pattern.compile(patternXpUser).matcher(command).matches()) {
            return Arrays.asList(userService.getUserByName(""));
        } else if (Pattern.compile(patternLocationProject).matcher(command).matches()) {
            return userService.getUserByLocationAndCurrentProject("","");
        } else if (Pattern.compile(patternPeopleProject).matcher(command).matches()) {
            return userService.getUserByCurrentProject("");
        } else if (Pattern.compile(patternTitle).matcher(command).matches()) {
            return userService.getUserByTitle("");
        } else if (Pattern.compile(patternTitleLocation).matcher(command).matches()) {
            return userService.getUserByTitleAndLocation("","");
        } else if (Pattern.compile(patternSchool).matcher(command).matches()) {
            return userService.getUserBySchool("");
        } else if (Pattern.compile(patternSchoolLocation).matcher(command).matches()) {
            return userService.getUserBySchoolAndLocation("","");
        } else if (Pattern.compile(patternLanguage).matcher(command).matches()) {
            return userService.getUserByLanguage("");
        } else if (Pattern.compile(patternLanguageLocation).matcher(command).matches()) {
            return userService.getUserByLanguageAndLocation("","");
        } else if (Pattern.compile(patternHobby).matcher(command).matches()) {
            return userService.getUserByHobby("");
        } else if (Pattern.compile(patternHobbyLocation).matcher(command).matches()) {
            return userService.getUserByHobbyAndLocation("","");
        }
        return new ArrayList<>();
    }


}

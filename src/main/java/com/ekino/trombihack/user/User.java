package com.ekino.trombihack.user;


import com.fasterxml.jackson.databind.ObjectMapper;
import me.ramswaroop.jbot.core.slack.Bot;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String title;
    private String hiredAt;
    private String location;
    private String project;
    private ArrayList<String> pastProjects;
    private String slack;
    private String email;
    private String phoneNumber;
    private String school;
    private String pic;
    private String experience;
    private ArrayList<String> technos;
    private String quote;
    private Hobbies[] hobbies;
    private Languages[] languages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHiredAt() {
        return hiredAt;
    }

    public void setHiredAt(String hiredAt) {
        this.hiredAt = hiredAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSlack() {
        return slack;
    }

    public void setSlack(String slack) {
        this.slack = slack;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public ArrayList<String> getTechnos() {
        return technos;
    }

    public void setTechnos(ArrayList technos) {
        this.technos = technos;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Hobbies[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobbies[] hobbies) {
        this.hobbies = hobbies;
    }

    public Languages[] getLanguages() {
        return languages;
    }

    public void setLanguages(Languages[] language) {
        this.languages = language;
    }

    public ArrayList<String> getPastProjects() {
        return pastProjects;
    }

    public void setPastProjects(ArrayList<String> pastProjects) {
        this.pastProjects = pastProjects;
    }
}

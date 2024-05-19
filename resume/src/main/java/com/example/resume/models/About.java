package com.example.resume.models;

import java.util.List;

public class About {
    private String name;
    private String jobTitle;
    private String description;
    private int age;
    private String residence;
    private boolean isFreelanceAvailable;
    private String address;
    private List<String> socialLinks;


    public About(String name, String jobTitle, String description, int age, String residence, boolean isFreelanceAvailable, String address, List<String> socialLinks) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.description = description;
        this.age = age;
        this.residence = residence;
        this.isFreelanceAvailable = isFreelanceAvailable;
        this.address = address;
        this.socialLinks = socialLinks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public boolean isFreelanceAvailable() {
        return isFreelanceAvailable;
    }

    public void setFreelanceAvailable(boolean freelanceAvailable) {
        isFreelanceAvailable = freelanceAvailable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(List<String> socialLinks) {
        this.socialLinks = socialLinks;
    }
}
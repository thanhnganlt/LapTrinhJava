package com.example.resume.models;

import java.util.List;

public class Resume {
    public static class Entry {
        protected String date, description;

        public Entry(String date, String description) {
            this.date = date;
            this.description = description;
        }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }

    public static class Experience extends Entry {
        private String jobTitle, company;

        public Experience(String date, String jobTitle, String company, String description) {
            super(date, description);
            this.jobTitle = jobTitle;
            this.company = company;
        }

        public String getJobTitle() { return jobTitle; }
        public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
        public String getCompany() { return company; }
        public void setCompany(String company) { this.company = company; }
    }

    public static class Education extends Entry {
        private String course, institution;

        public Education(String date, String course, String institution, String description) {
            super(date, description);
            this.course = course;
            this.institution = institution;
        }

        public String getCourse() { return course; }
        public void setCourse(String course) { this.course = course; }
        public String getInstitution() { return institution; }
        public void setInstitution(String institution) { this.institution = institution; }
    }
    public static class Skill {
        private String name;
        private int percentage;

        public Skill(String name, int percentage) {
            this.name = name;
            this.percentage = percentage;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPercentage() {
            return percentage;
        }

        public void setPercentage(int percentage) {
            this.percentage = percentage;
        }
    }
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skill> designSkills;
    private List<Skill> codingSkills;

    public Resume(List<Experience> experiences, List<Education> educations, List<Skill> designSkills, List<Skill> codingSkills) {
        this.experiences = experiences;
        this.educations = educations;
        this.designSkills =designSkills;
        this.codingSkills =codingSkills;
    }

    public List<Experience> getExperiences() { return experiences; }
    public void setExperiences(List<Experience> experiences) { this.experiences = experiences; }
    public List<Education> getEducations() { return educations; }
    public void setEducations(List<Education> educations) { this.educations = educations; }
    public List<Skill> getDesignSkills() {
        return designSkills;
    }

    public void setDesignSkills(List<Skill> designSkills) {
        this.designSkills = designSkills;
    }

    public List<Skill> getCodingSkills() {
        return codingSkills;
    }

    public void setCodingSkills(List<Skill> codingSkills) {
        this.codingSkills = codingSkills;
    }
}

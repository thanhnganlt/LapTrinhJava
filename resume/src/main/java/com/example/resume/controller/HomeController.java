package com.example.resume.controller;

import com.example.resume.models.About;
import com.example.resume.models.Contact;
import com.example.resume.models.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getAbout(Model model) {
        About about = new About(
                "Lê Thị Thanh Ngân",
                "Backend Developer",
                "My short-term objective is to work as a back-end developer...",
                21,
                "Vietnam",
                true,
                "Ho Chi Minh City, Vietnam",
                Arrays.asList("https://linkedin.com/in/thanhnganlt", "https://github.com/thanhnganlt")
        );
        model.addAttribute("about", about);
        return "about";
    }
    @GetMapping("/resume")
    public String getResume(Model model) {
        Resume resume = new Resume(
                Arrays.asList(
                        new Resume.Experience("05/2024 - PRESENT", "Intern Developer", "ABC Company", "Assisted in developing..."),
                        new Resume.Experience("07/2023 - 05/2024", "Backend Developer", "Hutech JSC", "Developing backend systems...")

                ),
                Arrays.asList(
                        new Resume.Education("2021 - PRESENT", "BSc in Computer Science", "Hutech University", "Major in Software Engineering")
                ),
                Arrays.asList(
                        new Resume.Skill("Web Design", 70),
                        new Resume.Skill("Write Music", 76),
                        new Resume.Skill("Photoshop", 66),
                        new Resume.Skill("Graphic Design", 86)
                ),
                Arrays.asList(
                        new Resume.Skill("WordPress", 50),
                        new Resume.Skill("PHP/MYSQL", 40),
                        new Resume.Skill("Angular/JavaScript", 95),
                        new Resume.Skill("HTML/CSS", 100)
                )
        );
        model.addAttribute("resume", resume);
        return "resume";
    }
    @GetMapping("/contact")
    public String getContact(Model model) {
        Contact contact = new Contact(
                "Ho Chi Minh City, Vietnam",
                "thanhngan.7170@gmail.com",
                "0974176867",
                true
        );
        model.addAttribute("contact", contact);
        return "contact";
    }
}

package com.example.SinhVien.controller;

import com.example.SinhVien.model.SinhVien;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
@Controller
public class SinhVienController {
    @GetMapping("/sinhvien")
    public String showForm(Model model) {
        model.addAttribute("sinhVien", new SinhVien());
        return "SinhVien/form-sinhvien";
    }
    @PostMapping("/sinhvien")
    public String submitForm(@Valid SinhVien sinhVien, BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "SinhVien/form-sinhvien";
        }
        model.addAttribute("message", "Sinh viên đã được thêm thành công!");
        return "SinhVien/result-sinhvien";
    }
}
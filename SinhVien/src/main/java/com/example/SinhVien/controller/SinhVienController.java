package com.example.SinhVien.controller;

import com.example.SinhVien.model.SinhVien;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class SinhVienController {
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

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

        // Lưu ảnh
        MultipartFile file = sinhVien.getAnhFile();
        if (file != null && !file.isEmpty()) {
            try {
                // Đảm bảo thư mục lưu trữ tồn tại
                Path uploadPath = Paths.get(UPLOADED_FOLDER);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                sinhVien.setAnh(file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            model.addAttribute("sinhVien", sinhVien);
            model.addAttribute("message", "Sinh viên đã được thêm thành công!");
            return "SinhVien/result-sinhvien";
        }
    }
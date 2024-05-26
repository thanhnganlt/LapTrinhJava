package com.example.SinhVien.controller;

import com.example.SinhVien.model.SinhVien;
import com.example.SinhVien.services.LopService;
import com.example.SinhVien.services.MonHocService;
import com.example.SinhVien.services.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sinhVien")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private LopService lopService;

    @Autowired
    private MonHocService monHocService;

    @GetMapping
    public String showAllSinhVien(Model model) {
        List<SinhVien> dsSinhVien = sinhVienService.getAllSinhVien();
        model.addAttribute("dsSinhVien", dsSinhVien);
        return "sinhVien/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sinhVien", new SinhVien());
        model.addAttribute("danhSachLop", lopService.getAllLop());
        model.addAttribute("danhSachMonHoc", monHocService.getAllMonHoc());
        return "sinhVien/add";
    }

    @PostMapping("/add")
    public String addSinhVien(@ModelAttribute("sinhVien") SinhVien sinhVien) {
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/sinhVien";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        SinhVien sinhVien = sinhVienService.getSinhVienById(id);
        if (sinhVien != null) {
            model.addAttribute("sinhVien", sinhVien);
            model.addAttribute("danhSachLop", lopService.getAllLop());
            model.addAttribute("danhSachMonHoc", monHocService.getAllMonHoc());
            return "sinhVien/edit";
        } else {
            return "redirect:/sinhVien";
        }
    }

    @PostMapping("/edit")
    public String updateSinhVien(@ModelAttribute("sinhVien") SinhVien sinhVien) {
        sinhVienService.updateSinhVien(sinhVien);
        return "redirect:/sinhVien";
    }

    @GetMapping("/delete/{id}")
    public String deleteSinhVien(@PathVariable String id) {
        sinhVienService.deleteSinhVien(id);
        return "redirect:/sinhVien";
    }
}
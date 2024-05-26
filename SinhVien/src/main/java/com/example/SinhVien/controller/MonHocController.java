package com.example.SinhVien.controller;


import com.example.SinhVien.model.MonHoc;
import com.example.SinhVien.services.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/monHoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    @GetMapping
    public String showAllMonHoc(Model model){
        List<MonHoc> dsMonHoc = monHocService.getAllMonHoc();
        model.addAttribute("dsMonHoc", dsMonHoc);
        return "monHoc/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("monHoc", new MonHoc());
        return "monHoc/add";
    }

    @PostMapping("/add")
    public String addMonHoc(@ModelAttribute("monHoc") MonHoc monHoc){
        monHocService.addMonHoc(monHoc);
        return "redirect:/monHoc";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        MonHoc monHoc = monHocService.getMonHocById(id);
        if (monHoc != null) {
            model.addAttribute("monHoc", monHoc);
            return "monHoc/edit";
        } else {
            return "redirect:/monHoc";
        }
    }

    @PostMapping("/edit")
    public String updateMonHoc(@ModelAttribute("monHoc") MonHoc monHoc) {
        monHocService.updateMonHoc(monHoc);
        return "redirect:/monHoc";
    }

    @GetMapping("/delete/{id}")
    public String deleteMonHoc(@PathVariable String id) {
        monHocService.deleteMonHoc(id);
        return "redirect:/monHoc";
    }
}

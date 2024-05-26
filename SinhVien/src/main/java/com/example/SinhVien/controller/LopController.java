package com.example.SinhVien.controller;

import com.example.SinhVien.model.Lop;
import com.example.SinhVien.services.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lop")
public class LopController {
    @Autowired
    private LopService lopService;

    @GetMapping
    public String showAllLop(Model model){
        List<Lop> dsLop = lopService.getAllLop();
        model.addAttribute("dsLop", dsLop);
        return "lop/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("lop", new Lop());
        return "lop/add";
    }

    @PostMapping("/add")
    public String addLop(@ModelAttribute("lop") Lop lop){
        lopService.addLop(lop);
        return "redirect:/lop";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Lop lop = lopService.getLopById(id);
        if (lop != null) {
            model.addAttribute("lop", lop);
            return "lop/edit";
        } else {
            return "redirect:/lop";
        }
    }

    @PostMapping("/edit")
    public String updateLop(@ModelAttribute("lop") Lop lop) {
        lopService.updateLop(lop);
        return "redirect:/lop";
    }

    @GetMapping("/delete/{id}")
    public String deleteLop(@PathVariable Long id) {
        lopService.deleteLop(id);
        return "redirect:/lop";
    }
}

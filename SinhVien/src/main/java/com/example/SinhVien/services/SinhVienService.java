package com.example.SinhVien.services;

import com.example.SinhVien.model.SinhVien;
import com.example.SinhVien.repository.ISinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienService {
    @Autowired
    private ISinhVienRepository sinhVienRepository;
    public List<SinhVien> getAllSinhVien(){
        return sinhVienRepository.findAll();
    }
    public SinhVien getSinhVienById(String id){
        return sinhVienRepository.findById(id).orElse(null);
    }
    public void addSinhVien(SinhVien sinhVien){
        sinhVienRepository.save(sinhVien);
    }
    public void deleteSinhVien(String id){
        sinhVienRepository.deleteById(id);
    }
    public void updateSinhVien(SinhVien sinhVien){
        sinhVienRepository.save(sinhVien);
    }

}

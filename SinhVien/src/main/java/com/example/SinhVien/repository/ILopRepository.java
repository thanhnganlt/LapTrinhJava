package com.example.SinhVien.repository;

import com.example.SinhVien.model.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILopRepository extends JpaRepository<Lop, Long> {
}

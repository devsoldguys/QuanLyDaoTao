package com.example.QuanLyDaoTao.repository;

import com.example.QuanLyDaoTao.entity.HocPhi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocPhiRepository extends JpaRepository<HocPhi, Integer> {
    List<HocPhi> findBySinhVien_MaSV(String maSV);
}
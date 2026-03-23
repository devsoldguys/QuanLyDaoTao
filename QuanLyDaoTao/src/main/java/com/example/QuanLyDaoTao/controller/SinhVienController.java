package com.example.QuanLyDaoTao.controller;

import com.example.QuanLyDaoTao.entity.SinhVien;
import com.example.QuanLyDaoTao.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sinhvien")
@CrossOrigin("*")
public class SinhVienController {

    @Autowired
    private SinhVienRepository sinhVienRepository;


    @GetMapping("/{maSV}")
    public SinhVien getThongTinSinhVien(@PathVariable String maSV) {
        return sinhVienRepository.findById(maSV).orElse(null);
    }

    @PostMapping("/login")
    public String login(@RequestBody com.example.QuanLyDaoTao.dto.LoginRequest request) {

        SinhVien sv = sinhVienRepository.findByMaSVAndSoDienThoai(request.getUsername(), request.getPassword());

        if (sv != null) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }
}
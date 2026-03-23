package com.example.QuanLyDaoTao.controller;

import com.example.QuanLyDaoTao.dto.DangKyRequest;
import com.example.QuanLyDaoTao.entity.DangKy;
import com.example.QuanLyDaoTao.entity.LopHocPhan;
import com.example.QuanLyDaoTao.entity.SinhVien;
import com.example.QuanLyDaoTao.repository.DangKyRepository;
import com.example.QuanLyDaoTao.repository.LopHocPhanRepository;
import com.example.QuanLyDaoTao.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dang-ky")
@CrossOrigin("*")
public class DangKyController {

    @Autowired
    private DangKyRepository dangKyRepository;

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;

    @PostMapping
    public String dangKyMonHoc(@RequestBody DangKyRequest request) {
        SinhVien sv = sinhVienRepository.findById(request.getMaSV()).orElse(null);
        LopHocPhan lhp = lopHocPhanRepository.findById(request.getIdLop()).orElse(null);

        if (sv == null || lhp == null) {
            return "FAIL";
        }

        DangKy dangKy = new DangKy();
        dangKy.setSinhVien(sv);
        dangKy.setLopHocPhan(lhp);

        dangKyRepository.save(dangKy);

        return "SUCCESS";
    }
}
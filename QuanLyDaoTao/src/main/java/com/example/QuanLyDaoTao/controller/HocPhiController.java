package com.example.QuanLyDaoTao.controller;

import com.example.QuanLyDaoTao.entity.HocPhi;
import com.example.QuanLyDaoTao.repository.HocPhiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoc-phi")
@CrossOrigin("*")
public class HocPhiController {

    @Autowired
    private HocPhiRepository hocPhiRepository;

    @GetMapping("/{maSV}")
    public HocPhi getHocPhi(@PathVariable String maSV) {
        List<HocPhi> listHocPhi = hocPhiRepository.findBySinhVien_MaSV(maSV);
        if (listHocPhi != null && !listHocPhi.isEmpty()) {
            return listHocPhi.get(0);
        }
        return null;
    }
}
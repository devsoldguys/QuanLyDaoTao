package com.example.QuanLyDaoTao.controller;

import com.example.QuanLyDaoTao.entity.KetQuaHocTap;
import com.example.QuanLyDaoTao.repository.KetQuaHocTapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ketqua")
@CrossOrigin("*")
public class KetQuaController {

    @Autowired
    private KetQuaHocTapRepository ketQuaHocTapRepository;

    @GetMapping("/{maSV}")
    public List<KetQuaHocTap> getKetQuaHocTap(@PathVariable String maSV) {
        return ketQuaHocTapRepository.findBySinhVien_MaSV(maSV);
    }
}
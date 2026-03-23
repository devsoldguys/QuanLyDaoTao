package com.example.QuanLyDaoTao.controller;

import com.example.QuanLyDaoTao.entity.DangKy;
import com.example.QuanLyDaoTao.entity.HocPhi;
import com.example.QuanLyDaoTao.entity.KetQuaHocTap;
import com.example.QuanLyDaoTao.repository.DangKyRepository;
import com.example.QuanLyDaoTao.repository.HocPhiRepository;
import com.example.QuanLyDaoTao.repository.KetQuaHocTapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private DangKyRepository dangKyRepository;

    @Autowired
    private HocPhiRepository hocPhiRepository;

    @Autowired
    private KetQuaHocTapRepository ketQuaHocTapRepository;

    @GetMapping("/dangky/{maSV}")
    public List<DangKy> getDangKy(@PathVariable String maSV) {
        return dangKyRepository.findBySinhVien_MaSV(maSV);
    }

    @GetMapping("/hocphi/{maSV}")
    public Map<String, Object> getHocPhi(@PathVariable String maSV) {
        List<DangKy> danhSachDangKy = dangKyRepository.findBySinhVien_MaSV(maSV);
        int tongSoTinChi = 0;
        
        for (DangKy dk : danhSachDangKy) {
            if (dk.getLopHocPhan() != null && dk.getLopHocPhan().getMonHoc() != null && dk.getLopHocPhan().getMonHoc().getSoTinChi() != null) {
                tongSoTinChi += dk.getLopHocPhan().getMonHoc().getSoTinChi();
            }
        }
        
        long hocPhiTinhToan = (long) tongSoTinChi * 1600000;
        
        Map<String, Object> response = new HashMap<>();
        response.put("hocKy", "Học kỳ hiện tại");
        response.put("tongTinChi", tongSoTinChi);
        response.put("soTienPhaiNop", hocPhiTinhToan);
        
        return response;
    }

    @GetMapping("/ketqua/{maSV}")
    public List<KetQuaHocTap> getKetQuaHocTap(@PathVariable String maSV) {
        return ketQuaHocTapRepository.findBySinhVien_MaSV(maSV);
    }
}
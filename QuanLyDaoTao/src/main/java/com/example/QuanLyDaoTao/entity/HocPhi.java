package com.example.QuanLyDaoTao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hoc_phi")
public class HocPhi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hp")
    private Integer idHp;

    @ManyToOne
    @JoinColumn(name = "ma_sv")
    private SinhVien sinhVien;

    @Column(name = "hoc_ky")
    private String hocKy;

    @Column(name = "so_tien_phai_nop")
    private Long soTienPhaiNop;

    public Integer getIdHp() {
        return idHp;
    }

    public void setIdHp(Integer idHp) {
        this.idHp = idHp;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public Long getSoTienPhaiNop() {
        return soTienPhaiNop;
    }

    public void setSoTienPhaiNop(Long soTienPhaiNop) {
        this.soTienPhaiNop = soTienPhaiNop;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author BINH
 */
public class SuaInfo {
    private String maSua;
    private String tenSua;
    private String maHangSua;
    private String maLoaiSua;
    private int trongLuong;
    private int donGia;
    private String tpDinhDuong;
    private String loiIch;
    private String hinh;
    
    public SuaInfo(){}
    
    public SuaInfo(String maSua, String tenSua, String maHangSua, String maLoaiSua, int trongLuong, int donGia, String tpDinhDuong, String loiIch, String hinh) {
        this.maSua = maSua;
        this.tenSua = tenSua;
        this.maHangSua = maHangSua;
        this.maLoaiSua = maLoaiSua;
        this.trongLuong = trongLuong;
        this.donGia = donGia;
        this.tpDinhDuong = tpDinhDuong;
        this.loiIch = loiIch;
        this.hinh = hinh;
    }

    public String getMaSua() {
        return maSua;
    }

    public void setMaSua(String maSua) {
        this.maSua = maSua;
    }

    public String getTenSua() {
        return tenSua;
    }

    public void setTenSua(String tenSua) {
        this.tenSua = tenSua;
    }

    public String getMaHangSua() {
        return maHangSua;
    }

    public void setMaHangSua(String maHangSua) {
        this.maHangSua = maHangSua;
    }

    public String getMaLoaiSua() {
        return maLoaiSua;
    }

    public void setMaLoaiSua(String maLoaiSua) {
        this.maLoaiSua = maLoaiSua;
    }

    public int getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(int trongLuong) {
        this.trongLuong = trongLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getTpDinhDuong() {
        return tpDinhDuong;
    }

    public void setTpDinhDuong(String tpDinhDuong) {
        this.tpDinhDuong = tpDinhDuong;
    }

    public String getLoiIch() {
        return loiIch;
    }

    public void setLoiIch(String loiIch) {
        this.loiIch = loiIch;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    
            
}

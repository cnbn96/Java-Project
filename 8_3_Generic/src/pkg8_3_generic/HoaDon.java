/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8_3_generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hv
 */
public class HoaDon {
    public class SanPham{
        private String tenSp;
        private int soLuong;
        private int donGia;

        public String getTenSp() {
            return tenSp;
        }

        public void setTenSp(String tenSp) {
            this.tenSp = tenSp;
        }

        public int getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(int soLuong) {
            this.soLuong = soLuong;
        }

        public int getDonGia() {
            return donGia;
        }

        public void setDonGia(int donGia) {
            this.donGia = donGia;
        }
        public SanPham() {
            this.tenSp = "";
            this.soLuong = 0;
            this.donGia = 0;
        }

        public SanPham(String tenSp, int soLuong, int donGia) {
            this.tenSp = tenSp;
            this.soLuong = soLuong;
            this.donGia = donGia;
        }
        public long ThanhTien(){
            return soLuong * donGia;
        }

        @Override
        public String toString() {
            return "tenSp: " + tenSp + ", soLuong: " + soLuong + ", donGia: " + donGia + '}';
        }
        
    }
    private int soHD;
    private Date ngayHD;
    private String khachHang;
    private List<SanPham> lstSanPham;

    public int getSoHD() {
        return soHD;
    }

    public void setSoHD(int soHD) {
        this.soHD = soHD;
    }

    public Date getNgayHD() {
        return ngayHD;
    }

    public void setNgayHD(Date ngayHD) {
        this.ngayHD = ngayHD;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public List<SanPham> getLstSanPham() {
        return lstSanPham;
    }

    public void setLstSanPham(List<SanPham> lstSanPham) {
        this.lstSanPham = lstSanPham;
    }
    public HoaDon() {
        this.soHD = 0;
        this.ngayHD = null;
        this.khachHang = "";
        this.lstSanPham = new ArrayList<SanPham>();
    }

    public HoaDon(int soHD, Date ngayHD, String khachHang, List<SanPham> lstSanPham) {
        this.soHD = soHD;
        this.ngayHD = ngayHD;
        this.khachHang = khachHang;
         this.lstSanPham = new ArrayList<SanPham>();
    }
    public HoaDon(int soHD, Date ngayHD, String khachHang) {
        this.soHD = soHD;
        this.ngayHD = ngayHD;
        this.khachHang = khachHang;
         this.lstSanPham = new ArrayList<SanPham>();
    }
    public void ThemSP(SanPham sp){
        lstSanPham.add(sp);
    }
    public void ThemSP(String tenSP, int soLuong, int donGia){
        lstSanPham.add(new SanPham(tenSP,soLuong,donGia));
    }
    
    public String xuatDS(){
        Object[][] obj = new Object[lstSanPham.size()][4];
        int i=0;
        for(SanPham sp:lstSanPham){
            obj[i][0] = sp.getTenSp();
            obj[i][1] = sp.getSoLuong();
            obj[i][2] = sp.getDonGia();
            obj[i][3] = sp.ThanhTien();
            i++;
        }
        System.out.println(obj[0][0]);
        return "";
    }
}

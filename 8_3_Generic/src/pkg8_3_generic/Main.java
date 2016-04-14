/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8_3_generic;

import java.text.SimpleDateFormat;

/**
 *
 * @author hv
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        HoaDon hd = new HoaDon(12, df.parse("08/03/2016"), "NamBinh");
        HoaDon.SanPham sp = hd.new SanPham("PC", 1, 4000000);
        HoaDon.SanPham sp1 = hd.new SanPham("POWERACBEL", 1, 3000000);
        hd.ThemSP(sp);
        hd.ThemSP(sp1);
        hd.xuatDS();
        
    }
    
}

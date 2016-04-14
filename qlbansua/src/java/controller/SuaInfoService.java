/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BINH
 */
public class SuaInfoService {
    public static List<SuaInfo> SuaInfo() throws ClassNotFoundException, SQLException{
        String strCon = "jdbc:mysql://localhost:3306/ql_bansua";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(strCon,"root","");
        Statement stm = (Statement)con.createStatement();
        ResultSet rs = stm.executeQuery("select * from sua");
        List<SuaInfo> dsls = new ArrayList<>();
        while(rs.next()){
            SuaInfo si = new SuaInfo(rs.getString("ma_sua"),rs.getString("ten_sua"),rs.getString("ma_hang_sua"),rs.getString("ma_loai_sua"),
            Integer.parseInt(rs.getString("trong_luong")),Integer.parseInt(rs.getString("don_gia")),rs.getString("tp_dinh_duong"),rs.getString("loi_ich"),rs.getString("hinh"));
            dsls.add(si);
        }
        con.close();
        return dsls;
    }
}

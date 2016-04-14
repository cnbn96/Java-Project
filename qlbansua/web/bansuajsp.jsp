
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="controller.SuaInfo"%>
<%@page import="controller.SuaInfoService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Danh Sách Loại Sữa</h1>
        <% List<SuaInfo> dsls = SuaInfoService.SuaInfo(); %>
        <table border="1">
            
            <thead>
                <tr>
                    <td>Mã sữa</td>
                    <td>Tên sữa</td>
                    <td>Mã hãng sữa</td>
                    <td>Mã loại sữa</td>
                    <td>Trọng lượng</td>
                    <td>Đơn giá</td>
                    <td>TP dinh dưỡng</td>
                    <td>Lợi ích</td>
                    <td>Hình</td>
                </tr>
            </thead>
            <tbody>
            <% for(SuaInfo si:dsls){ %>
                <tr>
                    <td><%=si.getMaSua() %></td>
                    <td><%=si.getTenSua() %></td>
                    <td><%=si.getMaHangSua() %></td>
                    <td><%=si.getMaLoaiSua() %></td>
                    <td><%=si.getTrongLuong() %></td>
                    <td><%=si.getDonGia() %></td>
                    <td><%=si.getTpDinhDuong() %></td>
                    <td><%=si.getLoiIch() %></td>
                    <td><image src="images/<%=si.getHinh() %>" width="100" height="100"/></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </body>
</html>

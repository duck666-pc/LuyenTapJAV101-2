package repository;

import controller.DbConnector;
import model.XeMay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class XeMayRepository {

    public int update(XeMay model) throws Exception {
        String sql = "UPDATE xe_may SET ma = ?, ten = ?, mota = ?, gia_nhap = ?, gia_ban = ?, so_luong = ?, website = ?, id_lxm = ?, trang_thai = ? WHERE id = ?";

        try (Connection conn = DbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, model.getMa());
            pstmt.setString(2, model.getTen());
            pstmt.setString(3, model.getMoTa());
            pstmt.setFloat(4, model.getGiaNhap());
            pstmt.setFloat(5, model.getGiaBan());
            pstmt.setInt(6, model.getSoLuong());
            pstmt.setString(7, model.getWebsite());
            pstmt.setInt(8, model.getId_lxm());
            pstmt.setInt(9, model.getTrangThai());
            pstmt.setInt(10, model.getId());

            return pstmt.executeUpdate();
        }
    }



    public static int deleteById(Integer id) throws Exception {
        String sql = "DELETE FROM xe_may WHERE id = ?";

        try (Connection conn = DbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }


    public XeMay getById(Integer id) throws Exception {
        String sql = "SELECT * FROM xe_may WHERE id = ?";

        try (Connection conn = DbConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String moTa = rs.getString("mota");
                Float giaNhap = rs.getFloat("gia_nhap");
                Float giaBan = rs.getFloat("gia_ban");
                Integer soLuong = rs.getInt("so_luong");
                String website = rs.getString("website");
                Integer id_lxm = rs.getInt("id_lxm");
                Integer trangThai = rs.getInt("trang_thai");

                return new XeMay(id, ma, ten, moTa, giaNhap, giaBan, soLuong, website, id_lxm, trangThai);
            }
        }
        return null;
    }


    public List<XeMay> getAll() throws Exception {
        List<XeMay> list = new ArrayList<>();
        String sql = "SELECT * FROM xe_may";

        try (Connection conn = DbConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String moTa = rs.getString("mota");
                Float giaNhap = rs.getFloat("gia_nhap");
                Float giaBan = rs.getFloat("gia_ban");
                Integer soLuong = rs.getInt("so_luong");
                String website = rs.getString("website");
                Integer id_lxm = rs.getInt("id_lxm");
                Integer trangThai = rs.getInt("trang_thai");

                XeMay xeMay = new XeMay(id, ma, ten, moTa, giaNhap, giaBan, soLuong, website, id_lxm, trangThai);
                list.add(xeMay);
            }
        }
        return list;
    }


}

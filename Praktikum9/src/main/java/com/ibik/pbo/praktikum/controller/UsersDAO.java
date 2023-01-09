package com.ibik.pbo.praktikum.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.ibik.pbo.praktikum.model.Users;
import com.ibik.pbo.praktikum.view.FormRegister;

public class UsersDAO {

    private String query_mysql_insert = "INSERT INTO users (fullname, email, password, phone, gender, citizenship)"
                                      + "VALUES (?, ?, ?, ?, ?, ?)";
    private String query_mysql_check_user = "SELECT email, password FROM users WHERE email = ? AND password = ?";

    public void InsertDataUsers(Users u) throws Exception {
        Connection conn = new ConnectionDB().connect();
        PreparedStatement psInsertData = conn.prepareStatement(query_mysql_insert);

        psInsertData.setString(1, u.getFullname());
        psInsertData.setString(2, u.getEmail());
        psInsertData.setString(3, u.getPassword());
        psInsertData.setString(4, u.getPhone());
        psInsertData.setString(5, u.getGender());
        psInsertData.setString(6, u.getCitizenship());

        psInsertData.executeUpdate();
        conn.close();
    }

    public void CheckDataUsers(String email, String password) throws Exception {
        Connection conn = new ConnectionDB().connect();
        PreparedStatement psSelectData = conn.prepareStatement(query_mysql_check_user);

        psSelectData.setString(1, email);
        psSelectData.setString(2, password);

        ResultSet rs = psSelectData.executeQuery();

        if(rs.next()) {
            String message = "Selamat datang Asisten Dosen PBO";
            JOptionPane.showMessageDialog(null, message, "Login Sukses!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String message = "Email dan password tidak terdaftar!\nSilahkan registrasi terlebih dahulu";
            JOptionPane.showMessageDialog(null, message, "Login gagal", JOptionPane.ERROR_MESSAGE);
            new FormRegister().setVisible(true);
        }

        conn.close();
    }

}

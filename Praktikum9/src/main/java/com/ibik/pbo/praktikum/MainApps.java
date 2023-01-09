package com.ibik.pbo.praktikum;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.ibik.pbo.praktikum.controller.ConnectionDB;
import com.ibik.pbo.praktikum.view.FormLogin;

public class MainApps {

    public static void main(String[] args) {
        ConnectionDB connDB = new ConnectionDB();
        try {
            connDB.connect();
            JOptionPane.showMessageDialog(null, "Koneksi berhasil");
            new FormLogin().setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
}
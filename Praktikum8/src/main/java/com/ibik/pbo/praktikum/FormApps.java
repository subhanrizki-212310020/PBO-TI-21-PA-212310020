package com.ibik.pbo.praktikum;

import javax.swing.JOptionPane;

import com.ibik.pbo.praktikum.form.FormLogin;

public class FormApps {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Selamat Datang!");
        new FormLogin().setVisible(true);
    }
    
}

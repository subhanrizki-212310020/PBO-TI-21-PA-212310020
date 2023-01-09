package com.ibik.pbo.praktikum.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ibik.pbo.praktikum.controller.UsersDAO;

public class FormLogin extends JFrame implements ActionListener {
    
    private JTextField txt_email;
    private JPasswordField pass_password;
    private JButton btn_register, btn_login;
    private JCheckBox remember;
    
    public FormLogin() {
        setTitle("Login");
        setSize(375, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GenerateFormUI(this);
        setResizable(false);
    }

    private void GenerateFormUI(FormLogin frame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        frame.add(formPanel, BorderLayout.CENTER);

        JLabel lbl_email = new JLabel("Email");
        lbl_email.setBounds(40, 30, 100, 20);
        formPanel.add(lbl_email);

        txt_email = new JTextField();
        txt_email.setBounds(135, 30 , 180, 23);
        formPanel.add(txt_email);

        JLabel lbl_password = new JLabel("Password");
        lbl_password.setBounds(40, 80, 100, 20);
        formPanel.add(lbl_password);

        pass_password = new JPasswordField();
        pass_password.setBounds(135, 80 , 180, 23);
        formPanel.add(pass_password);

        remember = new JCheckBox("Remeber Password?");
        remember.setBounds(130, 110, 250, 30);
        formPanel.add(remember);

        btn_register = new JButton("Register");
        btn_register.setBounds(130, 155, 85, 40);
        formPanel.add(btn_register);

        btn_login = new JButton("Login");
        btn_login.setBounds(225, 155, 85, 40);
        formPanel.add(btn_login);

        JPanel copyrightPanel = new JPanel();
        copyrightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(copyrightPanel, BorderLayout.SOUTH);

        JLabel copyright = new JLabel("Copyright IBIK @ 2023");
        copyright.setFont(new Font("Arial", Font.BOLD, 12));
        copyrightPanel.add(copyright);

        btn_register.addActionListener(this); btn_login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_register) {
            new FormRegister().setVisible(true);
        } else if(e.getSource() == btn_login) {
            if(IsTextEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi data dengan benar!", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
            } else if(!IsTextEmpty() && remember.isSelected()){
                CheckData();
                new AppNilaiPBO().setVisible(true);
            } else if(!IsTextEmpty() || !remember.isSelected()){
                CheckData();
                new AppNilaiPBO().setVisible(true);
                ClearForm();
            }
        }
    }

    private void ClearForm() {
        txt_email.setText("");
        pass_password.setText("");
    }

    private Boolean IsTextEmpty() {
        return (
            txt_email.getText().isEmpty() || new String(pass_password.getPassword()).isEmpty()
        );
    }

    private void CheckData() {
        UsersDAO user_dao = new UsersDAO();

        String email = txt_email.getText();
        String password = String.valueOf(pass_password.getPassword());

        try {
            user_dao.CheckDataUsers(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
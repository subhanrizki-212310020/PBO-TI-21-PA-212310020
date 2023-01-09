package com.ibik.pbo.praktikum.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ibik.pbo.praktikum.controller.UsersDAO;
import com.ibik.pbo.praktikum.model.Users;

public class FormRegister extends JFrame {

    public JTextField txt_fullname, txt_email, txt_phone;
    public JPasswordField pass_password, pass_re_password;
    private ButtonGroup btn_gender_group;
    private JComboBox<String> list_citizenship;
    private JButton btn_submit;
    private JRadioButton gender_female, gender_male;

    private final String[] citizenship_data = {"Indonesia", "India", "Pakistan", "England", "Russia",
                                               "Japan", "Brazil", "USA", "Denmark", "Germany"};

    public FormRegister() {
        setTitle("Register");
        setVisible(true);
        setSize(415, 550);
        setLocationRelativeTo(null);
        GenerateFormRegistUI(this);
        setResizable(false);
    }

    private void GenerateFormRegistUI(FormRegister frame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        JLabel lbl_fullname = new JLabel("Fullname");
        lbl_fullname.setFont(new Font("Arial",Font.PLAIN, 14));
        lbl_fullname.setBounds(40, 30, 100, 20);
        formPanel.add(lbl_fullname);

        txt_fullname = new JTextField();
        txt_fullname.setBounds(185, 30, 170, 25);
        formPanel.add(txt_fullname);

        JLabel lbl_email = new JLabel("Email");
        lbl_email.setFont(new Font("Arial", Font.PLAIN, 14));
        lbl_email.setBounds(40, 80, 100, 20);
        formPanel.add(lbl_email);

        txt_email = new JTextField();
        txt_email.setBounds(185, 80, 170, 25);
        formPanel.add(txt_email);
        
        JLabel lbl_password = new JLabel("Password");
        lbl_password.setFont(new Font("Arial", Font.PLAIN, 14));
        lbl_password.setBounds(40, 130, 100, 20);
        formPanel.add(lbl_password);

        pass_password = new JPasswordField();
        pass_password.setBounds(185, 130, 170, 25);
        formPanel.add(pass_password);

        JLabel lbl_re_password = new JLabel("Re-Enter Password");
        lbl_re_password.setFont(new Font("Arial", Font.PLAIN, 14));
        lbl_re_password.setBounds(40, 180, 150, 20);
        formPanel.add(lbl_re_password);

        pass_re_password = new JPasswordField();
        pass_re_password.setBounds(185, 180, 170, 25);
        formPanel.add(pass_re_password);

        JLabel lbl_phone = new JLabel("Phone");
        lbl_phone.setFont(new Font("Arial", Font.PLAIN, 14));
        lbl_phone.setBounds(40, 230, 150, 20);
        formPanel.add(lbl_phone);

        txt_phone = new JTextField();
        txt_phone.setBounds(185, 230, 170, 25);
        formPanel.add(txt_phone);

        JLabel lbl_gender = new JLabel("Gender");
        lbl_gender.setFont(new Font("Arial", Font.PLAIN, 14));
        lbl_gender.setBounds(40, 280, 150, 20);
        formPanel.add(lbl_gender);

        btn_gender_group = new ButtonGroup();
        gender_male = new JRadioButton("Male");
        gender_male.setBounds(180, 275, 55, 30);
        gender_female = new JRadioButton("Female");
        gender_female.setBounds(275, 275, 85, 30);

        btn_gender_group.add(gender_female); btn_gender_group.add(gender_male);
        formPanel.add(gender_male); formPanel.add(gender_female);

        JLabel lbl_citizenship = new JLabel("Citizenship");
        lbl_citizenship.setFont(new Font("Arial", Font.PLAIN, 14));
        lbl_citizenship.setBounds(40, 330, 100, 20);
        formPanel.add(lbl_citizenship);

        list_citizenship = new JComboBox<String>(citizenship_data);
        list_citizenship.setBounds(180, 330, 180, 25);
        formPanel.add(list_citizenship);

        btn_submit = new JButton("Submit");
        btn_submit.setBounds(180, 380, 180, 50);
        formPanel.add(btn_submit);

        JPanel copyrightPanel = new JPanel();
        copyrightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(copyrightPanel, BorderLayout.SOUTH);

        JLabel copyright = new JLabel("Copyright IBIK @ 2023");
        copyright.setFont(new Font("Arial", Font.BOLD, 12));
        copyrightPanel.add(copyright);

        btn_submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(IsDataEmpty()) {
                    JOptionPane.showMessageDialog(null, "Isi data dengan benar", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
                } else if(!IsPasswordEquals()) {
                    JOptionPane.showMessageDialog(null, "Password tidak sama!", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "Sukses!", JOptionPane.INFORMATION_MESSAGE);
                    InsertData();
                    new FormLogin().setVisible(true);
                    dispose();
                }
            }
            
        });
    }

    private Boolean IsDataEmpty() {
        String fullname = txt_fullname.getText();
        String email = txt_email.getText();
        String password = String.valueOf(pass_password.getPassword());
        String re_password = String.valueOf(pass_re_password.getPassword());
        String phone = txt_phone.getText();

        return (
            fullname.isEmpty() || email.isEmpty() || (password.isEmpty() && re_password.isEmpty()) || phone.isEmpty() ||
            btn_gender_group.isSelected(null)
        );
    }

    private Boolean IsPasswordEquals() {
        String password = String.valueOf(pass_password.getPassword());
        String re_password = String.valueOf(pass_re_password.getPassword());

        return (
            password.equals(re_password)
        );
    }

    private void InsertData() {
        Users users = new Users();

        String fullname = txt_fullname.getText();
        String email = txt_email.getText();
        String password = String.valueOf(pass_password.getPassword());
        String phone = txt_phone.getText();
        String gender = "";

        if(gender_male.isSelected()) {
            gender = gender_male.getText();
        } else if (gender_female.isSelected()) {
            gender = gender_female.getText();
        }

        String citizenship = list_citizenship.getSelectedItem().toString();

        users.setFullname(fullname);
        users.setEmail(email);
        users.setPassword(password);
        users.setPhone(phone);
        users.setGender(gender);
        users.setCitizenship(citizenship);

        UsersDAO users_dao = new UsersDAO();
        try {
            users_dao.InsertDataUsers(users);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "PERINGATAN", JOptionPane.ERROR_MESSAGE);
        }
    }

}
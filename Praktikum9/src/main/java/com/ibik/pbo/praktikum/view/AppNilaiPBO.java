package com.ibik.pbo.praktikum.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import com.ibik.pbo.praktikum.controller.MahasiswaDAO;
import com.ibik.pbo.praktikum.model.Mahasiswa;

public class AppNilaiPBO extends JFrame implements ActionListener {

    private JButton btn_save, btn_delete, btn_clear;
    private JTextField txt_nama, txt_npm;
    private ButtonGroup group_nilai;
    private JRadioButton nilai_a, nilai_b, nilai_c, nilai_d, nilai_e, nilai_f;
    private JPanel mainPanel;
    private JTable mhs_table;

    private String npm_table_data;
    private String nama_lengkap_table_data;
    private String nilai_table_data;
    private int selected_row;

    AppNilaiPBO() {
        setTitle("Aplikasi Penilaian PBO");
        setSize(800, 512);
        setLocationRelativeTo(null);
        GenerateUI(this);
        setResizable(false);
    }

    private void GenerateUI(AppNilaiPBO frame) {
        GenerateMenuBar(this);
        GenerateForm(this);
        GenerateTable(this);
    }

    private void GenerateMenuBar(AppNilaiPBO frameMenu) {
        JMenuBar menuBar = new JMenuBar();

        String[] list_menu = {"File", "Edit", "Help"};
        String[] file_menu = {"Open Student Data", "Exit"};

        JMenu[] menus = new JMenu[list_menu.length];
        for(int i = 0; i < list_menu.length; i++) {
            menus[i] = new JMenu();
            menus[i].setText(list_menu[i]);
            menuBar.add(menus[i]);
        }

        JMenuItem[] sub_file_menu = new JMenuItem[file_menu.length];
        for(int i = 0; i < file_menu.length; i++) {
            sub_file_menu[i] = new JMenuItem();
            sub_file_menu[i].setText(file_menu[i]);
            menus[0].add(sub_file_menu[i]);
        }

        frameMenu.setJMenuBar(menuBar);
    }

    private void GenerateForm(AppNilaiPBO frameForm) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frameForm.setContentPane(mainPanel);

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("FORM PENILAIAN MATA KULIAH PBO");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setSize(300, 30);

        titlePanel.add(title, new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        mainPanel.add(formPanel, BorderLayout.WEST);

        JLabel title_form = new JLabel("Form Mahasiswa");
        title_form.setFont(new Font("Arial", Font.BOLD, 20));
        title_form.setBounds(40, 40, 300, 20);
        
        formPanel.add(title_form, BorderLayout.WEST);

        JLabel label_npm = new JLabel("NPM");
        label_npm.setBounds(40, 80, 30, 10);
        formPanel.add(label_npm);

        txt_npm = new JTextField();
        txt_npm.setBounds(40, 100, 250, 35);
        formPanel.add(txt_npm);

        JLabel label_nama = new JLabel("NAMA");
        label_nama.setBounds(40, 160, 35, 10);
        formPanel.add(label_nama);

        txt_nama = new JTextField();
        txt_nama.setBounds(40, 180, 250, 35);
        formPanel.add(txt_nama);

        JLabel label_nilai = new JLabel("Nilai");
        label_nilai.setBounds(40, 240, 35, 10);
        formPanel.add(label_nilai);

        group_nilai = new ButtonGroup();
        nilai_a = new JRadioButton("A"); nilai_b = new JRadioButton("B");
        nilai_c = new JRadioButton("C"); nilai_d = new JRadioButton("D");
        nilai_e = new JRadioButton("E"); nilai_f = new JRadioButton("F");
        
        nilai_a.setBounds(40, 260, 35, 20); nilai_b.setBounds(80, 260, 35, 20);
        nilai_c.setBounds(120, 260, 35, 20); nilai_d.setBounds(180, 260, 35, 20);
        nilai_e.setBounds(220, 260, 35, 20); nilai_f.setBounds(260, 260, 35, 20);

        group_nilai.add(nilai_a); group_nilai.add(nilai_b);
        group_nilai.add(nilai_c); group_nilai.add(nilai_d);
        group_nilai.add(nilai_e); group_nilai.add(nilai_f);

        formPanel.add(nilai_a); formPanel.add(nilai_b);
        formPanel.add(nilai_c); formPanel.add(nilai_d);
        formPanel.add(nilai_e); formPanel.add(nilai_f);

        btn_save = new JButton("Save");
        btn_delete = new JButton("Delete");
        btn_clear = new JButton("Clear");

        btn_save.setBounds(40, 300, 85, 35);
        btn_delete.setBounds(130, 300, 85, 35);
        btn_clear.setBounds(220, 300, 85, 35);

        formPanel.add(btn_save);
        formPanel.add(btn_delete);
        formPanel.add(btn_clear);

        btn_clear.addActionListener(this);
        btn_delete.addActionListener(this);
        btn_save.addActionListener(this);

        frameForm.add(formPanel);
    }

    private void GenerateTable(AppNilaiPBO frameTable) {
        DefaultTableModel tbl_model = GetData();

        mhs_table = new JTable(tbl_model);
        mhs_table.setBounds(40, 40, 200, 200);

        mhs_table.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                GetSelectedData();
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                mhs_table.setModel(GetData());
            }

            @Override
            public void mouseExited(MouseEvent e) {}

            @Override
            public void mouseDragged(MouseEvent e) {}

            @Override
            public void mouseMoved(MouseEvent e) {}
            
        });
        
        JScrollPane scroll_table = new JScrollPane(mhs_table);
        frameTable.add(scroll_table, BorderLayout.EAST);
    }

    private DefaultTableModel GetData() {
        DefaultTableModel tbl_model = new DefaultTableModel();
        tbl_model.addColumn("NPM");
        tbl_model.addColumn("Nama Lengkap");
        tbl_model.addColumn("Nilai");

        MahasiswaDAO mahasiswa_dao = new MahasiswaDAO();
        try {
            List<Mahasiswa> mahasiswa = mahasiswa_dao.SearchAllData();
            for(int i = 0; i < mahasiswa.size(); i++) {
                String data[] = { mahasiswa.get(i).getNpm(), 
                                  mahasiswa.get(i).getNamaLengkap(),
                                  mahasiswa.get(i).getNilai() };
                tbl_model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "PERINGATAN", JOptionPane.ERROR_MESSAGE);
        }

        return tbl_model;
    }

    private void GetSelectedData() {
        DefaultTableModel mhs_table_model = (DefaultTableModel) mhs_table.getModel();

        selected_row = mhs_table.getSelectedRow();
        System.out.println("Anda mengklik baris ke - " + (selected_row + 1) + "\n");

        npm_table_data = mhs_table_model.getValueAt(selected_row, 0).toString();
        nama_lengkap_table_data = mhs_table_model.getValueAt(selected_row, 1).toString();
        nilai_table_data = mhs_table_model.getValueAt(selected_row, 2).toString();

        System.out.println("Data:");
        System.out.println("NPM: " + npm_table_data);
        System.out.println("Nama Lengkap: " + nama_lengkap_table_data);
        System.out.println("Nilai: " + nilai_table_data + "\n");

        txt_npm.setText(npm_table_data);
        txt_nama.setText(nama_lengkap_table_data);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_clear) {
            ClearForm();
        } else if(e.getSource() == btn_delete) {
            if(mhs_table.isCellSelected(selected_row, 0)) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                DeleteDataTable();
            } else {
                JOptionPane.showMessageDialog(null, "Silakan pilih data terlebih dahulu", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
            }
        } else if(e.getSource() == btn_save) {
            if(IsInputFormEmpty()) {
                JOptionPane.showMessageDialog(null, "Isi data dengan benar!");
            } else if((!IsInputFormEmpty()) && (!IsTableSelected())){
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                InputData();
                ClearForm();
            } else if((!IsInputFormEmpty()) && (IsTableSelected())){
                UpdateDataTable();
                JOptionPane.showMessageDialog(null, "Update data berhasil!");
                ClearForm();
            }
        }
    }

    private void ClearForm() {
        txt_nama.setText("");
        txt_npm.setText("");
        group_nilai.clearSelection();
    }

    private Boolean IsInputFormEmpty() {
        String npm = txt_npm.getText();
        String nama = txt_nama.getText();

        return (
            npm.isEmpty() || nama.isEmpty() || group_nilai.isSelected(null)
        );
    }

    private Boolean IsTableSelected() {
        return (
            mhs_table.isCellSelected(selected_row, 0) ||
            mhs_table.isCellSelected(selected_row, 1) ||
            mhs_table.isCellSelected(selected_row, 2)
        );
    }

    private void InputData() {
        Mahasiswa mahasiswa = new Mahasiswa();
        MahasiswaDAO mahasiswa_dao = new MahasiswaDAO();

        String npm = txt_npm.getText();
        String nama_lengkap = txt_nama.getText();
        String nilai = GetTextNilai("");

        mahasiswa.setNpm(npm);
        mahasiswa.setNamaLengkap(nama_lengkap);
        mahasiswa.setNilai(nilai);
        
        try {
            mahasiswa_dao.InputDataMahasiswa(mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DeleteDataTable() {
        MahasiswaDAO mahasiswa_dao = new MahasiswaDAO();

        try {
            mahasiswa_dao.DeleteData(npm_table_data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void UpdateDataTable() {
        Mahasiswa mahasiswa = new Mahasiswa();
        MahasiswaDAO mahasiswa_dao = new MahasiswaDAO();

        String npm = txt_npm.getText();
        String nama_lengkap = txt_nama.getText();
        String nilai = GetTextNilai("");

        mahasiswa.setNpm(npm);
        mahasiswa.setNamaLengkap(nama_lengkap);
        mahasiswa.setNilai(nilai);
        
        try {
            mahasiswa_dao.UpdateData(mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String GetTextNilai(String value) {
        if(nilai_a.isSelected()) {
            value = nilai_a.getText();
        } else if(nilai_b.isSelected()) {
            value = nilai_b.getText();
        } else if(nilai_c.isSelected()) {
            value = nilai_c.getText();
        }
        
        if(nilai_d.isSelected()) {
            value = nilai_d.getText();
        } else if(nilai_e.isSelected()) {
            value = nilai_e.getText();
        } else if(nilai_f.isSelected()) {
            value = nilai_f.getText();
        }

        return value;
    }
    
}
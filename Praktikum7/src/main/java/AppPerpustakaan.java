
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AppPerpustakaan extends JFrame {

    private JTextField txt_kode_buku, txt_nama_buku;
    private ButtonGroup group_membership;
    private JRadioButton btn_vip, btn_umum;
    private JButton btn_submit;

    AppPerpustakaan() {
        setTitle("Aplikasi Perpustakaan");
        setVisible(true);
        pack();
        setSize(330, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GenerateMenu(this);
        setResizable(false);
    }

    public static void main(String[] args) {
        new AppPerpustakaan();
    }

    private void GenerateMenu(AppPerpustakaan frame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Aplikasi Perpustakaan");
        titlePanel.add(title, new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        JLabel label_kode_buku = new JLabel("Kode Buku");
        label_kode_buku.setBounds(40, 40, 100, 15);
        formPanel.add(label_kode_buku);

        txt_kode_buku = new JTextField();
        txt_kode_buku.setBounds(120, 35, 150, 25);
        formPanel.add(txt_kode_buku);
        
        JLabel label_nama_buku = new JLabel("Nama Buku");
        label_nama_buku.setBounds(40, 80, 100, 15);
        formPanel.add(label_nama_buku);

        txt_nama_buku = new JTextField();
        txt_nama_buku.setBounds(120, 75, 150, 25);
        formPanel.add(txt_nama_buku);

        JLabel label_membership = new JLabel("Membership");
        label_membership.setBounds(40, 120, 100, 15);
        formPanel.add(label_membership);

        group_membership = new ButtonGroup();
        
        btn_vip = new JRadioButton("VIP");
        btn_umum = new JRadioButton("UMUM");
        btn_vip.setBounds(120, 120, 50, 15);
        btn_umum.setBounds(200, 120, 75, 15);

        group_membership.add(btn_vip); group_membership.add(btn_umum);

        formPanel.add(btn_vip); formPanel.add(btn_umum);

        btn_submit = new JButton("Submit");
        btn_submit.setBounds(120, 155, 115, 35);
        formPanel.add(btn_submit);

        frame.add(formPanel);

        Click(this);
    }
    
    private void Click(AppPerpustakaan val) {

        btn_submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_kode_buku.getText().isEmpty() || txt_nama_buku.getText().isEmpty() || group_membership.isSelected(null)) {
                    JOptionPane.showMessageDialog(null, "Isi data dengan benar!");
                } else {
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                }
            }
            
        });

        btn_submit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                btn_submit.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                btn_submit.setBackground(Color.CYAN);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });

        txt_kode_buku.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String[][] buku = { 
                        {"BK1", "PBO"},
                        {"BK2", "JAVA"},
                        {"BK3", "Lorem"}
                    }
                    ;
                    for(int i = 0; i < buku.length; i++) {
                        if(txt_kode_buku.getText().equals(buku[i][0])) {
                            txt_nama_buku.setText(buku[i][1]);
                        } 
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
            
        });
    }

}
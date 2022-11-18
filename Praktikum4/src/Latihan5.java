import javax.swing.JOptionPane;
public class Latihan5 {

	public static void main(String[] args) {
		
		String field[] = {"Nama Lengkap : ", "Alamat : ", "No Telp : "};
		
		//nama = JOptionPane.showInputDialog(null, "Masukan Nama Lengkap ","Data Array Ke-1", JOptionPane.QUESTION_MESSAGE);
		//alamat = JOptionPane.showInputDialog(null, "Masukan Alamat ","Data Array Ke-2", JOptionPane.QUESTION_MESSAGE);
		//no_hp = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Nomor Hp ","Data Array Ke-3", JOptionPane.QUESTION_MESSAGE));
		String data = "";
		String isi = "";
		for (int i = 0; i < field.length; i++) {
			field[i] = JOptionPane.showInputDialog(null, field[i], "Data Array ke-"+i, JOptionPane.QUESTION_MESSAGE);
			if(i==0) {
				data += "Nama "+field[i]+"\n";  
			}
			else if(i==1) {
				data += "Alamat "+field[i]+"\n";
			}
			else {
				data += "Nomor HP "+field[i];
			}
		}
		
		JOptionPane.showMessageDialog(null, data);
		
	}
}
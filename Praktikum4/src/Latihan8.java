import javax.swing.JOptionPane;
public class Latihan8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String kolom = "Nama Lengkap   Alamat   No Telp  ";
		String field[][] = {
				{"Nama Lengkap : ", "Alamat : ", "No Telp : "},
				{"Nama Lengkap : ", "Alamat : ", "No Telp : "},
				{"Nama Lengkap : ", "Alamat : ", "No Telp : "},
				{"Nama Lengkap : ", "Alamat : ", "No Telp : "}};
		
		//nama = JOptionPane.showInputDialog(null, "Masukan Nama Lengkap ","Data Array Ke-1", JOptionPane.QUESTION_MESSAGE);
		//alamat = JOptionPane.showInputDialog(null, "Masukan Alamat ","Data Array Ke-2", JOptionPane.QUESTION_MESSAGE);
		//no_hp = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Nomor Hp ","Data Array Ke-3", JOptionPane.QUESTION_MESSAGE));
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j< 3; j++)
			field[i][j] = JOptionPane.showInputDialog(null, field[i][j], "Array ke["+i+"]"+"["+j+"]", JOptionPane.QUESTION_MESSAGE);
		}
		String data="";
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j< 3; j++) {
			data += field[i][j]+" ";	
			}
		}
			
		
		JOptionPane.showMessageDialog(null,kolom +"\n"+data+"\n");
		
	}
}

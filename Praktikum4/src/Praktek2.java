import java.util.Iterator;

import javax.swing.JOptionPane;
public class Praktek2 {

	public static void main(String[] args) {
		
		int k = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukan Baris","Form Input",JOptionPane.QUESTION_MESSAGE));
		int j = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukan Kolom","Form Input",JOptionPane.QUESTION_MESSAGE));
		int a[][] = new int[k][j];
		JOptionPane input = new JOptionPane();
	
		
		//untuk menginput baris dan kolom
		for (int i = 0; i < a.length ; i++) {
			for(int x = 0 ; x < a.length ; x++) {
				a[i][x] = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Angka : ", "Input", JOptionPane.QUESTION_MESSAGE));
			}
		}
		
		String output = "";
		for(int y = 0; y<a.length; y++) {
			for (int z = 0; z < a.length; z++) {
				output += " Baris ke - " + y + "Kolom ke - "+ z + " = "+ a[y][z]+"\n";
			}
			
		}
		JOptionPane.showMessageDialog(null,output);
		
	}
}
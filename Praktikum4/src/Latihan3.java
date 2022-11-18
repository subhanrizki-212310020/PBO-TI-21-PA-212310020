import javax.swing.JOptionPane;
public class Latihan3 {

	public static void main(String[] args) {
		
		int n = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukan Baris","Form Input",JOptionPane.QUESTION_MESSAGE));
		int array[] = new int[n];
		
		
		
		for (int i = 0; i < array.length ; i++) {
			 array[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Angka : ", "Input", JOptionPane.QUESTION_MESSAGE));
		}
		
		String output = "";
		for(int j = 0; j<array.length; j++) {
			output += "X{"+j+"}"+ "="+ array[j]+"\n";
		}
		
		JOptionPane.showMessageDialog(null,output);
	}
		
}
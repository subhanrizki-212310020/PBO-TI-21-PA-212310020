import javax.swing.JOptionPane;
public class Latihan4 {

	public static void main(String[] args) {
		
		int n = Integer.parseInt(JOptionPane.showInputDialog(null,"Masukan Baris","Form Input",JOptionPane.QUESTION_MESSAGE));
		int array[] = new int[n];
		
		int max, min;
		
		for (int i = 0; i < array.length ; i++) {
			 array[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Angka : ", "Input", JOptionPane.QUESTION_MESSAGE));
		}
		max = array[0]; //memasukan nilai array ke variabel max
		min = array[0]; //memasukan nilai array ke variabel min
		String output = "";
		String output2= "";
		for(int j = 0; j<array.length; j++) {
			if(array[j]>max) {
				max = array[j];	
			}else if(array[j]<min) {
				min = array[j];
			}
			output += "X{"+j+"}"+ "="+ array[j]+"\n";
			output2 = "Bilangan terbesar = "+max+"\n"+"Bilangan terkecil = "+min;
			
		
		}
		JOptionPane.showMessageDialog(null, output + output2);
	}
		
}

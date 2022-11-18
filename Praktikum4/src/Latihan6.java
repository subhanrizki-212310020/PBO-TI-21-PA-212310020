import javax.swing.JOptionPane;
public class Latihan6 {

	
	public static void printArray(int[][] a, int [][] b) {
		String outputa = "";
		int row_A = a.length;
		int column_A = a[0].length;
		for(int i=0; i<row_A; i++) {
			for (int j=0; j<column_A; j++) {
				outputa += "["+a[i][j]+"]"; 
				
			}
		}
		String outputb = "";
		int row_B = b.length;
		int column_B = b[0].length;
		for(int i=0; i<row_B; i++) {
			for (int j=0; j<column_B; j++) {
				outputb += "["+b[i][j]+"]";  
				
			}
		}
		JOptionPane.showMessageDialog(null, "Matrix A "+outputa+"\n"+"Matrix B "+outputb);
	}
	public static void main(String[] args) {
	int a[][] = new int [2][2];
	int b[][] = new int [2][2];
	
	for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a[0].length; j++) {
			a[i][j]=Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan angka ","Matrix A["+i+"]"+"["+j+"]",JOptionPane.QUESTION_MESSAGE));
		}
	}
	for (int i = 0; i < b.length; i++) {
		for (int j = 0; j < b[0].length; j++) {
			b[i][j]=Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan angka ","Matrix B["+i+"]"+"["+j+"]",JOptionPane.QUESTION_MESSAGE));
	
		}
	}
	printArray(a, b);
}

}
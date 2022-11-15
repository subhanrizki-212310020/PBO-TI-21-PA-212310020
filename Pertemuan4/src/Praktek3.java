import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Praktek3 {
	public static void main(String[] args) {
		
		int [][] a= {
				{2,8},
				{9,3}
		};
		int [][] b= {
				{2,4},
				{4,6}
		};
		printArray(a);
		printArray(b);
		
		System.out.println("Penjumlahan");
		int[][] hasilTambah = tambah(a,b);
		printArray(hasilTambah);
	}
	private static int [][] tambah(int [][]a, int [][]b) {
		int baris_a = a.length;
		int kolom_a = b[0].length;
		
		int baris_b = a.length;
		int kolom_b = b[0].length;

		int [][] hasil = new int [baris_a][kolom_a];
		
		for(int i=0; i<kolom_a; i++) {//baris
			for(int  j=0; j<kolom_a; j++) {//kolom
				hasil[i][j] = a[i][j] - b[i][j];
			}
		}
		return hasil;
		
	}
	
	public static void printArray(int[][] a) {
		int row = a.length;
		int column = a[0].length;
		for(int i=0; i<row; i++) {
			for (int j=0; j<column; j++) {
				System.out.println(a[i][j]);
			}
		}
	}
}

//import javax.swing.JOptionPane;
//import java.util.ArrayList;

//public class praktek_3 {
	
	
//	public static void main(String[] args) {
		
//		int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan baris A : ","Array A",JOptionPane.QUESTION_MESSAGE));
//		int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Kolom A : ","Array A",JOptionPane.QUESTION_MESSAGE));
//		int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan baris B : ","Array B",JOptionPane.QUESTION_MESSAGE));
//		int d = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukan Kolom B : ","Array B",JOptionPane.QUESTION_MESSAGE));
//		int baris_a[] = new int [a];
//		int kolom_a[] = new int [b];
//		int baris_b[] = new int [c];
//		int kolom_b[] = new int [d];
		
//		for(int i = 0; i<baris_a.length; i++) {
//			for(int j = 0; j<kolom_a.length; j++) {
//				baris_a[i]=Integer.parseInt(JOptionPane.showInputDialog(null,"Masukan Baris : ","Array A",JOptionPane.QUESTION_MESSAGE));
//				kolom_a[j]=Integer.parseInt(JOptionPane.showInputDialog(null,"Masukan Kolom : ","Array A",JOptionPane.QUESTION_MESSAGE));
//			}
//		}
		
//		for(int x = 0; x<baris_b.length; x++) {
//			for(int y = 0; y<kolom_b.length; y++) {
//				baris_b[x]=Integer.parseInt(JOptionPane.showInputDialog(null,"Masukan baris : ","Array B ",JOptionPane.QUESTION_MESSAGE));
//				kolom_b[y]=Integer.parseInt(JOptionPane.showInputDialog(null,"Masukan kolom : ","Array B ",JOptionPane.QUESTION_MESSAGE));
//			}
//		}
//		
//		String outputA=" ";
//		for(int e = 0; e<baris_a.length; e++) {
//			for (int f = 0; f <kolom_a.length; f++) {
//				outputA += baris_a[e] + kolom_a[f]+"\n";
//		}
//		}
		
//		String outputB=" ";
//		for(int k = 0; k<array_b.length; k++) {
//			for (int l = 0; l <array_b[0].length; l++) {
//				outputB += array_b[k][l]+"\n";
//			}
//		}
		
//		JOptionPane.showMessageDialog(null,outputA+"\n"+outputB);
		//int [][] a= {
		//		{2,8},
		//		{9,3}
		//};
		//int [][] b= {
		//		{2,4},
		//		{4,6}
		//};
		//printArray(a);
		//printArray(b);
		
		//System.out.println("Penjumlahan");
		//int[][] hasilTambah = tambah(a,b);
		//printArray(hasilTambah);
	
	//private static int [][] tambah(int [][]a, int [][]b) {
		//int baris_a = a.length;
		//int kolom_a = b[0].length;
		
		//int baris_b = a.length;
		//int kolom_b = b[0].length;

		//int [][] hasil = new int [baris_a][kolom_a];
		
		//for(int i=0; i<kolom_a; i++) {//baris
		//	for(int  j=0; j<kolom_a; j++) {//kolom
		//		hasil[i][j] = a[i][j] + b[i][j];
		//	}
		//}
		//return hasil;
		
	//8}
	
	
			

//}
//}
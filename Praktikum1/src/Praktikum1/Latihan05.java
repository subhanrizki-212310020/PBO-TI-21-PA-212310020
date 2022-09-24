package Praktikum1;
import java.util.Scanner;
public class Latihan05 {
			public static void main(String[] args) {
				Scanner myObj = new Scanner(System.in);

				System.out.println("Masukan Nama : ");
				String nama = myObj.nextLine();
				myObj.close();
				System.out.println("Hasil : "+nama.toUpperCase());
			}
	}

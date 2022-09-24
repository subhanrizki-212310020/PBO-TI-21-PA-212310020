package Praktikum1;
import java.util.Scanner;
public class Latihan06 {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);

		System.out.print("Masukan Usia : ");
		int usia = myObj.nextInt();
		System.out.println("Masukan FirstName : ");
		String fn = myObj.nextLine();
		myObj.nextLine();
		System.out.println("Masukan LastName : ");
		String ln = myObj.nextLine();
		System.out.print("Masukan NPM : ");
		int npm = myObj.nextInt();

		myObj.close();

		System.out.println(usia+fn.concat(ln)+npm);

	}

}
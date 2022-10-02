import java.util.Scanner;
public class Latihan3 {
	public static void main(String[] args) {
		Scanner input = new Scanner ( System.in);

		System.out.println("1.Nasi Goreng"); 
		System.out.println("2.Bubur Ayam"); 
		System.out.println("3.Soto Ayam"); 

		System.out.println("Masukan nomor pesanan :");
		int nomor= input.nextInt();

		switch (nomor) {
		case 1 : 
			System.out.println("1.Anda memesan Nasi Goreng dengan harga Rp22.000");
			break;

		case 2 :
			System.out.println("2. Anda memesan Bubur Ayam dengan harga Rp15.000");
			break;

		case 3 :
			System.out.println("3. Anda memesan Soto Ayam dengan harga Rp25.000");
			break;
		default:
			System.out.println("Maaf menu yang anda masukan salah.");
		}
	}
}
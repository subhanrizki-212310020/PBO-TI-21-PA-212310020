import java.util.Scanner;
public class Latihan7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String jwb;

		Resto restoObj = new Resto();

		do {
			restoObj.chooseMenu();
			System.out.print("Apakah anda akan memesan kembali ? (Y/N)");
			jwb = input.nextLine();
		}
		while(jwb.equals("Y"));
	}
}	
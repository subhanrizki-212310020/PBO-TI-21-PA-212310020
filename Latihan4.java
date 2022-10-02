import java.util.Scanner;
public class Latihan4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System. in );
        System.out.println("Masukkan angka : ");
        int nilai = input.nextInt();
        System.out.print("faktor "+nilai+" adalah ");
        int tambah = 0;
        for (int z = 0; z <= nilai; z++) {
            tambah++;
            if (nilai % tambah == 0) {
                System.out.print(tambah + " ");

            }
        }

	}

}
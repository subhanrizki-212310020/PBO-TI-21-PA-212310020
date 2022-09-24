package Praktikum1;
import java.util.Scanner;

	public class Latihan02 {
	public static void main(String[] args ) {
	
			double celcius, fahrenheit, reamur, kelvin;
			
			System.out.print("Masukan Suhu: ");
			Scanner input = new Scanner(System.in);
			celcius = input.nextDouble();
			fahrenheit = (9/5 * celcius) + 32;
			reamur = celcius * 4/5;
			kelvin	= celcius + 273;
			
			System.out.println("celcius: " + celcius);
			System.out.println("kelvin: "+ kelvin);
			System.out.println("reamur: "+ reamur);
			System.out.println("fahrenheit: " + fahrenheit);
	}
}
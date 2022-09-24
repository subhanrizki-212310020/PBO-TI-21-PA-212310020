package Praktikum1;
public class Latihan01 {
	float c, f, k, r;

	public static void main(String[] args) {
		int c = 20;
		double f = 9/5 * c + 32;
		double r = 4/5 * c;
		double k = 273.15 + c;

		System.out.println("C = "+c);
		System.out.println("CelciusToFarenheit "+f);
		System.out.println("CelciusToReamur "+r);
		System.out.println("KelvinToReamur "+k);
	}
}
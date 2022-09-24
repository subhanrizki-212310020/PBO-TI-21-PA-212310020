package Praktikum1;

public class Latihan03 {
	int hasil;

	void HitungKerucut() {
		float r   = 10;
		float s	  = 2;
		float t   = 5;
		float phi = (float) 3.14;
		float lk  = phi * (r * r) * phi * (r * s);
		float vk  = phi * (r * r) * t * 1 / 3; 

		System.out.println("Hasil Luas Kerucut "+lk );
		System.out.println("Hasil Volume Kerucut "+vk);
	}
	void HitungTabung() {
		float r   = 5;
		float phi = (float)3.14;
		float t   = 10;
		float vt  = phi * (r * r) * t;
		float lt  = 2 * phi * r * (r + t);
		float kt  = 2 * phi * r * t;

		System.out.println("Hasil Luas Tabung "+lt);
		System.out.println("Hasil Keliling Tabung "+kt);
		System.out.println("Hasil Volume Tabung "+vt);
	}

	public static void main(String[] args) {
		Latihan03 hasil = new Latihan03();
		hasil.HitungKerucut();
		System.out.println("===================");
		hasil.HitungTabung();

	}

}
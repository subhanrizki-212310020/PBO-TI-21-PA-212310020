package Praktikum1;

import java.util.Scanner;
import java.time.LocalDate;


public class Latihan04 {		
			public static void main(String[] args) {
				double hasil, diskon, Sub_total;
				int Jmlh;
				Scanner myObj = new Scanner(System.in);
				LocalDate myDate = LocalDate.now();

				System.out.println("Masukan Jumlah Produk Yang dibeli : ");
				Jmlh = myObj.nextInt();
				hasil=Jmlh * 6300;;

				myObj.close();



				System.out.println("==========================");
				System.out.println(""+"TOKO SERBAGUNA IBIK"+"");
				System.out.println("==========================");
				System.out.println("Masukan Jumlah Produk Yang dibeli : "+Jmlh);

				System.out.println(myDate);
				System.out.println("ITEM"+"      "+"QTY"+"   "+"HARGA"+"  "+"  TOTAL");
				System.out.println("=============================================");
				System.out.println("ROTI ENAK "+Jmlh+"   Rp 6.300"+"   "+"Rp"+hasil);

				if(Jmlh % 3==0) {
					diskon = hasil * 0.10;
					Sub_total = hasil - diskon;
					System.out.println("Diskon : 10%");
					System.out.println("Sub Total : "+Sub_total);
				}
			}


	}


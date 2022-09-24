package Praktikum1;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Latihan10 {
	public static void main(String[] args) {
		Students myName = new Students();
		
		int jml,total_harga,harga_satuan = 6300;
		double diskon = 0,total_bayar = 0;
		
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
		
		System.out.println("========================================");
		System.out.println("          TOKO SERBAGUNA IBIK           ");
		System.out.println("========================================");
		System.out.print("Masukkan jumlah produk yang dibeli : ");
		Scanner input = new Scanner(System.in);
		jml = input.nextInt();
		input.close();
		
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    String formattedDate = myDateObj.format(myFormatObj);
	    System.out.println(formattedDate);
		
		System.out.println();
		
		total_harga = jml * 6300;
		
		System.out.println("ITEM               QTY   HARGA          TOTAL");
		System.out.println("==============================================");
		kursIndonesia.setDecimalFormatSymbols(formatRp);
		System.out.printf("ROTI ENAK           " + jml + "    %s %n", kursIndonesia.format(harga_satuan) + "   " + kursIndonesia.format(total_harga));
		System.out.println("----------------------------------------------");
		if(jml % 3 == 0) {
			diskon = 0.05 * total_harga;
			total_bayar = total_harga - diskon;
			System.out.println("Diskon : 5%");
		}else {
			diskon = 0.010 * total_harga;
			total_bayar = total_harga - diskon;
			System.out.println("Diskon : 10%");
		}
		
		kursIndonesia.setDecimalFormatSymbols(formatRp);
	    System.out.printf("Sub Total: %s %n", kursIndonesia.format(total_bayar));
	    System.out.println("Nama Member : " + myName.getFullName("Muhamad Subhan"));
	}
}
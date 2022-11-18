import javax.swing.JOptionPane;
import java.util.regex.Pattern;

public class Latihan4 {
	
	public static void main(String[] args) {
		Biodata myBio = new Biodata();
		boolean ulang = true;
		
		while (ulang) {
		
		String fullname, alamat, age;
		
		fullname = JOptionPane.showInputDialog(null,"Masukan fullname Anda","Kotak Input",JOptionPane.QUESTION_MESSAGE);
		if(fullname.isBlank()) {
			JOptionPane.showMessageDialog(null,"Field [fullname] tidak boleh kosong","PERINGATAN",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		
		alamat = JOptionPane.showInputDialog(null,"Masukan alamat","Form Alamat",JOptionPane.QUESTION_MESSAGE);
		if(alamat.isBlank()) {
			JOptionPane.showMessageDialog(null,"Field [alamat] tidak boleh kosong","PERINGATAN",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		age = JOptionPane.showInputDialog(null,"Masukan usia:","Kotak Input",JOptionPane.QUESTION_MESSAGE);
		if(age.isBlank()) {
			JOptionPane.showMessageDialog(null,"Field [Usia] tidak boleh kosong","PERINGATAN",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		
		if(fullname.isBlank() && alamat.isBlank() && age.isBlank()) {
				JOptionPane.showMessageDialog(null,"Field [fullname/usia/alamat] tidak boleh kosong","Error Message",JOptionPane.ERROR_MESSAGE);
		}

		else if(!Pattern.matches("^[0-9]+$", age)) {
			JOptionPane.showMessageDialog(null,"Isian usia harus angka","Error Message",JOptionPane.ERROR_MESSAGE);
		}
		
		else if(alamat.length() < 10) {
			JOptionPane.showMessageDialog(null,"Masukan alamat minimum 10 karakter","Error Message",JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null,"Seluruh informasi telah dimasukan","Output Message",JOptionPane.INFORMATION_MESSAGE);
		}
		
		int page = Integer.parseInt(age);
		
		myBio.setData(fullname, page, alamat);
		myBio.getData();
		
		int keluar = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin keluar?", "Keluar?", JOptionPane.YES_NO_OPTION);
		
		if(keluar == JOptionPane.YES_OPTION) {
			ulang = false;
		} else {
			ulang = true;
		}
		}
	}

}
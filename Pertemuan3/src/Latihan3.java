import javax.swing.JOptionPane;
import java.util.regex.Pattern;

public class Latihan3 {
	
	public static void main(String[] args) {
		Biodata myBio = new Biodata();
		
		String fullname, alamat, age;
		
		fullname = JOptionPane.showInputDialog(null,"Masukan fullname Anda","Kotak Input",JOptionPane.QUESTION_MESSAGE);
		
		alamat = JOptionPane.showInputDialog(null,"Masukan alamat","Kotak Input",JOptionPane.QUESTION_MESSAGE);
		
		age = JOptionPane.showInputDialog(null,"Input your usia:","Kotak Input",JOptionPane.QUESTION_MESSAGE);
		
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
		
		
	}

}
import javax.swing.JOptionPane;

public class Latihan2{
	
	public static void main(String[] args) {
	Biodata myBio = new Biodata();
	
	myBio.setFullname(JOptionPane.showInputDialog(null,"Masukan Nama Anda","Kotak Input",JOptionPane.QUESTION_MESSAGE));
	myBio.setAge(Integer.parseInt(JOptionPane.showInputDialog(null,"Masukan Umur Anda","Kotak Input",JOptionPane.QUESTION_MESSAGE)));
	myBio.setAlamat(JOptionPane.showInputDialog(null,"Masukan Alamat","Kotak Input",JOptionPane.QUESTION_MESSAGE));
	
	JOptionPane.showMessageDialog(null,"Nama anda "+myBio.getFullname()+"\nUmur anda "+myBio.getAge()+"\nAlamat "+myBio.getAlamat());

	}
}
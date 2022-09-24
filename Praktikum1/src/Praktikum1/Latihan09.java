package Praktikum1;
import java.util.Scanner;

public class Latihan09 {
	
	public static void main(String[] args) {
		Latihan09 myProgram = new Latihan09();

        System.out.println("=======WELCOME=======");
        System.out.println("======== ENTER YOUR DATA =======");
        
        myProgram.InputStudents();
    }

    void InputStudents() {
        Students myBio = new Students();
        Scanner valueueInput = new Scanner(System.in);
        
       
        int inNPM, inSemester;
        float inGPA;
        String inFullName, inClassName;
    
        int objNPM, objSemester;
        float objGPA;
        String objFullName, objClassName;

        System.out.print("Masukkan NPM = ");
        inNPM = valueueInput.nextInt();
        objNPM = myBio.getNPM(inNPM);

        valueueInput.nextLine();
        
        System.out.print("Masukkan nama lengkap Anda = ");
        inFullName = valueueInput.nextLine();
        objFullName = myBio.getFullName(inFullName);

        System.out.print("Masukkan kelas Anda = ");
        inClassName = valueueInput.nextLine();
        objClassName = myBio.getClassName(inClassName);

        System.out.print("Masukkan semester Anda = ");
        inSemester = valueueInput.nextInt();
        objSemester = myBio.getSemester(inSemester);

        System.out.print("Masukkan GPA / IPK Anda = ");
        inGPA = valueueInput.nextFloat();
        objGPA = myBio.getGPA(inGPA);

        OutputStudents(objNPM, objFullName, objClassName, objSemester, objGPA);

        valueueInput.close();
    }

    void OutputStudents(int value_NPM, String value_FullName, String value_ClassName, int value_Semester, float value_GPA) {
    	System.out.print("\n");
    	
        System.out.println("NPM            : " + value_NPM);
        System.out.println("Nama Lengkap   : " + value_FullName);
        System.out.println("Kelas          : " + value_ClassName);
        System.out.println("Semester       : " + value_Semester);
        System.out.println("GPA / IPK      : " + value_GPA);
    }

}
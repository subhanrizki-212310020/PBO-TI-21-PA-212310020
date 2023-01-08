import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Latihan02 {
    
    public static void main(String[] args) {
        Latihan02 mainApps = new Latihan02();

        ArrayList<ArrayList<Integer>> matriks_a = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> matriks_b = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < 2; i++) {
            matriks_a.add(new ArrayList<Integer>());
            for(int j = 0; j < 2; j++) {
                String values_matriks_a = JOptionPane.showInputDialog(null,
                                          "Masukkan angka:",
                                          "Matriks A[" + i + "][" + j + "]",
                                          JOptionPane.QUESTION_MESSAGE);
                matriks_a.get(i).add(j, Integer.parseInt(values_matriks_a));
            }
        }

        for(int k = 0; k < 2; k++) {
            matriks_b.add(new ArrayList<Integer>());
            for(int l = 0; l < 2; l++) {
                String values_matriks_b = JOptionPane.showInputDialog(null,
                                "Masukkan angka:",
                                        "Matriks B[" + k + "][" + l + "]",
                                        JOptionPane.QUESTION_MESSAGE);
                matriks_b.get(k).add(l, Integer.parseInt(values_matriks_b));
            }
        }

        String print_matriks = "Matriks A:\n" + mainApps.PrintArr(matriks_a) + "\nMatriks B:\n" + mainApps.PrintArr(matriks_b);

        JOptionPane.showMessageDialog(null, print_matriks);

    }

    private String PrintArr(ArrayList<ArrayList<Integer>> val) {
        String output = "";

        for(int i = 0; i < val.size(); i++) {
            for(int j = 0; j < val.size(); j++) {
                output += val.get(i).get(j) + " ";
            }
            output += "\n";
        }

        return output;
    }

}
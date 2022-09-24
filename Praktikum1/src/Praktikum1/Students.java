package Praktikum1;
public class Students {
	int NPM;
    String FullName;
    String ClassName;
    int Semester;
    float GPA;

    int getNPM(int value) {
        NPM = value;
        return NPM;
    }

    String getFullName(String value) {
        FullName = value;
        return FullName;
    }

    String getClassName(String value) {
        ClassName = value;
        return ClassName;
    }

    int getSemester(int value) {
        Semester = value;
        return Semester;
    }

    float getGPA(float value) {
        GPA = value;
        return GPA;
    }
    
}
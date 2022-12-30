package com.ibik.pbo.praktikum;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class App {
    
    public static ArrayList<String> field = new ArrayList<String>();
    
    public static  void main(String[] args) {
    	
    	ArrayList<String> field = new ArrayList<String>();
    	
    	field.add("Nama Lengkap");
    	field.add("Alamat");
    	field.add("No Telp");
    	
    	ArrayList<ArrayList<String>> field2 = new ArrayList<ArrayList<String>>();
    	for(int i=0; i<3; i++) {
    		field2.add(new ArrayList<String>());
    		for(int j=0; j<3; j++) {
    			String values = JOptionPane.showInputDialog(null, "Masukan "+
    							field.get(j), "Data Array [" +i+ "][" +j+ "]",
    							JOptionPane.QUESTION_MESSAGE);
    			field2.get(i).add(j, values);
    		}
    	}
    	
    	String output="";
    	for(int i=0; i<3; i++) {
    		for(int j=0; j<3; j++) {
    			output+= field.get(j) + ":" + field2.get(i).get(j) + "\n";
    		}
    	}output += "\n";
    	JOptionPane.showMessageDialog(null, output ,"Output data ", JOptionPane.INFORMATION_MESSAGE);
    } 
    
}
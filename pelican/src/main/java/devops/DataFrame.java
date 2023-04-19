package devops;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DataFrame 
{
    String[] colonne;
    String[][] ligne;
    
    DataFrame(String[] colonne, String[][] ligne){
        this.colonne = colonne;
        this.ligne = new String[ligne.length][];
        for (int i=0; i< colonne.length; i++){
        	this.ligne[i] = new String[ligne[i].length];
            for(int j = 0; j<ligne[i].length; j++) {
            	this.ligne[i][j] = ligne[i][j];
            }
        }
        print();
    }
    
    DataFrame(File file) throws IOException {
    	BufferedReader reader;
    	int count=0;
    	String[] currentLine;
    	
		try {
			reader = new BufferedReader(new FileReader(file));
			while(reader.readLine() != null) {
				count++;
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(file));
			colonne = reader.readLine().split(",");
			ligne = new String[count][];
			for(int i = 0; i<count-1; i++) {
				currentLine = reader.readLine().split(",");
				ligne[i] = new String[currentLine.length];
	            for(int j = 0; j<currentLine.length; j++) {
	            	ligne[i][j] = currentLine[j];
	            }
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		print();
    }
    
    public void print() {
    	for(int i = 0; i<colonne.length; i++) {
    		System.out.print("  "+colonne[i]);
    	}
        
        System.out.println();
        
        for (int j=0; j< ligne[0].length; j++){
            System.out.print(j+" ");
            for (int i=0; i<colonne.length; i++){
            System.out.print(ligne[j][i]+" ");
            }
            System.out.println();
        }
    }
    
}

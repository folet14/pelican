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
    
    // construction via un tableau
    DataFrame(String[] colonne, String[][] ligne){
        this.colonne = colonne;
        this.ligne = new String[ligne.length][];
        for (int i=0; i< colonne.length; i++){
        	this.ligne[i] = new String[ligne[i].length];
            for(int j = 0; j<ligne[i].length; j++) {
            	this.ligne[i][j] = ligne[i][j];
            }
        }
        print(0,ligne.length,0,colonne.length);
    }
    
    // construction via un fichier csv
    DataFrame(File file) throws IOException {
    	BufferedReader reader;
    	int count=0;
    	String[] currentLine;
    	
		try {
            // recupere le nombre de lignes (pour initialiser la structure)
			reader = new BufferedReader(new FileReader(file));
			while(reader.readLine() != null) {
				count++;
			}
			count--;
			reader.close();
			
            // remplit la structure
			reader = new BufferedReader(new FileReader(file));
			colonne = reader.readLine().split(",");
			ligne = new String[count][];
			for(int i = 0; i<count; i++) {
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
		print(0,ligne.length,0,colonne.length);
    }
    
    private void print(int debut_ligne, int fin_ligne, int debut_colonne, int fin_colonne) {
    	for(int i = debut_colonne; i<fin_colonne; i++) {
    		System.out.print("  "+colonne[i]);
    	}
        
        System.out.println();
        
        for (int j=debut_ligne; j<fin_ligne; j++){
            System.out.print(j+" ");
            for (int i=debut_colonne; i<fin_colonne; i++){
            	System.out.print(ligne[j][i]+" ");
            }
            System.out.println();
        }
    }

	public void printAll() {
		print(0, ligne.length, 0, colonne.length);
	}
    
	public void printRows(int debut_ligne, int fin_ligne) {
		print(debut_ligne, fin_ligne, 0, colonne.length);
	}

	public void printColumns(int debut_colonne, int fin_colonne) {
		print(0, ligne.length, debut_colonne, fin_colonne);
	}

	public boolean equals(DataFrame df) {
		if(this.colonne.length != df.colonne.length) {
			return false;
		}
		// vérfie la taille de chaque ligne
		for(int i = 0; i < ligne.length; i++) {
			if(this.ligne[i].length != df.ligne[i].length) {
				return false;
			}
			// vérifie chaque élément
			for(int j = 0; j < colonne.length; j++) {
				if(!(this.ligne[j][i].equals(df.ligne[j][i]))) {
					return false;
				}
			}
		}
		return true;
	}
}

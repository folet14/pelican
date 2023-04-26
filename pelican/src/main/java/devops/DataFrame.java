package devops;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataFrame {

	private ArrayList<ArrayList<Object>> data;
	private ArrayList<String> labels;

	public DataFrame(ArrayList<ArrayList<Object>> table, ArrayList<String> labels) {
		this.data = table;
		this.labels = labels;

	}

	private ArrayList<Object> getColumn(int index) {
		ArrayList<Object> column = new ArrayList<>();
		for (ArrayList<Object> row : data) {
			column.add(row.get(index));
		}
		return column;
	}

	public ArrayList<Object> getLigne(int index) {
		return data.get(index);
	}

	public String getLabel(int index) {
		return labels.get(index);
	}

	public void addRow(ArrayList<Object> values) {
		data.add(values);
	}

	public void afficherAll() {
		System.out.print(" ");
		for (Object l : labels) {
			System.out.print(" " + l);
		}
		System.out.println();
		int i = 0;
		for (ArrayList<Object> arrayList : data) {
			System.out.print(i);
			for (Object a : arrayList) {
				System.out.print(" " + a);
			}
			System.out.println();
			i++;
		}
	}

	public void afficherPremiereLigne(int ligne) {
		System.out.print(" ");
		for (Object l : labels) {
			System.out.print(" " + l);
		}
		System.out.println();

		for (int i = 0; i < ligne; i++) {
			ArrayList<Object> arrayList = data.get(i);
			System.out.print(i);
			for (Object a : arrayList) {
				System.out.print(" " + a);
			}
			System.out.println();
		}
	}

	public void afficherDerniereLigne(int ligne) {
		System.out.print(" ");
		for (Object l : labels) {
			System.out.print(" " + l);
		}
		System.out.println();

		for (int i = data.size() - ligne; i < data.size(); i++) {
			ArrayList<Object> arrayList = data.get(i);
			System.out.print(i);
			for (Object a : arrayList) {
				System.out.print(" " + a);
			}
			System.out.println();
		}
	}

	public DataFrame selectionLignes(ArrayList<Integer> lignes) {
		ArrayList<ArrayList<Object>> dt = new ArrayList<>();
		for (Integer integer : lignes) {
			dt.add(data.get(integer));
		}
		return new DataFrame(dt, labels);
	}

	public DataFrame selectionColonne(ArrayList<String> col) {
		ArrayList<ArrayList<Object>> dt = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < labels.size(); i++) {
			if (col.contains(labels.get(i))) {
				ArrayList<Object> cl = getColumn(i);
				for (int j = 0; j < cl.size(); j++) {
					if (count == 0) {
						ArrayList<Object> l = new ArrayList<Object>();
						l.add(cl.get(j));
						dt.add(l);
					} else {
						dt.get(j).add(cl.get(j));
					}
				}
				count++;

			}
		}
		return new DataFrame(dt, col);
	}

	public double maxValue(ArrayList<String> colonne) {
		double max = 0;
		if (colonne!= null) {
			for (int i = 0; i < labels.size(); i++) {
				if (colonne.contains(labels.get(i))) {
					for (Object value : getColumn(i)) {
						if (Double.valueOf((String) value) > max) {
							max = Double.valueOf((String) value);
						}
					}
				}

			}
		} else {
			for (ArrayList<Object> arrayList : data) {
				for (Object value : arrayList) {
					if (Double.valueOf((String) value) > max) {
						max = Double.valueOf((String) value);
					}
				}
			}
		}

		return max;
	}

	public double minValue(ArrayList<String> colonne) {
		double min = Math.pow(10, 10);
		if (colonne != null) {
			for (int i = 0; i < labels.size(); i++) {
				if (colonne.contains(labels.get(i))) {
					for (Object value : getColumn(i)) {
						if (Double.valueOf((String) value) < min) {
							min = Double.valueOf((String) value);
						}
					}
				}

			}
		} else {
			for (ArrayList<Object> arrayList : data) {
				for (Object value : arrayList) {
					if (Double.valueOf((String) value) < min) {
						min = Double.valueOf((String) value);
					}
				}
			}
		}

		return min;
	}

	public double moyenValue(ArrayList<String> colonne) {
		double sum = 0;
		double count = 0;
		if (colonne!= null) {
			for (int i = 0; i < labels.size(); i++) {
				if (colonne.contains(labels.get(i))) {
					for (Object value : getColumn(i)) {
						sum += Double.valueOf((String) value);
						count++;
					}
				}

			}
		} else {
			for (ArrayList<Object> arrayList : data) {
				for (Object value : arrayList) {
					sum += Double.valueOf((String) value);
					count++;
				}
			}
		}

		return sum/count;
	}

	public DataFrame fromCSV(String filePath) throws IOException {
		ArrayList<ArrayList<Object>> table = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String[] colonne = reader.readLine().split(",");
		String lignetmp;
		for (int i = 0; i < colonne.length; i++) {
			labels.add(colonne[i]);
		}
//		reader.close();
//		reader = new BufferedReader(new FileReader(filePath));
		while ((lignetmp = reader.readLine()) != null) {
			String[] ligne = lignetmp.split(",");
			ArrayList<Object> row = new ArrayList<>();
			for (int i = 0; i < ligne.length; i++) {
				row.add(ligne[i]);
			}
			table.add(row);
		}
//		CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT);
//		for (CSVRecord record : parser) {
//			ArrayList<Object> row = new ArrayList<>();
//			for (String value : record) {
//				row.add(value);
//			}
//			table.add(row);
//		}
		reader.close();
		return new DataFrame(table, labels);
	}

//    String[] colonne;
//    String[][] ligne;
//    
//    // construction via un tableau
//    DataFrame(String[] colonne, String[][] ligne){
//        this.colonne = colonne;
//        this.ligne = new String[ligne.length][];
//        for (int i=0; i< colonne.length; i++){
//        	this.ligne[i] = new String[ligne[i].length];
//            for(int j = 0; j<ligne[i].length; j++) {
//            	this.ligne[i][j] = ligne[i][j];
//            }
//        }
//        print(0,ligne.length,0,colonne.length);
//        
//    }
//    
//    // construction via un fichier csv
//    DataFrame(File file) throws IOException {
//    	BufferedReader reader;
//    	int count=0;
//    	String[] currentLine;
//    	
//		try {
//            // recupere le nombre de lignes (pour initialiser la structure)
//			reader = new BufferedReader(new FileReader(file));
//			while(reader.readLine() != null) {
//				count++;
//			}
//			count--;
//			reader.close();
//			
//            // remplit la structure
//			reader = new BufferedReader(new FileReader(file));
//			colonne = reader.readLine().split(",");
//			ligne = new String[count][];
//			for(int i = 0; i<count; i++) {
//				currentLine = reader.readLine().split(",");
//				ligne[i] = new String[currentLine.length];
//	            for(int j = 0; j<currentLine.length; j++) {
//	            	ligne[i][j] = currentLine[j];
//	            }
//			}
//			reader.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		print(0,ligne.length,0,colonne.length);
//    }
//    
//    private void print(int debut_ligne, int fin_ligne, int debut_colonne, int fin_colonne) {
//    	for(int i = debut_colonne; i<fin_colonne; i++) {
//    		System.out.print("  "+colonne[i]);
//    	}
//        
//        System.out.println();
//        
//        for (int j=debut_ligne; j<fin_ligne; j++){
//            System.out.print(j+" ");
//            for (int i=debut_colonne; i<fin_colonne; i++){
//            	System.out.print(ligne[j][i]+" ");
//            }
//            System.out.println();
//        }
//    }
//
//	public void printAll() {
//		print(0, ligne.length, 0, colonne.length);
//	}
//    
//	public void printRows(int debut_ligne, int fin_ligne) {
//		print(debut_ligne, fin_ligne, 0, colonne.length);
//	}
//
//	public void printColumns(int debut_colonne, int fin_colonne) {
//		print(0, ligne.length, debut_colonne, fin_colonne);
//	}
//
//	public boolean equals(DataFrame df) {
//		if(this.colonne.length != df.colonne.length) {
//			return false;
//		}
//		// vérfie la taille de chaque ligne
//		for(int i = 0; i < ligne.length; i++) {
//			if(this.ligne[i].length != df.ligne[i].length) {
//				return false;
//			}
//			// vérifie chaque élément
//			for(int j = 0; j < colonne.length; j++) {
//				if(!(this.ligne[j][i].equals(df.ligne[j][i]))) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}
}

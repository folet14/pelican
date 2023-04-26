package devops;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataFrame {

	private ArrayList<ArrayList<String>> data;
	private ArrayList<String> labels;

	public DataFrame(ArrayList<ArrayList<String>> table, ArrayList<String> labels) {
		this.data = table;
		this.labels = labels;

	}

	public DataFrame(String filePath) throws IOException {
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String[] colonne = reader.readLine().split(",");
        String lignetmp;
        for (int i = 0; i < colonne.length; i++) {
            labels.add(colonne[i]);
        }

        while ((lignetmp = reader.readLine()) != null) {
            String[] ligne = lignetmp.split(",");
            ArrayList<String> row = new ArrayList<>();
            for (int i = 0; i < ligne.length; i++) {
                row.add(ligne[i]);
            }
            table.add(row);
        }
        reader.close();
        this.data = table;
    }
	public ArrayList<String> getColumn(int index) {
		ArrayList<String> column = new ArrayList<>();
		for (ArrayList<String> row : data) {
			column.add(row.get(index));
		}
		return column;
	}

	public ArrayList<String> getLigne(int index) {
		return data.get(index);
	}

	public String getLabel(int index) {
		return labels.get(index);
	}

	public void addRow(ArrayList<String> values) {
		data.add(values);
	}

	public void afficherAll() {
		System.out.print(" ");
		for (String l : labels) {
			System.out.print(" " + l);
		}
		System.out.println();
		int i = 0;
		for (ArrayList<String> arrayList : data) {
			System.out.print(i);
			for (String a : arrayList) {
				System.out.print(" " + a);
			}
			System.out.println();
			i++;
		}
	}

	public void afficherPremiereLigne(int ligne) {
		System.out.print(" ");
		for (String l : labels) {
			System.out.print(" " + l);
		}
		System.out.println();

		for (int i = 0; i < ligne; i++) {
			ArrayList<String> arrayList = data.get(i);
			System.out.print(i);
			for (String a : arrayList) {
				System.out.print(" " + a);
			}
			System.out.println();
		}
	}

	public void afficherDerniereLigne(int ligne) {
		System.out.print(" ");
		for (String l : labels) {
			System.out.print(" " + l);
		}
		System.out.println();

		for (int i = data.size() - ligne; i < data.size(); i++) {
			ArrayList<String> arrayList = data.get(i);
			System.out.print(i);
			for (String a : arrayList) {
				System.out.print(" " + a);
			}
			System.out.println();
		}
	}

	public DataFrame selectionLignes(ArrayList<Integer> lignes) {
		ArrayList<ArrayList<String>> dt = new ArrayList<>();
		for (Integer integer : lignes) {
			dt.add(data.get(integer));
		}
		return new DataFrame(dt, labels);
	}

	public DataFrame selectionColonne(ArrayList<String> col) {
		ArrayList<ArrayList<String>> dt = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < labels.size(); i++) {
			if (col.contains(labels.get(i))) {
				ArrayList<String> cl = getColumn(i);
				for (int j = 0; j < cl.size(); j++) {
					if (count == 0) {
						ArrayList<String> l = new ArrayList<String>();
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
					for (String value : getColumn(i)) {
						if (Double.valueOf((String) value) > max) {
							max = Double.valueOf((String) value);
						}
					}
				}

			}
		} else {
			for (ArrayList<String> arrayList : data) {
				for (String value : arrayList) {
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
					for (String value : getColumn(i)) {
						if (Double.valueOf((String) value) < min) {
							min = Double.valueOf((String) value);
						}
					}
				}

			}
		} else {
			for (ArrayList<String> arrayList : data) {
				for (String value : arrayList) {
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
					for (String value : getColumn(i)) {
						sum += Double.valueOf((String) value);
						count++;
					}
				}

			}
		} else {
			for (ArrayList<String> arrayList : data) {
				for (String value : arrayList) {
					sum += Double.valueOf((String) value);
					count++;
				}
			}
		}

		return sum/count;
	}
}

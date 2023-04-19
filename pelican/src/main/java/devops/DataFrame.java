package devops;

/**
 * Hello world!
 *
 */
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
            System.out.print("  "+colonne[i]);
        }
        System.out.println();
        for (int j=0; j< ligne[0].length; j++){
            System.out.print(j+" ");
            for (int i=0; i< colonne.length; i++){
            System.out.print(ligne[j][i]+" ");
            }
            System.out.println();
        }
        
    }
    
}

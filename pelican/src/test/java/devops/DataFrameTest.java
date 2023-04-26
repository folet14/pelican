package devops;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class DataFrameTest 
{
    private static final int DEFAULT_TIMEOUT = 2000;

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFrameStringFromArraylistTest()
    {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFramefromCSVCorrect(){
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"1", "2", "3", "4"},{"4","3","2","1"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
    try {
        DataFrame fromCsV = new DataFrame("src/test/resources/test.csv");
        assertEquals("line 1", dataFrame.getLigne(0), fromCsV.getLigne(0));
        assertEquals("line 2", dataFrame.getLigne(1), fromCsV.getLigne(1));

    } catch (Exception e) {
        System.out.println("File opening problem");
    }
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFramegetColumnCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        assertEquals("column 1", new ArrayList<String>(Arrays.asList("E","I")), dataFrame.getColumn(0));
        assertEquals("column 2", new ArrayList<String>(Arrays.asList("F","J")), dataFrame.getColumn(1));
        assertEquals("column 3", new ArrayList<String>(Arrays.asList("G","K")), dataFrame.getColumn(2));
        assertEquals("column 4", new ArrayList<String>(Arrays.asList("H","L")), dataFrame.getColumn(3));
	}

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsExceptionDataFrameGetColumnCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        dataFrame.getColumn(5);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFramegetLineCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        assertEquals("line 1", new ArrayList<String>(Arrays.asList("E","F", "G", "H")), dataFrame.getLigne(0));
        assertEquals("line 2", new ArrayList<String>(Arrays.asList("I","J", "K", "L")), dataFrame.getLigne(1));
	}

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsExceptionDataFrameGetLineCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        dataFrame.getLigne(3);
	}

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFramegetLabelCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        assertEquals("column 1", "A", dataFrame.getLabel(0));
        assertEquals("column 2", "B", dataFrame.getLabel(1));
        assertEquals("column 3", "C", dataFrame.getLabel(2));
        assertEquals("column 4", "D", dataFrame.getLabel(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsExceptionDataFrameGetLabelCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        dataFrame.getLabel(4);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFrameaddRowCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        dataFrame.addRow(new ArrayList<String>(Arrays.asList("M", "N", "O", "P")));
        assertEquals("added the last line", Arrays.asList("M", "N", "O", "P"), dataFrame.getLigne(2));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFrameSelectionLignesCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"},{"M","N","O","P"},{"Q","R","S","T"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);

        DataFrame extracted = dataFrame.selectionLignes(new ArrayList<Integer>(Arrays.asList(1,3)));
        assertEquals("line 1 equals line 1", dataFrame.getLigne(1), extracted.getLigne(0));
        assertEquals("line 2 equals line 4", dataFrame.getLigne(3), extracted.getLigne(1));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFrameSelectionColonneCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"},{"M","N","O","P"},{"Q","R","S","T"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);

        DataFrame extracted = dataFrame.selectionColonne(new ArrayList<String>(Arrays.asList("A","C")));
        assertEquals("column 1 equals line 1", dataFrame.getColumn(0), extracted.getColumn(0));
        assertEquals("column 3 equals line 2", dataFrame.getColumn(2), extracted.getColumn(1));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFramemaxValueCorrect(){
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"1", "2", "3", "4"},{"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column); 

        Double result = dataFrame.maxValue(new ArrayList<String>(Arrays.asList("A","C")));
        assertEquals("Max value between A and C", Double.valueOf("15"), result);
        result = dataFrame.maxValue(new ArrayList<String>(Arrays.asList("C","D")));
        assertEquals("Max value between C and D", Double.valueOf("16"), result);
        result = dataFrame.maxValue(null);
        assertEquals("Max value in tab", Double.valueOf("16"), result);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFrameminValueCorrect(){
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"1", "2", "3", "4"},{"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column); 

        Double result = dataFrame.minValue(new ArrayList<String>(Arrays.asList("A","C")));
        assertEquals("Min value between A and C", Double.valueOf("1"), result);
        result = dataFrame.minValue(new ArrayList<String>(Arrays.asList("C","D")));
        assertEquals("Min value between C and D", Double.valueOf("3"), result);
        result = dataFrame.minValue(null);
        assertEquals("min value of tab", Double.valueOf("1"), result);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFramemoyenValueCorrect(){
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"1", "2", "3", "4"},{"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<String>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column); 
        Double real=0.;
        for(int i = 1; i < 17; i++){
            real += i;
        }
        real /= 16.;
        Double result = dataFrame.moyenValue(null);
        assertEquals("Mean of the table", real, result);
        real = (3+7+11+15+4+8+12+16)/8.;
        result = dataFrame.moyenValue(new ArrayList<String>(Arrays.asList("C","D")));
        assertEquals("Mean of the table", real, result);

    }
}

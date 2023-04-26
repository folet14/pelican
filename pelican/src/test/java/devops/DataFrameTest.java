package devops;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
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
        ArrayList<ArrayList<Object>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<Object>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFramegetColumnCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<Object>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<Object>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        assertEquals("column 1", new ArrayList<Object>(Arrays.asList("E","I")), dataFrame.getColumn(0));
        assertEquals("column 2", new ArrayList<Object>(Arrays.asList("F","J")), dataFrame.getColumn(1));
        assertEquals("column 3", new ArrayList<Object>(Arrays.asList("G","K")), dataFrame.getColumn(2));
        assertEquals("column 4", new ArrayList<Object>(Arrays.asList("H","L")), dataFrame.getColumn(3));
	}

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsExceptionDataFrameGetColumnCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<Object>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<Object>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        dataFrame.getColumn(5);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFramegetLineCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<Object>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<Object>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        assertEquals("column 1", new ArrayList<Object>(Arrays.asList("E","F", "G", "H")), dataFrame.getLigne(0));
        assertEquals("column 2", new ArrayList<Object>(Arrays.asList("I","J", "K", "L")), dataFrame.getLigne(1));
	}

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsExceptionDataFrameGetLineCorrect() {
        ArrayList<String> column = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        ArrayList<ArrayList<Object>> table = new ArrayList<>();
        for(int i = 0; i < lines.length; i++){
            table.add(new ArrayList<Object>(Arrays.asList(lines[i])));
        }
        DataFrame dataFrame = new DataFrame(table, column);
        assertEquals("column 1", new ArrayList<Object>(Arrays.asList("E","F", "G", "H")), dataFrame.getLigne(3));
	}
}

package devops;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class DataFrameTest 
{
    private static final int DEFAULT_TIMEOUT = 2000;

    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFrameStringFromArrayTest()
    {
        String[] column = {"A", "B", "C", "D"};
        String[][] lines = {{"E", "F", "G", "H"},{"I","J","K","L"}};
        DataFrame dataFrame = new DataFrame(column, lines);
    }


    @Test(timeout = DEFAULT_TIMEOUT)
    public void DataFrameStringEqualsTest()
    {
        String[] c = {"a", "b"};
        String[][] l = {{"aa","bb"},{"cc","dd"}};
        DataFrame dfarray = new DataFrame(c, l);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File test = new File("src/test/resources/test.csv");
        try {
            DataFrame dffile = new DataFrame(test);
            assertTrue("Dataframes are different", dfarray.equals(dffile));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

package devops;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class DataFrameTest 
{
    @Test
    public void DataFrameComparisonTest()
    {
        String[] c = {"a", "b"};
        String[][] l = {{"aa","bb"},{"cc","dd"}};
        DataFrame dfarray = new DataFrame(c, l);
        File test = new File("pelican/src/main/java/devops/test.csv");
        try {
            DataFrame dffile = new DataFrame(test);
            assertTrue("Dataframes are different", dfarray.equals(dffile));
        } catch (IOException e) {
            assertTrue("File not found", false);
        }
    }
}

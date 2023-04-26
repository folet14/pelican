package devops;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String[] c = {"a", "b"};
        String[][] l = {{"aa","bb"},{"cc","dd"}};
        //DataFrame df = new DataFrame(c, l);
        File test = new File("src/main/java/devops/test.csv");
        DataFrame df2 = new DataFrame(test);
    }
}

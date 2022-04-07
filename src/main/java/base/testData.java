package base;

import org.testng.annotations.DataProvider;

public class testData {


    @DataProvider(name = "user&pass")
    public Object[][] getData() {
        Object[][] data = new Object[1][2];
        data[0][0] = "kiki.ritki123@gmail.com";
        data[0][1] = "bogdanci1";
        return data;
    }
    @DataProvider(name = "emailReset")
    public Object[][] getEmail(){
        return new Object[][]{
                {"testitytt@gmail.com"}
        };
    }
}

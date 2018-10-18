package day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Class1 {


    @DataProvider(name = "dataProviderName")
    public Object [] [] createData1() {
        return new Object[][]{
                {"X", 36},
                {"Y", 36},
                {"Z ", 36}
        }
    }

    @Test(dataProvider = "dataProviderName")
    public void verifyData1(String n1, int n2) {
        System.out
    }


}

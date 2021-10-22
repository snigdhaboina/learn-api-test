package dataProvider;

import org.testng.annotations.DataProvider;

public class InputDataProviderClass {

    @DataProvider(name = "DataToCreate")
    Object[][] dataForPush(){
        /*Object[][] obj = new Object[2][4];
        obj[0][0] = "Snigdha" ;
        obj[0][1] = "Boina" ;
        obj[0][2] = "1" ;
        obj[0][3] = "4" ;

        obj[1][0] = "Sri" ;
        obj[1][1] = "Lasya" ;
        obj[1][2] = "2" ;
        obj[1][3] = "5" ;

        return obj;*/
        return new Object[][] {
                {"Snigdha", "Boina", "1", "6"},
                {"Sri", "Lasya", "2", "7"}
        };

    }

    @DataProvider(name = "dataToDelete")
    Object[] dataForDelete(){
        return new Object[]{"4", "5"};
    }
}

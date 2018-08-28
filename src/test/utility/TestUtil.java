package test.utility;

import java.util.ArrayList;

import excel.utility.Xls_Reader;
public class TestUtil {

	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try{
			reader = new Xls_Reader("/Users/rgupta/eclipse-workspace/SeleniumPractise/src/testdata/DemoqaTestData.xlsx");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(int rowCnt=2; rowCnt<=reader.getRowCount("RegTestData"); rowCnt++){
			
			String firstName = reader.getCellData("RegTestData", "firstName", rowCnt);
			String lastName = reader.getCellData("RegTestData", "lastName", rowCnt);
			String phoneNumber = reader.getCellData("RegTestData", "phoneNumber", rowCnt);
			String userName = reader.getCellData("RegTestData", "userName", rowCnt);
			String email = reader.getCellData("RegTestData", "email", rowCnt);
			String password = reader.getCellData("RegTestData", "password", rowCnt);
			String confirmPassword = reader.getCellData("RegTestData", "confirmPassword", rowCnt);
			
			reader.setCellData("RegTestData", "status", rowCnt, "Pass"); //write data into excel sheet
			
			Object ob[] = {firstName, lastName,phoneNumber, userName, email, password, confirmPassword};
			myData.add(ob);
		}
		return myData;
	}
}

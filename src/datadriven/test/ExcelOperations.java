package datadriven.test;

import excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		Xls_Reader reader = new Xls_Reader(
				"/Users/rgupta/eclipse-workspace/SeleniumPractise/src/testdata/EbayTestData.xlsx");
/*		if(!reader.addSheet("HomePage")){
			reader.addSheet("HomePage");
		}*/
	int colCount = reader.getColumnCount("RegTestData");
	System.out.println("Total no.of columns in excel sheet: "+colCount);
	System.out.println(reader.getCellRowNum("RegTestData", "lastname", "James"));
	}

}

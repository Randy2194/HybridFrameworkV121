package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
//logindata
	
	@DataProvider(name="loginData")
	public String[][] getExcelData() throws IOException{
		String path=".\\testData\\dataSheet.xlsx";
		ExcelUtils util=new ExcelUtils(path);
		int totalrows=util.getRowCount("Sheet1");
		int totalcols=util.getCellCount("Sheet1", 1);
		
		String[][] loginData=new String[totalrows][totalcols];
		
	   for(int i=1;i<=totalrows;i++) {
		   for(int j=0;j<totalcols;j++) {
			   loginData[i-1][j]=util.getCellData("Sheet1", i, j);
		   } 
	   }
	   return loginData;
	
	}
      
}

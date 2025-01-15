package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.DateFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public FileInputStream finput;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cells;
	
	String path;
	public ExcelUtils(String path) {
		this.path=path;
	} 
	
	public int getRowCount(String sheetName) throws IOException {
		finput=new FileInputStream(path);
		workbook=new XSSFWorkbook(finput);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		finput.close();
		return rowcount;
			
	}
	public int getCellCount(String sheetName,int rownum) throws IOException {
		finput=new FileInputStream(path);
		workbook=new XSSFWorkbook(finput);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		finput.close();
		return cellcount;		
	}

	public String getCellData(String sheetName,int rownum,int colnum) throws IOException {
		finput=new FileInputStream(path);
		workbook=new XSSFWorkbook(finput);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cells=row.getCell(colnum);
		String data;
		DataFormatter format=new DataFormatter();
		try {
			data=format.formatCellValue(cells);
		}
		catch(Exception e)
		{
			System.out.println(e);
			data="";
		}
		return data;
	}
}

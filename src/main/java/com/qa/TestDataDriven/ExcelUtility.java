package com.qa.TestDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	public static String getCellData(String sheetname, int rowno, int cellno) throws IOException 
	{

		File src= new File("C:\\Users\\KUMAPATH\\eclipse-workspace\\Magento\\src\\main\\java\\com\\qa\\TestData\\RegisterData.xlsx");
		FileInputStream file=new FileInputStream(src);
		XSSFWorkbook work=new XSSFWorkbook(file);
		XSSFSheet sheet1=work.getSheet(sheetname);
		XSSFRow row=sheet1.getRow(rowno);
		XSSFCell cell=row.getCell(cellno);
	
		
		String cellvalue = "" + cell.getStringCellValue();
		System.out.println(cellvalue);
		return cellvalue;
	}
	
	public static String writeCellData(String sheetname,int rowno,int cellno) throws IOException
	{
		File src= new File( "C:\\Users\\KUMAPATH\\eclipse-workspace\\Magento\\src\\main\\java\\com\\qa\\TestData\\RegisterData.xlsx");
		FileInputStream file=new FileInputStream(src);
		XSSFWorkbook work=new XSSFWorkbook(file);
		XSSFSheet sheet1=work.getSheetAt(0);
		
		sheet1.getRow(0).createCell(2).setCellValue("pass");
		sheet1.getRow(1).createCell(2).setCellValue("fail");
		
		FileOutputStream fos=new FileOutputStream(src);
		work.write(fos);
		fos.close();
		return sheetname;
	
		
	}

}

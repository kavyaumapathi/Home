package com.qa.TestDataDriven;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestWrite 
{
	public static void WriteExcel()throws IOException
	{	
		File src=new File("C:\\Users\\KUMAPATH\\eclipse-workspace\\Magento\\src\\main\\java\\com\\qa\\TestData\\RegisterData.xlsx");
		FileInputStream file=new FileInputStream(src);
		XSSFWorkbook work=new XSSFWorkbook(file);
		XSSFSheet sheet1=work.getSheetAt(0);
		
		sheet1.getRow(0).createCell(5).setCellValue("pass");
		sheet1.getRow(1).createCell(5).setCellValue("fail");
		
		FileOutputStream fos=new FileOutputStream(src);
		work.write(fos);
		fos.close();

	}

}

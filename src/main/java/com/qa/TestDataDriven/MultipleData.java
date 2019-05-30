package com.qa.TestDataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MultipleData 
{
	public static void main(String[] args) throws IOException 
	{
		File src=new File("C:\\Users\\KUMAPATH\\eclipse-workspace\\Magento\\src\\main\\java\\com\\qa\\TestData\\RegisterData.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook work=new XSSFWorkbook(fis);
		XSSFSheet sheet2=work.getSheetAt(1);
		
		int rowcount=sheet2.getLastRowNum();
		System.out.println(rowcount);
		
		for(int i=0; i<rowcount; i++)
		{
			String un=sheet2.getRow(i).getCell(0).getStringCellValue();
			String pw=sheet2.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Username has been read from excel sheet"+" "+un);
			System.out.println("Password has been read from excel sheet"+" "+pw);
			System.out.println();
		}
		
		for(int i=1; i<=rowcount; i++)
		{
			sheet2.getRow(i).createCell(2).setCellValue("pass");

		}
		
		FileOutputStream fos=new FileOutputStream(src);		
		work.write(fos);
		work.close();
	}

}


package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getExcelData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./resourse/DataCrm.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String result = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		return result;
	}
	
	public void writeExcelData(String sheet,int row,int cell,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./resourse/DataCrm.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./resourse/DataCrm.xlsx");
		wb.write(fos);
		wb.close();
	}
	
}

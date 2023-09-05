package Selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./resourse/DataCrm.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		String result = w.getSheet("org").getRow(1).getCell(2).toString();
		System.out.println(result);
	}
	
}

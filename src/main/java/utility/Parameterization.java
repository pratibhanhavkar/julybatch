package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {
	
	public static String getStringData(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		
		   FileInputStream file = new FileInputStream("C:\\Users\\prati\\OneDrive\\Desktop\\TestData1.xlsx");
		   
	       String value= WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	       System.out.println(value);
	       return value;
		}

}

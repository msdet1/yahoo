package yahoo_suite;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Yahoo_Prg.Compose;
import Yahoo_Prg.Login;
import Yahoo_Prg.MainClass;

public class SanityTest extends MainClass
{
  @Test	
  @Parameters({"browser"})
  public void sanitytesting(String str)  throws Exception
  {
	  if(str.matches("firefox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  if(str.matches("chrome"))
	  {
		  driver=new ChromeDriver();
	  }
	  FileInputStream fin = new FileInputStream("D:\\sel_dec18\\TestCases.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(fin);   //workbook in the file
	  XSSFSheet ws = wb.getSheet("sanitytest");   /// in workbook get the sheet
	
	  String classname,methodname;
	  Row row;
	  for(int r=1;r<=ws.getLastRowNum();r++)   // for all the rows in the sheet
	  {
		row=ws.getRow(r);
		if(row.getCell(5).getStringCellValue().matches("yes"))
		{
			classname=row.getCell(3).getStringCellValue();
			methodname=row.getCell(4).getStringCellValue();
			Class c=Class.forName(classname);   //load the class into memory
			Method m=c.getMethod(methodname,null);   //get method in the class
			Object obj=c.newInstance();  //create instance for the class
			m.invoke(obj,null);			
		}
	  }
	  fin.close();	  
	 
  }
}

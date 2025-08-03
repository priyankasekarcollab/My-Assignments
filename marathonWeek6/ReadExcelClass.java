package marathonWeek6;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelClass {
	
	public static String[][] passData() throws IOException {
		XSSFWorkbook wb= new XSSFWorkbook("./data/CreateAccount.xlsx");
		XSSFSheet ws = wb.getSheetAt(0);
		int rowcount = ws.getLastRowNum();
		int colcount = ws.getRow(1).getLastCellNum();
		String[][] data=new String[rowcount][colcount];
		for (int i = 0; i < rowcount; i++) {
			String stringCellValue = ws.getRow(i+1).getCell(0).getStringCellValue();
			data[i][0]=stringCellValue;
		}
		
		wb.close();
		return data;

	}

}

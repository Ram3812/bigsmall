package com.mindtree.utilities;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcell {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;

	public static Object[][] getCorpDetailes(String XlsFile) {
		try {
			FileInputStream FIS = new FileInputStream(XlsFile);
			workbook = new XSSFWorkbook(FIS);
		} catch (Exception e) {
			System.out.println("Excell File NOT found  " + e.getLocalizedMessage());
		}
		sheet = workbook.getSheetAt(0);
		Object[][] data = new Object[1][4];
		Iterator<Row> rows = sheet.iterator();
		Row Reqrow = null;
		boolean con = true;
		while (rows.hasNext() && con) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			Cell cell = null;
			while (cells.hasNext()) {
				cell = cells.next();
				if(cell.getStringCellValue().equalsIgnoreCase("Name")) {
					Reqrow = rows.next();
					con = false;
					break;
				}
			}
		}
		int i = 0;
		Iterator<Cell> cells = Reqrow.cellIterator();
		while(cells.hasNext()) {
			Cell cell = cells.next();
			if(i != 2)
				data[0][i] = cell.getStringCellValue();
			else
				data[0][i] = String.format("%.0f", cell.getNumericCellValue());
			i++;
		}
		return data;
	}
}

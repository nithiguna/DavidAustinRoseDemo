package utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelFileReader1 {

	private int totalRow;

	private static Map<String, List<Map<String, String>>> excelSheetMap = new HashMap<String, List<Map<String, String>>>();

	private static ExcelFileReader1 excelFileReader = null;

	private ExcelFileReader1() {

	}

	public static ExcelFileReader1 getInstance() {
		if (excelFileReader != null) {
			return excelFileReader;
		} else {
			excelFileReader = new ExcelFileReader1();
			return excelFileReader;
		}
	}

//	@DataProvider(name="Login")
	public List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws EncryptedDocumentException, IOException, Exception {
		// Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
		// Sheet sheet = workbook.getSheet(sheetName);

		List<Map<String, String>> listData = excelSheetMap.get(sheetName);
		File file = new File(excelFilePath);
		XSSFWorkbook workbook = null;

		if (listData != null) {
			return listData;
		} else {
			try {
				synchronized (this) {
					if (file.exists()) {
						workbook = new XSSFWorkbook(file);
						Sheet sheet = workbook.getSheet(sheetName);
						listData = readSheet(sheet);
						excelSheetMap.put(sheetName, listData);
						workbook.close();
					}
				}
			} catch (Exception e) {
				System.out.println("Exception :" + e);
				throw e;
			}
			return listData;
		}
	}

	private List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		Cell cell;
		totalRow = sheet.getLastRowNum();
		// System.out.println("Total row "+totalRow);
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
			row = sheet.getRow(currentRow);
			// System.out.println("Current Row" + currentRow + ", Row = " + row);
			int totalColumn = row.getLastCellNum();

			// System.out.println("Value" + totalColumn);

			LinkedHashMap<String, String> columnnMapdata = new LinkedHashMap<String, String>();
			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
				cell = row.getCell(currentColumn);
				String ColumnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();// Getting column name for given column index.
				// System.out.println("ColumnHeader" +ColumnHeaderName);
				columnnMapdata.put(ColumnHeaderName, cell.getStringCellValue());
			}
			excelRows.add(columnnMapdata);
		}
		return excelRows;
	}

	public int countRow() {
		return totalRow;
	}

}

//private int totalRow;
//public List<Map<String, String>> getData(String excelFilePath, String sheetName)
//		throws EncryptedDocumentException, IOException {
//	Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
//	Sheet sheet = workbook.getSheet(sheetName);
//	workbook.close();
//	return readSheet(sheet);
//}
//
//
//private List<Map<String, String>> readSheet(Sheet sheet) {
//	Row row;
//	Cell cell;
//	totalRow = sheet.getLastRowNum();
//	List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
//	for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
//		row = sheet.getRow(currentRow);
//		int totalColumn = row.getLastCellNum();
//		LinkedHashMap<String, String> columnnMapdata = new LinkedHashMap<String, String>();
//		for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
//			cell = row.getCell(currentColumn);
//			String ColumnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
//					.getStringCellValue();// Getting column name for given column index.
//			columnnMapdata.put(ColumnHeaderName, cell.getStringCellValue());
//		}
//		excelRows.add(columnnMapdata);
//	}
//	return excelRows;
//}
//public int countRow() {
//	return totalRow;
//}


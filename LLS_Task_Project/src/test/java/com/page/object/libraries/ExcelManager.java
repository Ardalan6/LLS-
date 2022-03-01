package com.page.object.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	final static Logger logger = Logger.getLogger(ExcelManager.class);

	private static String filePath;
	private static Workbook wb;
	private static Sheet sh;

	/***
	 * Constructor method 1
	 * 
	 * @param excelFile
	 * @param sheetName
	 */
	public ExcelManager(String excelFile, String sheetName) {
		try {
			File excelDataFile = new File(excelFile);
			filePath = excelDataFile.getAbsolutePath();
			logger.info("Reading Excel File ---> " + filePath);
			FileInputStream fs = new FileInputStream(excelDataFile);
			wb = getWorkbook(fs, filePath);
			sh = wb.getSheet(sheetName);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	/***
	 * Constructor method 2
	 * 
	 * @param excelFile
	 * @param sheetIndex
	 */
	public ExcelManager(String excelFile, int sheetIndex) {
		try {
			File excelDataFile = new File(excelFile);
			filePath = excelDataFile.getAbsolutePath();
			logger.info("Reading Excel File ---> " + filePath);
			FileInputStream fs = new FileInputStream(excelDataFile);
			wb = getWorkbook(fs, filePath);
			sh = wb.getSheetAt(sheetIndex);
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	/***
	 * Helper method to read .xlsx & .xls excel files
	 * 
	 * @param fis
	 * @param excelFilePath
	 * @return Workbook object
	 */
	private Workbook getWorkbook(FileInputStream fis, String excelFilePath) {
		Workbook workbook = null;
		try {
			if (excelFilePath.toLowerCase().endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(fis);

			} else if (excelFilePath.toLowerCase().endsWith(".xls")) {
				workbook = new HSSFWorkbook(fis);

			} else {
				throw new IllegalArgumentException("The specified file is not Excel data file.");
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return workbook;
	}

	// This method is for reading a single cell by row/col index.
	public String readExcelDataCell(int rowIndex, int colIndex) {
		String cellData = null;
		try {
			Row row = sh.getRow(rowIndex);
			if (row != null) {
				Cell cell = row.getCell(colIndex);
				cellData = formatDataCellToString(cell);
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return cellData;
	}

	private String formatDataCellToString(Cell cell) {
		String cellString = null;
		try {
			DataFormatter formatter = new DataFormatter();
			cellString = formatter.formatCellValue(cell);

		} catch (Exception e) {
			logger.error("Error: ", e);
		}

		return cellString;
	}

	public String[][] getExcelData() {
		String[][] arrayExcelData = null;
		try {
			Iterator<Row> iterator = sh.iterator();
			Row tempRow = sh.getRow(0);
			if (tempRow != null) {
				int totalCols = tempRow.getPhysicalNumberOfCells();
				int totalRows = sh.getPhysicalNumberOfRows();
				arrayExcelData = new String[totalRows - 1][totalCols];
				int iRowCount = 0;

				while (iterator.hasNext()) {
					Row row = iterator.next();
					// skipping row 1, because it's table header info
					if (iRowCount > 0) {
						Iterator<Cell> colIterator = row.iterator();
						int iColCount = 0;
						while (colIterator.hasNext()) {
							Cell cell = colIterator.next();
							// need to format the cells before read it as a String
							String data = formatDataCellToString(cell);
							arrayExcelData[iRowCount - 1][iColCount] = data;
							logger.info("Row: " + iRowCount + ", Col: " + iColCount + ", Data: " + data);
							iColCount++;
						}
					}
					iRowCount++;
				}
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
		}

		return arrayExcelData;
	}


}

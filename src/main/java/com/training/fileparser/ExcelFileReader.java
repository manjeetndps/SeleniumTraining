/**
 * Author:- Manjeet Kumar
 */

package com.training.fileparser;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	static Workbook objWorkbook = null;
	static Sheet objSheet = null;

	public static Map<String, String> objNewMap = new HashMap<String, String>();
	public static Map<String, Map<String, String>> objMap1 = new HashMap<String, Map<String, String>>();

	public static Map<String, Map<String, String>> readTestData(String strDataSheetPath, String strSheetName) {
		try {
			File objpath = new File(strDataSheetPath);
			FileInputStream fis = new FileInputStream(objpath);
			String strFilePath = objpath.toString();

			if (strFilePath.toLowerCase().endsWith(".xlsx")) {
				objWorkbook = new XSSFWorkbook(fis);
			} else if (strFilePath.toLowerCase().endsWith(".xls")) {
				objWorkbook = new HSSFWorkbook(fis);
			}

			objSheet = objWorkbook.getSheet(strSheetName);

			int intRowCount = objSheet.getLastRowNum();

			Row objFirstRow = objSheet.getRow(0);

			int intColCount = objFirstRow.getLastCellNum();

			for (int intRowCounter = 1; intRowCounter <= intRowCount; intRowCounter++) {
				Row objRow = objSheet.getRow(intRowCounter);
				Map<String, String> objMap = new HashMap<String, String>();
				for (int intColCounter = 1; intColCounter <= intColCount; intColCounter++) {
					Cell objCellColName = objFirstRow.getCell(intColCounter - 1);

					String strKey = gFunc_ReadCellValue(objCellColName);

					Cell objCellColValue = objRow.getCell(intColCounter - 1);

					String strValue = gFunc_ReadCellValue(objCellColValue);

					if (strValue != null && strValue.length() != 0) {
						objMap.put(strKey, strValue);
					}
				}
				objMap1.put("Row" + intRowCounter, objMap);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return objMap1;
	}

	public static String gFunc_ReadCellValue(Cell cell) {
		String strResult = "";
		try {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				strResult = "";
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				strResult = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_ERROR:
				strResult = String.valueOf(cell.getErrorCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				strResult = NumberToTextConverter.toText(cell.getNumericCellValue());
				if (strResult.endsWith(".0")) {
					strResult = strResult.replace(".0", "");
				}
				break;
			case Cell.CELL_TYPE_STRING:
				strResult = cell.getStringCellValue();
				break;
			default:
				strResult = "";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return strResult;
	}

}

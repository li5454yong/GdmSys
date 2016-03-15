package com.lxg.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import com.lxg.entity.User;

/**
 * Excel导入工具 创建日期：2015-2-3下午2:34:44
 * 
 */
public class Excel {
	private final String EXTENSION_XLS = "xls";
	private final String EXTENSION_XLSX = "xlsx";

	/**
	 * 根据路径读取指定的excel文件
	 * 
	 * @param filePath
	 * @return
	 */
	private Workbook getWorkbook(FileInputStream is,String fileName) {
		Workbook workbook = null;
		//InputStream is;
		try {
			//is = new FileInputStream(filePath);
			if (fileName.endsWith(EXTENSION_XLS)) {
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith(EXTENSION_XLSX)) {
				workbook = new XSSFWorkbook(is);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return workbook;
	}

	/**
	 * 
	 * @param file1
	 * @throws FileNotFoundException
	 * @throws FileFormatException
	 */
	private void preReadCheck(String file1) throws FileNotFoundException,
			FileFormatException {

		File file = new File(file1);
		if (!file.exists()) {
			throw new FileNotFoundException("文件不存在" + file1);
		}

		if (!(file1.endsWith(EXTENSION_XLS) || file1.endsWith(EXTENSION_XLSX))) {
			throw new FileFormatException("导入文件不是excel");
		}
	}

	/**
	 * 
	 * 
	 * @param file1
	 * @return
	 * @throws FileNotFoundException
	 * @throws FileFormatException
	 */
	public List<User> readExcel(FileInputStream in,String fileName)
			throws FileNotFoundException, FileFormatException {

		List<User> list = new ArrayList<User>();
		
		//preReadCheck(file1);

		Workbook workbook = null;

		workbook = getWorkbook(in,fileName);

		for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
			Sheet sheet = workbook.getSheetAt(numSheet);
			if (sheet.getLastRowNum() == 0) {
				break;
			}

			int firstRowIndex = sheet.getFirstRowNum();
			int lastRowIndex = sheet.getLastRowNum();

			Row firstRow = sheet.getRow(firstRowIndex);
			for (int i = firstRow.getFirstCellNum(); i < firstRow
					.getLastCellNum(); i++) {
				Cell cell = firstRow.getCell(i);
				String cellValue = getCellValue(cell, true);
			}
			
			for (int rowIndex = firstRowIndex + 1; rowIndex <= lastRowIndex; rowIndex++) {
				Row currentRow = sheet.getRow(rowIndex);
				int firstColumnIndex = currentRow.getFirstCellNum();
				int lastColumnIndex = currentRow.getLastCellNum();
				User u = new User();
				for (int columnIndex = firstColumnIndex; columnIndex <= lastColumnIndex - 1; columnIndex++) {
					Cell currentCell = currentRow.getCell(columnIndex);
					String currentCellValue = getCellValue(currentCell,
							true);
					
					switch (columnIndex) {
					case 0:
						u.setStu_num(currentCellValue);
						break;
					case 1:
						u.setPasswd(currentCellValue);
						break;
					case 2:
						u.setName(currentCellValue);
						break;
					case 3:
						u.setPower(Integer.parseInt(currentCellValue));
						break;
					}
					
				}
				list.add(u);
				}
		}
		return list;
	}

	private String getCellValue(Cell cell, boolean treatAsStr) {
		if (cell == null) {
			return "";
		}

		if (treatAsStr) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}

		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else {
			return String.valueOf(cell.getStringCellValue());
		}
	}

}

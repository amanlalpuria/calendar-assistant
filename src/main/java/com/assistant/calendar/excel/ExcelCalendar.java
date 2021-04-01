package com.assistant.calendar.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.assistant.calendar.model.Calendar;

public class ExcelCalendar {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Timestamp", "Title", "Description", "Start Time", "End Time", "Required", "Optional" };
	static String SHEET = "Calendar";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Calendar> excelToCalendar(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);
			 Sheet datatypeSheet = workbook.getSheetAt(0);
			String sheetName = workbook.getSheetName(0);
			Sheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> rows = sheet.iterator();

			List<Calendar> Calendars = new ArrayList<Calendar>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Calendar calendar = new Calendar();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						calendar.setTimestamp(currentCell.getDateCellValue());
						break;

					case 1:
						calendar.setTitle(currentCell.getStringCellValue());
						break;

					case 2:
						calendar.setDescription(currentCell.getStringCellValue());
						break;

					case 3:
						calendar.setStart_time(currentCell.getDateCellValue());
						break;

					case 4:
						calendar.setEnd_time(currentCell.getDateCellValue());
						break;

					case 5:
						calendar.setRequired(currentCell.getStringCellValue());
						break;

					case 6:
						calendar.setOptional(currentCell.getStringCellValue());
						break;

					default:
						break;
					}

					cellIdx++;
				}

				Calendars.add(calendar);
			}

			workbook.close();

			return Calendars;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

}

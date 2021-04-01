package com.assistant.calendar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.assistant.calendar.excel.ExcelCalendar;
import com.assistant.calendar.message.ResponseMessage;
import com.assistant.calendar.model.Calendar;

//@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/api/excel")
public class CalendarController {

	// @Autowired
	// ExcelService fileService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		List<Calendar> calendar = new ArrayList<Calendar>();
		if (ExcelCalendar.hasExcelFormat(file)) {
			try {
				calendar = ExcelCalendar.excelToCalendar(file.getInputStream());

				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(calendar));
			} catch (Exception e) {
				 message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				 return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(calendar));
			}
		}

		 message = "Please upload an excel file!";
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(calendar));
	}

}

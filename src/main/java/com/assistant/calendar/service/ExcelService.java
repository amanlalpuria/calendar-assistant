package com.assistant.calendar.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.assistant.calendar.excel.ExcelCalendar;
import com.assistant.calendar.model.Calendar;
import com.assistant.calendar.repository.CalendarRepository;

@Service
public class ExcelService {

	@Autowired
	  CalendarRepository repository;

	  public void save(MultipartFile file) {
	    try {
	      List<Calendar> tutorials = ExcelCalendar.excelToCalendar(file.getInputStream());
	      repository.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<Calendar> getAllTutorials() {
	    return repository.findAll();
	  }
}

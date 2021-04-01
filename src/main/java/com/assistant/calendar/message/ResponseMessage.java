package com.assistant.calendar.message;

import java.util.List;
import java.util.stream.Collectors;

import com.assistant.calendar.model.Calendar;

public class ResponseMessage {

	private List<Calendar> message;

	public ResponseMessage(List<Calendar> calendar) {
		this.message = calendar;
	}

//	public ResponseMessage(List<Calendar> calendar) {
//		// TODO Auto-generated constructor stub
//		String result = calendar.stream()
//			      .map(n -> String.valueOf(n))
//			      .collect(Collectors.joining("-", "{", "}"));
//		return result;
//	}

	public List<Calendar> getMessage() {
		return message;
	}

	public void setMessage(List<Calendar> message) {
		this.message = message;
	}

}

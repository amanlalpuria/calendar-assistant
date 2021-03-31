package com.assistant.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assistant.calendar.model.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Long>{

}

package com.capg.hcs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.capg.hcs.exception.AppointmentAlreadyApprovedException;
import com.capg.hcs.exception.AppointmentAlreadyDisapprovedException;
import com.capg.hcs.exception.AppointmentNotFoundException;
import com.capg.hcs.exception.SlotNotAvailableException;

/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     
-Description              :     

*******************************************************************************************************************************/

@ControllerAdvice
@RestController
public class ExceptionAppointmentAdvisor {
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Appointment not found", code = HttpStatus.NOT_FOUND)
	public void handleAppointmentNotFoundException() {

		//To handle Appointment not found exception
	}
	
	@ExceptionHandler(AppointmentAlreadyApprovedException.class)
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "Appointment Already Approved")
	public void handleAppointmentAlreadyApprovedException() {

		//To handle Appointment already approved exception
	}
	
	@ExceptionHandler(AppointmentAlreadyDisapprovedException.class)
	//@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "Appointment Already Disapproved")
	public ResponseEntity<String> handleAppointmentAlreadyDisapprovedException(Exception exception) {
		
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.ALREADY_REPORTED);

	}
	
	@ExceptionHandler(SlotNotAvailableException.class)
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED,reason = "This slot is not available",code=HttpStatus.ALREADY_REPORTED)
	public void handleSlotNotAvailableException() {
		//To handle slot not available exception
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You have entered invalid data", code = HttpStatus.BAD_REQUEST)
	public void handleInvalidData() {

		//To handle bad requests
	}
	

	
	

}

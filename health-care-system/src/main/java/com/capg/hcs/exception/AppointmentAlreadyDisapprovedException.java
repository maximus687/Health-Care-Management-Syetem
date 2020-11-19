package com.capg.hcs.exception;
/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     
-Description              :     

*******************************************************************************************************************************/

@SuppressWarnings("serial")
public class AppointmentAlreadyDisapprovedException extends RuntimeException {
	
	String message;
	String status;

	public AppointmentAlreadyDisapprovedException(String errorMessage) {
		
		super(errorMessage);
	}

	public AppointmentAlreadyDisapprovedException(String message, String status) {
		this.message = message;
		this.status = status;
	}

}

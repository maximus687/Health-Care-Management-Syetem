package com.capg.hcs.exception;
/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     
-Description              :     

*******************************************************************************************************************************/

@SuppressWarnings("serial")
public class AppointmentNotFoundException extends RuntimeException {
	
	public AppointmentNotFoundException(String message) {
		super(message);
	}

}

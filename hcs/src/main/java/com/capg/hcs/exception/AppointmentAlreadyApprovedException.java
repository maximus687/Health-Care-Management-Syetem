package com.capg.hcs.exception;
/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     
-Description              :     

*******************************************************************************************************************************/

@SuppressWarnings("serial")
public class AppointmentAlreadyApprovedException extends RuntimeException {
	
	public AppointmentAlreadyApprovedException(String message)
	{
		super(message);
	}

}

package com.capg.hcs.service;

import java.math.BigInteger;
import java.util.List;

import com.capg.hcs.entity.AppointmentManagement;
import com.capg.hcs.entity.Status;

/*******************************************************************************************************************************
 * -Author                : Mohammad Ikram 
 * -Created/Modified Date : 15-11-2020 
 * -Description :
 * 
 *******************************************************************************************************************************/

public interface IAppointmentService {

	AppointmentManagement makeAppointment(AppointmentManagement appointment);

	boolean removeAppointmentById(BigInteger appointmentId);

	AppointmentManagement viewAppointment(BigInteger appointmentId);

	List<AppointmentManagement> getAllAppointments(String centreId);

	AppointmentManagement approveAppointment(AppointmentManagement appointment, Status status);

	AppointmentManagement disapproveAppointment(AppointmentManagement appointment, Status status);

}

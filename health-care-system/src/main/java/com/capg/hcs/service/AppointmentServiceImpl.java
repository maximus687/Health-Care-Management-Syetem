package com.capg.hcs.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcs.entity.AppointmentManagement;
import com.capg.hcs.entity.Status;
import com.capg.hcs.exception.AppointmentAlreadyApprovedException;
import com.capg.hcs.exception.AppointmentAlreadyDisapprovedException;
import com.capg.hcs.exception.AppointmentNotFoundException;
import com.capg.hcs.exception.SlotNotAvailableException;
import com.capg.hcs.repository.IAppointmentRepo;

/*******************************************************************************************************************************
 * -Author                :    Mohammad Ikram 
 * -Created/Modified Date :    16-11-2020
 * -Description :   
 * 
 *******************************************************************************************************************************/
@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	IAppointmentRepo appointmentRepo;

	@Override
	public AppointmentManagement makeAppointment(AppointmentManagement appointment) {
		LocalTime time = appointment.getDateTime().toLocalTime();
		if ((appointmentRepo.getAppointmentByDateTimeAndTestId(appointment.getDateTime(),
				appointment.getTestId())!=null)
				|| appointment.getDateTime().isBefore(LocalDateTime.now().plusHours(1))
				|| appointment.getDateTime().isAfter(LocalDateTime.now().plusMonths(3))
				|| time.isBefore(LocalTime.of(6, 59)) || time.isAfter(LocalTime.of(21, 00))) {
			throw new SlotNotAvailableException("This slot is not available");
		}
		appointment.setStatus(Status.pending);
		return appointmentRepo.save(appointment);
	}

	@Override
	public AppointmentManagement viewAppointment(BigInteger appointmentId) {
        
		
		if (!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id: " + appointmentId + " not found");
		}
		return appointmentRepo.getOne(appointmentId);

	}

	@Override
	public AppointmentManagement approveAppointment(AppointmentManagement appointment, Status status) {

		if (appointment.getStatus() == Status.approved) {
			throw new AppointmentAlreadyApprovedException(
					"Appointment with Id :" + appointment.getAppointmentId() + " is Already Approved");
		}
		appointment.setStatus(status);

		return appointmentRepo.save(appointment);

	}
	
	@Override
	public AppointmentManagement disapproveAppointment(AppointmentManagement appointment, Status status) {

		if (appointment.getStatus() == Status.disapproved) {
			throw new AppointmentAlreadyDisapprovedException(
					"Appointment is Already Disapproved");
		}
		appointment.setStatus(status);

		return appointmentRepo.save(appointment);

	}
	
	@Override
	public boolean removeAppointmentById(BigInteger appointmentId) {
		
		if(!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id: " + appointmentId + " not found");
		}
		appointmentRepo.deleteById(appointmentId);
		return true;
	}

	@Override
	public List<AppointmentManagement> getAllAppointments(String centreId) {
		
		if(appointmentRepo.findAll(centreId).isEmpty()) {
			throw new AppointmentNotFoundException("Appointment list is empty");
		}
		
		 List<AppointmentManagement> allAppointments = appointmentRepo.findAll(centreId);
		 return allAppointments;
		
	}

}

package com.capg.hcs.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcs.entity.AppointmentManagement;
import com.capg.hcs.entity.Status;
import com.capg.hcs.service.IAppointmentService;

/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     17-11-2020
-Description              :     

*******************************************************************************************************************************/
@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
	
	@Autowired
	public IAppointmentService appointmentService;
	
	@PostMapping("/makeappointment")
	public AppointmentManagement makeAppointment(@RequestBody AppointmentManagement appointment) {
		return appointmentService.makeAppointment(appointment);
	}
	
	@GetMapping("/viewAppointment/{appointmentId}")
	public ResponseEntity<AppointmentManagement> viewAppointment(@PathVariable BigInteger appointmentId ){
		return new ResponseEntity<AppointmentManagement>(appointmentService.viewAppointment(appointmentId), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/removeappointment/{appointmentId}")
	public ResponseEntity<?> removeAppointment(@PathVariable BigInteger appointmentId){
		return new ResponseEntity<>(appointmentService.removeAppointmentById(appointmentId),HttpStatus.OK);
	}
	
	@GetMapping("/getAllAppointments/{centreId}")
	public ResponseEntity<List<AppointmentManagement>> getAllAppointments(@PathVariable String centreId ){
		return new ResponseEntity<List<AppointmentManagement>>(appointmentService.getAllAppointments(centreId),HttpStatus.OK);
	}
	
	@GetMapping("/approveAppointment/{appointmentId}/{status}")
	public AppointmentManagement approveAppoinment(@PathVariable BigInteger appointmentId, @PathVariable Status status) {
		AppointmentManagement appointment = appointmentService.viewAppointment(appointmentId);
		return appointmentService.approveAppointment(appointment, status);
	}
	
	@GetMapping("/disapproveAppointment/{appointmentId}/{status}")
	public AppointmentManagement disapproveAppoinment(@PathVariable BigInteger appointmentId, @PathVariable Status status) {
		AppointmentManagement appointment = appointmentService.viewAppointment(appointmentId);
		return appointmentService.approveAppointment(appointment, status);
	}
	

}
